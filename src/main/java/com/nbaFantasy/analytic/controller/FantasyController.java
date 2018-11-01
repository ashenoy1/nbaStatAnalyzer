package com.nbaFantasy.analytic.controller;

import com.nbaFantasy.analytic.entity.DisplayPlayer;
import com.nbaFantasy.analytic.service.FantasyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FantasyController {

    private FantasyService service;

    @Autowired
    public FantasyController(FantasyService service) {
        this.service = service;
    }

    @RequestMapping(value="dailyLeader",method = RequestMethod.GET)
    public List<DisplayPlayer> dailyLeader() throws Exception{
        service.loadPlayerData();
        return service.getStats();

    }




    //http://data.nba.net/10s/prod/v1/20181029/0021800091_boxscore.json
}
