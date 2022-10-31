package com.example.irregation.service;



import com.example.irregation.model.Trans;
import com.example.irregation.repository.TransRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransService {

    @Autowired
    TransRepository transRepository;

    // CREATE
    public Trans createTrans(Trans t) {
        return transRepository.save(t);
    }

    // READ
    public List<Trans> getTrans() {
        return transRepository.findAll();
    }

    // DELETE
    public void deleteTrans(int id) {
        transRepository.deleteById(id);
    }

    // UPDATE
    public Trans updateTrans(int id, Trans transDetails) {
        Trans s = transRepository.findById(id).get();
        s.setConfig(transDetails.getConfig());
        s.setStatus(transDetails.getStatus());


        return transRepository.save(s);
    }
}
