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
import java.util.List;

@Service
public class FantasyService {


    public ResponseEntity getTodaysGames(){
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl = "http://data.nba.net/10s/prod/v2/20181029/scoreboard.json";
        ResponseEntity<String> response
                = restTemplate.getForEntity(fooResourceUrl, String.class);
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

    //Get the list of gameIDs and run against that VVV api and grab the best stats

    public




    //http://data.nba.net/10s/prod/v1/20181029/0021800091_boxscore.json



}
