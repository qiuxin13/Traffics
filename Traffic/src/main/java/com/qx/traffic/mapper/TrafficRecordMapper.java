package com.qx.traffic.mapper;

import com.qx.traffic.pojo.TrafficRecord;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TrafficRecordMapper {

    @Select("select * from traffic_record ORDER BY id LIMIT 10000 OFFSET #{page}")
    List<TrafficRecord> selectAll(int page);

    @Select("select * from traffic_record ")
    List<TrafficRecord> selectAll2();
}
