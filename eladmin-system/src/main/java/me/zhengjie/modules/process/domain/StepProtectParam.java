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
@Table(name = "step_protect_param")
public class StepProtectParam implements Serializable {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * 模板名称
     */
    @Column(name = "protect_name",unique = true)
    private String protectName;

    /**
     * 工步名称
     */
    @Column(name = "step_name")
    private String stepName;

    /**
     * 正间隔电流变化量
     */
    @Column(name = "positive_interval_current")
    private Double positiveIntervalCurrent;
    /**
     * 正间隔电流跳变次数
     */
    @Column(name = "positive_interval_current_count")
    private Integer positiveIntervalCurrentCount;
    /**
     * 正间隔电压变化量
     */
    @Column(name = "positive_interval_voltage")
    private Double positiveIntervalVoltage;
    /**
     * 正间隔电压跳变次数
     */
    @Column(name = "positive_interval_voltage_count")
    private Integer positiveIntervalVoltageCount;
    /**
     * 负间隔电流变化量
     */
    @Column(name = "negative_interval_current")
    private Double negativeIntervalCurrent;
    /**
     * 负间隔电流跳变次数
     */
    @Column(name = "negative_interval_current_count")
    private Integer negativeIntervalCurrentCount;
    /**
     * 负间隔电压变化量
     */
    @Column(name = "negative_interval_voltage")
    private Double negativeIntervalVoltage;
    /**
     * 负间隔电压跳变次数
     */
    @Column(name = "negative_interval_voltage_count")
    private Integer negativeIntervalVoltageCount;
    /**
     * 上限容量
     */
    @Column(name = "upper_limit_capacity")
    private Double upperLimitCapacity;
    /**
     * 下限容量
     */
    @Column(name = "lower_limit_capacity")
    private Double lowerLimitCapacity;
    /**
     * 上限电流
     */
    @Column(name = "upper_limit_current")
    private Double upperLimitCurrent;
    /**
     * 下限电流
     */
    @Column(name = "lower_limit_current")
    private Double lowerLimitCurrent;
    /**
     * 上限电压
     */
    @Column(name = "upper_limit_voltage")
    private Double upperLimitVoltage;
    /**
     * 下限电压
     */
    @Column(name = "lower_limit_voltage")
    private Double lowerLimitVoltage;
    /**
     * 上限温度
     */
    @Column(name = "upper_limit_temperature")
    private Double upperLimitTemperature;
}