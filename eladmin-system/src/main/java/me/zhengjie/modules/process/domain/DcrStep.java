package me.zhengjie.modules.process.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @author jie
 * @date 2019-05-03
 */
@Entity
@Data
@Table(name = "DCR_STEP")
public class DcrStep implements Serializable {
    /**
     * ID
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * 工步号
     */
    @Column(name = "step_number")
    private String stepNo;

    /**
     * 工步名称
     */
    @Column(name = "step_name")
    private String stepName;
    /**
     * 电流值
     */
    @Column(name = "current_value")
    private Double currentValue;
    /**
     * 时长
     */
    @Column(name = "duration")
    private Double duration;
    /**
     * 采样点
     */
    @Column(name = "sample_point")
    private Double samplePoint;

    /**
     * 所属配方ID
     */
    @Column(name = "recipe_id")
    private String recipeId;

}
