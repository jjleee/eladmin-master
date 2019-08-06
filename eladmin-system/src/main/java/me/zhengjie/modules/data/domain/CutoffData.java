package me.zhengjie.modules.data.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author jie
 * @date 2019-05-22
 */
@Entity
@Data
@Table(name = "process_step_abort")
public class CutoffData implements Serializable {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    /**
     * 电池容量
     */
    @Column(name = "B_CAPACITY")
    private Double batteryCapacity;

    /**
     * 电流
     */
    @Column(name = "B_CURRENT")
    private Double batteryCurrent;

    /**
     * 能量
     */
    @Column(name = "B_POWER")
    private Double batteryEnergy;


    /**
     * 电池温度
     */
    @Column(name = "BATTERY_TEMPERATURE")
    private Double batteryTemperature;

    /**
     * 柜号
     */
    @Column(name = "CABINET_NO")
    private Integer cabinetNo;

    /**
     * 恒流比
     */
    @Column(name = "CC_THAN")
    private Double ccRatio;

    /**
     * 库位
     */
    @Column(name = "CELL_NO")
    private Integer cellNo;

    /**
     * 通道
     */
    @Column(name = "CHANNEL")
    private Integer channel;

    /**
     * 循环号
     */
    @Column(name = "LOOP_NO")
    private Integer loopNo;

    /**
     * 功率线电压
     */
    @Column(name = "POVL")
    private Double powerLineVoltage;

    /**
     * 当前时间
     */
    @Column(name = "RECORD_DATE")
    private String recordTime;

    /**
     * 工步名称
     */
    @Column(name = "STEP_NAME")
    private String stepName;

    /**
     * 工步号
     */
    @Column(name = "STEP_NO")
    private Integer stepNo;


    /**
     * 电压
     */
    @Column(name = "B_VOLTAGE")
    private Double voltage;

    /**
     * 产线
     */
    @Column(name = "LINE_NAME")
    private String lineName;

}