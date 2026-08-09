package com.example.monitorsystem.service;

import com.example.monitorsystem.entity.ServerMetric;
import org.springframework.stereotype.Service;

@Service // 告诉 Spring 这是一个处理业务逻辑的组件
public class MetricService {

    public String analyzeMetric(ServerMetric metric) {
        // 规则 1：CPU 报警
        if (metric.getCpuUsage() > 90.0) {
            return "【报警】节点 " + metric.getIp() + " CPU 负载过高 (" + metric.getCpuUsage() + "%)，请立即检查！";
        }

        // 规则 2：内存报警
        if (metric.getMemUsage() > 85.0) {
            return "【警告】节点 " + metric.getIp() + " 内存吃紧 (" + metric.getMemUsage() + "%)。";
        }

        // 规则 3：一切正常
        return "【正常】节点 " + metric.getIp() + " 状态良好。";
    }
}