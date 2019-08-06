package me.zhengjie.modules.data.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author jie
 * @date 2019-05-22
 */
@Data
public class CutoffDataDTO implements Serializable {

    private Long id;

    /**
     * 电池容量
     */
    private Double batteryCapacity;

    /**
     * 电流
     */
    private Double batteryCurrent;

    /**
     * 能量
     */
    private Double batteryEnergy;


    /**
     * 电池温度
     */
    private Double batteryTemperature;

    /**
     * 柜号
     */
    private Integer cabinetNo;

    /**
     * 恒流比
     */
    private Double ccRatio;

    /**
     * 库位
     */
    private Integer cellNo;

    /**
     * 通道
     */
    private Integer channel;

    /**
     * 循环号
     */
    private Integer loopNo;

    /**
     * 功率线电压
     */
    private Double powerLineVoltage;

    /**
     * 当前时间
     */
    private String recordTime;

    /**
     * 工步名称
     */
    private String stepName;

    /**
     * 工步号
     */
    private Integer stepNo;
    /**
     * 电压
     */
    private Double voltage;
    /**
     * 产线名
     */
    private String lineName;

    private String time1;

    private String time2;
}