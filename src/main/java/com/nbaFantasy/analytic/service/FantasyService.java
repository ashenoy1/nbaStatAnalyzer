package com.nbaFantasy.analytic.service;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class FantasyService {

    private Map<String,String> playerById;


    //Gets the gameID of everything played today (HARDCODED FOR 10/29)
    public ResponseEntity getTodaysGames(){
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://data.nba.net/10s/prod/v2/20181029/scoreboard.json";
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl, String.class);
        return response;
    }

    //GET BOXSCORE OF SELECT GAME
    public ResponseEntity<String> getBoxScore(String gameId){
        String url =  "http://data.nba.net/10s/prod/v1/20181029/" + gameId + "_boxscore.json";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response
                = restTemplate.getForEntity(url, String.class);
        return response;
    }

    public List<String> getCurrentGameIds() throws Exception{
        ResponseEntity<String> result = getTodaysGames();
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(result.getBody());
        JsonNode games = root.path("games");
        List<String> gamesIds = new ArrayList<>();
        for(JsonNode temp : games){
            gamesIds.add(temp.get("gameId").textValue());
            System.out.println(temp.get("gameId").textValue());
        }
        return gamesIds;
    }


    //"gameId":"0021800091" (Chi VS GSW) 10/29/2018    KD- 201142
    //Get the list of gameIDs and run against that VVV api and grab the best stats

    public void getStats() throws Exception{
        List<String> gameIds = getCurrentGameIds();
        ObjectMapper mapper = new ObjectMapper();
        List<Player> allPlayers = new ArrayList<>();
        for(String temp: gameIds)
        {
            ResponseEntity<String> response = getBoxScore(temp);
            JsonNode root = mapper.readTree(response.getBody());
            JsonNode stats = root.path("stats");
            JsonNode activePlayers = stats.path("activePlayers");
            for(JsonNode iter: activePlayers){
                Player player = mapper.treeToValue(temp, Player.class);
                player.getFantasyScore();
                allPlayers(player);
                //NEED TO GET ALL PLAYER ID
            }


        }
    }

    public void loadPlayerData() throws Exception{
        this.playerById = new HashMap<>();
        String url = "http://data.nba.net/10s/prod/v1/2016/players.json";
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response
                = restTemplate.getForEntity(url, String.class);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());
        JsonNode player = root.get("league").get("standard");
        for(JsonNode temp: player){
            String name = temp.get("firstName").asText() + " " + temp.get("lastName").asText();
            String playerId = temp.get("personId").asText();
            playerById.putIfAbsent(playerId,name);
            System.out.println(name);
        }

    }




    //http://data.nba.net/10s/prod/v1/20181029/0021800091_boxscore.json



}
