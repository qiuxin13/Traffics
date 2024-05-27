package com.qx.traffic.service;



import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public interface TrafficRecordService {
    /**
     * list[0] 按小时 list[1] 按天 list[2] 按路口编号 list[3] 数据总数
     * @return
     */
   List< Map<Integer, AtomicInteger>> selectAll();

   void selectAll2();
}
