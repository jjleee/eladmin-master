package me.zhengjie.modules.process.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jie
 * @date 2019-04-09
 */
@Data
public class DcrRecipeDTO implements Serializable {

    /**
     * ID
     */
    private Long id;

    /**
     * 配方名称
     */
    private String name;

    /**
     * 测试方法
     */
    private String methodName;

    /**
     * I1
     */
    private Double currentFirst;

    /**
     * I2
     */
    private Double currentSecond;

    /**
     * T1
     */
    private Double timeFirst;

    /**
     * T2
     */
    private Double timeSecond;
    /**
     * t1
     */
    private Double timeFirstDot;
    /**
     * t2
     */
    private Double timeSecondDot;
    /**
     * 上限温度
     */
    private Double upperLimitVoltage;
    /**
     * 下限温度
     */
    private Double lowerLimitVoltage;
}