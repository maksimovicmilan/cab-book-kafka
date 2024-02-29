package com.milan.cabbookdriver.service;

import com.milan.cabbookdriver.constant.AppConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class CabLocationService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;

    public boolean UpdateLocation(String location) throws InterruptedException {
        kafkaTemplate.send(AppConstant.CAB_LOCATION, location);
        Thread.sleep(1000);
        return true;
    }

}
