package com.example.monitorsystem.entity; // <- 必须是这个

public class ServerMetric {
    private String ip;
    private double cpuUsage; // CPU 使用率
    private double memUsage; // 内存 使用率

    // 自动生成的 Getter 和 Setter（外界访问这些数据的通道）
    public String getIp() { return ip; }
    public void setIp(String ip) { this.ip = ip; }
    public double getCpuUsage() { return cpuUsage; }
    public void setCpuUsage(double cpuUsage) { this.cpuUsage = cpuUsage; }
    public double getMemUsage() { return memUsage; }
    public void setMemUsage(double memUsage) { this.memUsage = memUsage; }
}