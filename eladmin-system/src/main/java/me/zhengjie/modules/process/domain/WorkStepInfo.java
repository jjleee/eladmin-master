package me.zhengjie.modules.process.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author jie
 * @date 2019-04-03
 */
@Entity
@Data
@Table(name = "work_step_info")
public class WorkStepInfo implements Serializable {
    /**
     * ID
     */
    @Id
    @Column(name = "id")
    private String id;
    /**
     * 工步名称
     */
    @Column(name = "stroke")
    private String stroke;
    /**
     * 排序号
     */
    @Column(name = "order_number")
    private Integer orderNumber;
    /**
     * 电流值
     */
    @Column(name = "current_value")
    private Double current;
    /**
     * 电压值
     */
    @Column(name = "voltage")
    private Double voltage;

//===============截止参数=========================

    /**
     * 截止电流
     */
    @Column(name = "off_current")
    private Double offCurrent;

    /**
     * 截止电流逻辑符号
     */
    @Column(name = "off_current_logic")
    private Integer offCurrentLogic;

    /**
     * 截止电压
     */
    @Column(name = "off_voltage")
    private Double offVoltage;

    /**
     * 截止电压逻辑符号
     */
    @Column(name = "off_voltage_logic")
    private Integer offVoltageLogic;

    /**
     * 截止容量
     */
    @Column(name = "off_capacity")
    private Double offCapacity;

    /**
     * 截止容量逻辑符号
     */
    @Column(name = "off_capacity_logic")
    private Integer offCapacityLogic;

    /**
     * 截止时间
     */
    @Column(name = "off_time_min")
    private Double offTimeMin;

    /**
     * 截止时间
     */
    @Column(name = "off_time_sec")
    private Double offTimeSec;

    /**
     * 截止时间逻辑符号
     */
    @Column(name = "off_time_logic")
    private Integer offTimeLogic;

    /**
     * 截止动作 1:截止  2：下一步
     */
    @Column(name = "off_action")
    private Integer offAction;

//===============保护参数=========================
    /**
     * 保护参数模板
     */
    @Column(name = "protect_template")
    private String protectTemplate;

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

//===============真空=========================
    /**
     * 真空方案
     */
    @Column(name = "vacuum_plan")
    private String vacuumPlan;
//===============循坏=========================
    /**
     * 循坏次数
     */
    @Column(name = "cycle_count")
    private Integer cycleCount;
    /**
     * 循环编号
     */
    @Column(name = "cycle_number")
    private Integer cycleNumber;

    /**
     * 所属配方ID
     */
    @Column(name = "recipe_id")
    private String recipeId;
}