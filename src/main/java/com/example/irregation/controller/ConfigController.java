package com.example.irregation.controller;
import com.example.irregation.model.Config;
import com.example.irregation.model.Trans;
import com.example.irregation.service.ConfigService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ConfigController {
    @Autowired
    ConfigService configService;



    @RequestMapping(value = "/config", method = RequestMethod.POST)
    public Config createConfig(@RequestBody Config s) {
        return configService.createConfig(s);
    }

    @RequestMapping(value = "/config", method = RequestMethod.GET)
    public List<Config> readConfig() {
        return configService.getConfig();
    }

    @RequestMapping(value = "/config/{config_id}", method = RequestMethod.PUT)
    public Config updateConfig(@PathVariable(value = "config_id") int id, @RequestBody Config configDetails) {
        return configService.updateConfig(id, configDetails);
    }

    @RequestMapping(value = "/config/{config_id}", method = RequestMethod.DELETE)
    public void deleteTrans(@PathVariable(value = "config_id") int id) {
        configService.deleteConfig(id);
    }


//    @RequestMapping(value = "/autoJobSens", method = RequestMethod.POST)
//    public List<Integer> autoJob(@RequestBody String time) {
//        return lanService.activeSen(time);
//    }
//        @RequestMapping(value = "/autoJobSens", method = RequestMethod.POST)
//    public List<Integer> autoJob() {
//        return lanService.activeSen();
    }

