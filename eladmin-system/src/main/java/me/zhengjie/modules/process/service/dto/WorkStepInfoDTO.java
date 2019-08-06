package me.zhengjie.modules.process.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jie
 * @date 2019-04-03
 */
@Data
public class WorkStepInfoDTO implements Serializable {
    private String id;

    private String stroke;

    private Integer orderNumber;

    private Double current;

    private Double voltage;


    private Double offCurrent;

//    private Integer offCurrentLogic;

    private Double offVoltage;

//    private Integer offVoltageLogic;

    private Double offCapacity;

//    private Integer offCapacityLogic;

    private Integer offTimeMin;

    private Integer offTimeSec;

//    private Integer offTimeLogic;

//    private Integer offAction;

    private Double positiveIntervalCurrent;

    private Integer positiveIntervalCurrentCount;

    private Double positiveIntervalVoltage;

    private Integer positiveIntervalVoltageCount;

    private Double negativeIntervalCurrent;

    private Integer negativeIntervalCurrentCount;

    private Double negativeIntervalVoltage;

    private Integer negativeIntervalVoltageCount;

    private Double upperLimitCapacity;

    private Double lowerLimitCapacity;

    private Double upperLimitCurrent;

    private Double lowerLimitCurrent;

    private Double upperLimitVoltage;

    private Double lowerLimitVoltage;

    private Double upperLimitTemperature;

    private String vacuumPlan;

    private Integer cycleCount;

    private Integer cycleNumber;

    private String recipeId;

    private String protectTemplate;
}