package com.example.irregation.controller;


import com.example.irregation.model.Land;

import com.example.irregation.service.LandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LandController {
    @Autowired
    LandService lanService;

    @RequestMapping(value = "/land", method = RequestMethod.POST)
    public Land createLand(@RequestBody Land l) {
        return lanService.create(l);
    }

    @RequestMapping(value = "/land", method = RequestMethod.GET)
    public List<Land> readEmployees() {
        return lanService.getLand();
    }

    @RequestMapping(value = "/land/{lands_id}", method = RequestMethod.PUT)
    public Land readEmployees(@PathVariable(value = "lands_id") int id, @RequestBody Land lanDetails) {
        return lanService.updateEmployee(id, lanDetails);
    }

    @RequestMapping(value = "/land/{lands_id}", method = RequestMethod.DELETE)
    public void deleteEmployees(@PathVariable(value = "lands_id") int id) {
        lanService.deleteLands(id);
    }


//    @RequestMapping(value = "/autoJob", method = RequestMethod.POST)
//    public List<Integer> autoJob(@RequestBody String time) {
//        return lanService.proj(time);
//    }

//    @RequestMapping(value = "/autoJob", method = RequestMethod.POST)
//    public List<Integer> autoJob() {
//        return lanService.proj();
//    }

}