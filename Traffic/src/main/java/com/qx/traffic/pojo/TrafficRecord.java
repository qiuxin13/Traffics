package com.qx.traffic.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class TrafficRecord {
    private Integer id;
    private Date  time;
    private int roadId;

    public TrafficRecord(Date time, int roadId) {
        this.time = time;
        this.roadId = roadId;
    }

}
