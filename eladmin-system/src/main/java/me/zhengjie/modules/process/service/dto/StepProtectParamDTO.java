package me.zhengjie.modules.process.service.dto;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

/**
 * @author jie
 * @date 2019-04-25
 */
@Data
public class StepProtectParamDTO implements Serializable {

    /**
     * ID
     */
    private Long id;

    /**
     * 模板名称
     */
    private String protectName;

    /**
     * 工步名称
     */
    private String stepName;

    /**
     * 正间隔电流变化量
     */
    private Double positiveIntervalCurrent;
    /**
     * 正间隔电流跳变次数
     */
    private Integer positiveIntervalCurrentCount;
    /**
     * 正间隔电压变化量
     */
    private Double positiveIntervalVoltage;
    /**
     * 正间隔电压跳变次数
     */
    private Integer positiveIntervalVoltageCount;
    /**
     * 负间隔电流变化量
     */
    private Double negativeIntervalCurrent;
    /**
     * 负间隔电流跳变次数
     */
    private Integer negativeIntervalCurrentCount;
    /**
     * 负间隔电压变化量
     */
    private Double negativeIntervalVoltage;
    /**
     * 负间隔电压跳变次数
     */
    private Integer negativeIntervalVoltageCount;
    /**
     * 上限容量
     */
    private Double upperLimitCapacity;
    /**
     * 下限容量
     */
    private Double lowerLimitCapacity;
    /**
     * 上限电流
     */
    private Double upperLimitCurrent;
    /**
     * 下限电流
     */
    private Double lowerLimitCurrent;
    /**
     * 上限电压
     */
    private Double upperLimitVoltage;
    /**
     * 下限电压
     */
    private Double lowerLimitVoltage;
    /**
     * 上限温度
     */
    private Double upperLimitTemperature;
}