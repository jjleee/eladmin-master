package me.zhengjie.modules.process.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jie
 * @date 2019-04-25
 */
@Data
public class GlobalProtectParamDTO implements Serializable {

    /**
     * ID
     */
    private Long id;


    /**
     * 名称
     */
    private String name;

    /**
     * 充电保护电压
     */
    private Double chargeVoltage;

    /**
     * 充电保护电流
     */
    private Double chargeCurrent;

    /**
     * 充电保护容量
     */
    private Double chargeCapacity;

    /**
     * 放电保护电压
     */
    private Double dischargeVoltage;

    /**
     * 放电保护电流
     */
    private Double dischargeCurrent;

    /**
     * 充电保护容量
     */
    private Double dischargeCapacity;

    /**
     * 上限温度
     */
    private Double upperLimitTemperature;
    /**
     * 反接保护
     */
    private Double reverseProtect;

    /**
     * 电压波动
     */
    private Double voltageFluctuation;

    /**
     * 电流波动
     */
    private Double currentFluctuation;
    /**
     * 接触阻抗
     */
    private Double ohm;

    /**
     * 电流超差保护
     */
    private Double ocd;

    /**
     * 电压超差保护
     */
    private Double ovd;

    /**
     * 直流输出上限
     */
    private Double dcLimit;
    /**
     * 回路阻抗
     */
    private Double loopImpedance;
}