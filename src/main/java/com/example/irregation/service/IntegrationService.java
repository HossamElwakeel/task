package com.example.irregation.service;


import com.example.irregation.model.Config;
import com.example.irregation.model.Trans;
import com.example.irregation.repository.ConfigRepository;
import com.example.irregation.repository.TransRepository;
import net.bytebuddy.agent.builder.AgentBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IntegrationService {


    TransService sensorsService;
    @Autowired
    ConfigRepository configRepository;
    @Autowired
    TransRepository transRepository;

@Scheduled(cron = "* * * 1 * *")
    public List<Integer> proj() {
        List<Config> con = configRepository.findByDateRange(Calendar.getInstance().getTime());
        Map<Integer, Integer> tran = transRepository.sumOfIrrPerConfig();
        List<Integer> conWater = new ArrayList<>();


        for (int i = 0; i < con.size(); i++) {
            if (tran.get(con.get(i).getId()) < con.get(i).getNum_irr()) {
                conWater.add(con.get(i).getId());
                Trans trans = new Trans();
                trans.setConfig(con.get(i));
                trans.setStatus(1);
                transRepository.save(trans);
            }

        }

        return conWater;

        // LocalTime currentTime= LocalTime.now();
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
}
