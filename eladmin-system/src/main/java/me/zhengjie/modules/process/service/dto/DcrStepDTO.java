package me.zhengjie.modules.process.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jie
 * @date 2019-04-09
 */
@Data
public class DcrStepDTO implements Serializable {

    /**
     * ID
     */
    private String id;

    /**
     * 工步号
     */
    private String stepNo;

    /**
     * 工步名称
     */
    private String stepName;
    /**
     * 电流值
     */
    private Double currentValue;
    /**
     * 时长
     */
    private Double duration;
    /**
     * 采样点
     */

    private Double samplePoint;

    /**
     * 所属配方ID
     */

    private String recipeId;

}