package com.qx.traffic.controller;

import com.qx.traffic.pojo.Result;

import com.qx.traffic.service.TrafficRecordService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TrafficRecordController {

    @Resource
    private TrafficRecordService trafficRecordService;

    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping("/traffic")
    Result selectAll(){
        return Result.success(trafficRecordService.selectAll());
    }
    @GetMapping("/traffic2")
    Result selectAll2(){
        trafficRecordService.selectAll2();
        return Result.success();
    }
}
