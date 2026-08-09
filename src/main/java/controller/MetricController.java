package com.example.monitorsystem.controller;

import com.example.monitorsystem.entity.ServerMetric;
import com.example.monitorsystem.service.MetricService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/monitor") // 接口的基础路由路径
public class MetricController {

    private static final Logger log = LoggerFactory.getLogger(MetricController.class);

    @Autowired // 把刚刚写好的大脑注入进来
    private MetricService metricService;

    // 指定这个方法只接收 POST 请求，路径是 /report
    @PostMapping("/report")
    public String report(@RequestBody ServerMetric metric) {
        // 将自动转换好的 Java 对象，递交给 Service 层处理
        log.info("接收到节点上报数据 -> IP: {}, CPU负载: {}%, 内存占用: {}%",
                metric.getIp(), metric.getCpuUsage(), metric.getMemUsage());
        return metricService.analyzeMetric(metric);
    }
}