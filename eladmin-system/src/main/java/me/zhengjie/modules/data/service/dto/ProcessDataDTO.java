package me.zhengjie.modules.data.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author jie
 * @date 2019-05-22
 */
@Data
public class ProcessDataDTO implements Serializable {

    /**
     * ID
     */
    private Long id;

    /**
     * 批次号
     */
    private String batchNo;

    /**
     * 电池编号
     */
    private String batteryNo;

    /**
     * 电池温度
     */
    private Double batteryTemperature;

    /**
     * 柜号
     */
    private String cabinetNo;

    /**
     * 容量
     */
    private Double capacity;

    /**
     * 恒流比
     */
    private Double ccRatio;

    /**
     * 库位
     */
    private String cellNo;

    /**
     * 库位温度
     */
    private Double cellTemperature;

    /**
     * 通道
     */
    private String channelNo;

    /**
     * 电流
     */
    private Double current;

    /**
     * 能量
     */
    private Double energy;

    /**
     * 功能码
     */
    private String funcCode;

    /**
     * 循环号
     */
    private Integer loopNo;

    /**
     * 功率线电压
     */
    private Double powerLineVoltage;

    /**
     * 配方名称
     */
    private String recipeName;

    /**
     * 当前时间
     */
    private Timestamp recordTime;

    /**
     * 电阻
     */
    private Double resistance;

    /**
     * 运行状态
     */
    private Integer runState;

    /**
     * 运行时长
     */
    private Long runTime;

    /**
     * 工步错误代码
     */
    private Integer stepErrorCode;

    /**
     * 工步名称
     */
    private String stepName;

    /**
     * 工步号
     */
    private Integer stepNo;

    /**
     * 累加工步
     */
    private Integer sumStep;

    /**
     * 托盘号
     */
    private String trayNo;

    /**
     * 真空值
     */
    private Double vacuumValue;

    /**
     * 电压
     */
    private Double voltage;
}