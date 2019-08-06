package me.zhengjie.modules.process.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author jie
 * @date 2019-04-25
 */
@Entity
@Data
@Table(name = "global_protect_param")
public class GlobalProtectParam implements Serializable {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * 名称
     */
    @Column(name = "protect_name")
    private String name;

    /**
     * 充电保护电压
     */
    @Column(name = "charge_voltage")
    private Double chargeVoltage;

    /**
     * 充电保护电流
     */
    @Column(name = "charge_current")
    private Double chargeCurrent;

    /**
     * 充电保护容量
     */
    @Column(name = "charge_capacity")
    private Double chargeCapacity;

    /**
     * 放电保护电压
     */
    @Column(name = "discharge_voltage")
    private Double dischargeVoltage;

    /**
     * 放电保护电流
     */
    @Column(name = "discharge_current")
    private Double dischargeCurrent;

    /**
     * 放电保护容量
     */
    @Column(name = "discharge_capacity")
    private Double dischargeCapacity;

    /**
     * 上限温度
     */
    @Column(name = "upper_limit_temperature")
    private Double upperLimitTemperature;
    /**
     * 反接保护
     */
    @Column(name = "reverse_protect")
    private Double reverseProtect;
    /**
     * 电压波动
     */
    @Column(name = "voltage_fluctuation")
    private Double voltageFluctuation;
    /**
     * 电流波动
     */
    @Column(name = "current_fluctuation")
    private Double currentFluctuation;
    /**
     * 接触阻抗
     */
    @Column(name = "ohm")
    private Double ohm;
    /**
     * 电流超差保护
     */
    @Column(name = "ocd")
    private Double ocd;
    /**
     * 电压超差保护
     */
    @Column(name = "ovd")
    private Double ovd;

    /**
     * 直流输出上限
     */
    @Column(name = "dc_limit")
    private Double dcLimit;

    /**
     * 回路阻抗
     */
    @Column(name = "loop_impedance")
    private Double loopImpedance;
}