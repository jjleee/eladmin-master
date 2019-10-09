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

    /**
     * ID
     */
    private String id;

    /**
     * 线号
     */
    private Integer lineNo;

    /**
     * 柜号
     */
    private Integer cabNo;

    /**
     * 库号
     */
    private Integer cellNo;

    /**
     * 通道号
     */
    private Integer channelNo;

    /**
     * 功能码
     */
    private Integer funcCode;

    /**
     * 运行状态
     */
    private Integer runState;

    /**
     * 运行时长
     */
    private Long runTime;


    /**
     * 电压
     */
    private Float voltage;


    /**
     * 电流
     */
    private Float current;

    /**
     * 容量
     */
    private Float capacity;


    /**
     * 电池温度
     */
    private Float batteryTemperature;

    /**
     * 工步号
     */
    private Integer stepNo;

    /**
     * 工步类型
     */
    private Integer stepType;

    /**
     * 循环号
     */
    private Integer loopNo;

    /**
     * 当前时间
     */
    private Long currentTime;

    /**
     * 累加工步
     */
    private Integer sumStep;

    /**
     * 恒流比
     */
    private Float ratio;


    /**
     * 能量
     */
    private Float energy;

    /**
     * 功率线电压
     */
    private Float povl;

    private Long time1;

    private Long time2;
}