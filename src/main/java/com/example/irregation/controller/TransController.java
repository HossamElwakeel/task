package com.example.irregation.controller;
import com.example.irregation.model.Trans;
import com.example.irregation.service.TransService;
import com.example.irregation.service.LandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TransController {
    @Autowired
    TransService transService;


    @RequestMapping(value = "/trans", method = RequestMethod.POST)
    public Trans createTrans(@RequestBody Trans s) {
        return transService.createTrans(s);
    }

    @RequestMapping(value = "/trans", method = RequestMethod.GET)
    public List<Trans> readTrans() {
        return transService.getTrans();
    }

    @RequestMapping(value = "/trans/{trans_id}", method = RequestMethod.PUT)
    public Trans updateTrans(@PathVariable(value = "trans_id") int id, @RequestBody Trans transDetails) {
        return transService.updateTrans(id, transDetails);
    }

    @RequestMapping(value = "/trans/{trans_id}", method = RequestMethod.DELETE)
    public void deleteTrans(@PathVariable(value = "trans_id") int id) {
        transService.deleteTrans(id);
    }


//    @RequestMapping(value = "/autoJobSens", method = RequestMethod.POST)
//    public List<Integer> autoJob(@RequestBody String time) {
//        return lanService.activeSen(time);
//    }
//        @RequestMapping(value = "/autoJobSens", method = RequestMethod.POST)
//    public List<Integer> autoJob() {
//        return lanService.activeSen();
    }

