package com.qx.traffic.service.imp;

import com.qx.traffic.mapper.TrafficRecordMapper;
import com.qx.traffic.pojo.TrafficRecord;
import com.qx.traffic.service.TrafficRecordService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class TrafficRecordServiceImp implements TrafficRecordService {

    @Resource
    private TrafficRecordMapper trafficRecordMapper;
    private static final int THREAD_COUNT = 50;

    @Override
    public List<Map<Integer, AtomicInteger>> selectAll() {
        List<Map<Integer, AtomicInteger>> re=new ArrayList<>();
        Map<Integer, AtomicInteger> map1 =new ConcurrentHashMap<>();
        Map<Integer, AtomicInteger> map2 =new ConcurrentHashMap<>();
        Map<Integer, AtomicInteger> map3 =  new ConcurrentHashMap<>();
        Map<Integer, AtomicInteger> map4 =  new ConcurrentHashMap<>();
        AtomicInteger all = new AtomicInteger(0);
        for(int i=0;i<24;i++){
            map1.put(i,new AtomicInteger(0));
        }
        for(int i=1;i<=31;i++){
            map2.put(i,new AtomicInteger(0));
        }
        for(int i=0;i<=20;i++){
            map3.put(i,new AtomicInteger(0));
        }

        ExecutorService executorService = Executors.newFixedThreadPool(THREAD_COUNT);
        List<Future<?>> futures = new ArrayList<>();
        for (int i = 0; i <= 1001; i++) {
            final int index = i;
            Future<?> future = executorService.submit(() -> {
                List<TrafficRecord> list = trafficRecordMapper.selectAll(index * 10000);
                all.addAndGet(list.size());
                for (TrafficRecord record : list) {
                    int  hours = record.getTime().getHours();
                    int  day = record.getTime().getDate();
                    int  road = record.getRoadId();
                    map1.get(hours).incrementAndGet();
                    map2.get(day).incrementAndGet();
                    map3.get(road).incrementAndGet();
                }
            });
            futures.add(future);
        }
        // 等待所有任务完成
        for (Future<?> future : futures) {
            try {
                future.get();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } catch (ExecutionException e) {
                throw new RuntimeException(e);
            }
        }
        map4.put(1,all);
        // 关闭线程池
        executorService.shutdown();
        re.add(map1);
        re.add(map2);
        re.add(map3);
        re.add(map4);
        return re;
    }

    @Override
    public void selectAll2() {
        trafficRecordMapper.selectAll2();
    }
}
