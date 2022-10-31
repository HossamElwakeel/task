package com.example.irregation.service;


import com.example.irregation.model.Config;
import com.example.irregation.model.Land;
import com.example.irregation.repository.ConfigRepository;
import com.example.irregation.repository.LandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConfigService {



    @Autowired
    ConfigRepository configRepository;



    // CREATE
    public Config createConfig(Config l) {
        return configRepository.save(l);
    }

    // READ
    public List<Config> getConfig() {
        return configRepository.findAll();
    }

    // DELETE
    public void deleteConfig(int id) {
        configRepository.deleteById(id);
    }

    // UPDATE
    public Config updateConfig(int id, Config configDetails) {
        Config c = configRepository.findById(id).get();
        c.setLand(configDetails.getLand());
        c.setStartDate(configDetails.getStartDate());
        c.setEndDate(configDetails.getEndDate());
        c.setNum_irr(configDetails.getNum_irr());

        return configRepository.save(c);
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
