package com.example.irregation.service;


import com.example.irregation.model.Land;

import com.example.irregation.repository.LandRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;


import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class LandService {

    @Autowired
    LandRepository lanRepository;


    // CREATE
    public Land create(Land l) {
        return lanRepository.save(l);
    }

    // READ
    public List<Land> getLand() {
        return lanRepository.findAll();
    }

    // DELETE
    public void deleteLands(int id) {
        lanRepository.deleteById(id);
    }

    // UPDATE
    public Land updateEmployee(int id, Land landsDetails) {
        Land l = lanRepository.findById(id).get();
        l.setArea(landsDetails.getArea());
        l.setLocation(landsDetails.getLocation());
        l.setTypeOfSoil(landsDetails.getTypeOfSoil());

        return lanRepository.save(l);
    }

    //proj
//    public List<Integer> proj(String x){
//
//        LocalTime currentTime= LocalTime.parse(x);
//
//        List<Lands> plotOfLan = getLands();
//        List<Integer> ids = new ArrayList<Integer>();
//
//        for(int i= 0 ;i< plotOfLan.size();i++) {
//            if (currentTime.isAfter(LocalTime.parse(plotOfLan.get(i).getStartDate()))&& currentTime.isBefore(LocalTime.parse(plotOfLan.get(i).getEndDate()))){
//                plotOfLan.get(i).setWaterFlag(true);
//                ids.add(plotOfLan.get(i).getId());
//            } else plotOfLan.get(i).setWaterFlag(false);
//        }
//        return ids;
//    }

//    public List<Integer> activeSen(String x){
//        List<Integer> activePlots= proj(x);
//        List<Integer> activeSen = new ArrayList<Integer>();
//        List<Sensors> sen = sensorsService.getSensors();
//        for(int i = 0; i< activePlots.size();i++) {
//            for(int j =0;j< sen.size();j++ ){
//                if(sen.get(j).getIdLand()==activePlots.get(i)){
//                    activeSen.add(sen.get(j).getSensor_id());
//                }
//            }
//        }
//
//        return activeSen;
//    }
//    @Scheduled(fixedRate = 100000)
//    public List<Integer> proj(){
//
//       // LocalTime currentTime= LocalTime.now();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm:ss");
//        Calendar calendar = Calendar.getInstance();
//        String curr = dateFormat.format(calendar.getTime());
//        LocalTime currentTime= LocalTime.parse(curr);
//        System.out.print(curr);
//
//        List<Lands> plotOfLan = getLands();
//        List<Integer> ids = new ArrayList<Integer>();
//
//        for(int i= 0 ;i< plotOfLan.size();i++) {
//            if (currentTime.isAfter(LocalTime.parse(plotOfLan.get(i).getStartDate()))&& currentTime.isBefore(LocalTime.parse(plotOfLan.get(i).getEndDate()))){
//                plotOfLan.get(i).setWaterFlag(true);
//                ids.add(plotOfLan.get(i).getId());
//            } else plotOfLan.get(i).setWaterFlag(false);
//        }
//        return ids;
//    }
//        public List<Integer> activeSen(){
//        List<Integer> activePlots= proj();
//        List<Integer> activeSen = new ArrayList<Integer>();
//        List<Sensors> sen = sensorsService.getSensors();
//        for(int i = 0; i< activePlots.size();i++) {
//            for(int j =0;j< sen.size();j++ ){
//                if(sen.get(j).getIdLand()==activePlots.get(i)){
//                    activeSen.add(sen.get(j).getSensor_id());
//                }
//            }
//        }
//
//        return activeSen;
//    }
}
