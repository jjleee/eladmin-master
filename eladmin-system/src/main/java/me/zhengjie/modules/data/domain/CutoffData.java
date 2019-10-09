package me.zhengjie.modules.data.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author jie
 * @date 2019-05-22
 */
@Entity
@Data
@Table(name = "process_step_stop")
public class CutoffData implements Serializable {
    /**
     * ID
     */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 线号
     */
    @Column(name = "LINENO")
    private Integer lineNo;

    /**
     * 柜号
     */
    @Column(name = "CABNO")
    private Integer cabNo;

    /**
     * 库号
     */
    @Column(name = "CELLNO")
    private Integer cellNo;

    /**
     * 通道号
     */
    @Column(name = "CHANNELNO")
    private Integer channelNo;

    /**
     * 功能码
     */
    @Column(name = "FUNCCODE")
    private Integer funcCode;

    /**
     * 运行状态
     */
    @Column(name = "RUNSTATE")
    private Integer runState;

    /**
     * 运行时长
     */
    @Column(name = "RUNTIME")
    private Long runTime;


    /**
     * 电压
     */
    @Column(name = "VOLT")
    private Float voltage;


    /**
     * 电流
     */
    @Column(name = "CURR")
    private Float current;

    /**
     * 容量
     */
    @Column(name = "CAPACITY")
    private Float capacity;


    /**
     * 电池温度
     */
    @Column(name = "BATTERYTEMPERATURE")
    private Float batteryTemperature;

    /**
     * 工步号
     */
    @Column(name = "STEPNO")
    private Integer stepNo;

    /**
     * 工步类型
     */
    @Column(name = "STEPTYPE")
    private Integer stepType;

    /**
     * 循环号
     */
    @Column(name = "LOOPNO")
    private Integer loopNo;

    /**
     * 当前时间
     */
    @Column(name = "CURRENTTIME")
    private Long currentTime;

    /**
     * 累加工步
     */
    @Column(name = "SUMSTEP")
    private Integer sumStep;

    /**
     * 恒流比
     */
    @Column(name = "RATIO")
    private Float ratio;


    /**
     * 能量
     */
    @Column(name = "ENERGY")
    private Float energy;

    /**
     * 功率线电压
     */
    @Column(name = "POVL")
    private Float povl;
}