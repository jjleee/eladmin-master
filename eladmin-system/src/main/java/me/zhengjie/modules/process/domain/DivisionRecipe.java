package me.zhengjie.modules.process.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author jie
 * @date 2019-04-26
 */
@Entity
@Data
@Table(name = "division_recipe")
public class DivisionRecipe implements Serializable {

    /**
     * ID
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * 名称
     */
    @Column(name = "recipe_name")
    private String recipeName;

    /**
     * 编辑者
     */
    @Column(name = "editor_name")
    private String editorName;

    /**
     * 创建时间
     */
    @CreationTimestamp
    @Column(name = "create_time")
    private Timestamp createTime;

    /**
     * 更新者
     */
    @Column(name = "updater_name")
    private String updaterName;

    /**
     * 更新时间
     */
    @UpdateTimestamp
    @Column(name = "update_time")
    private Timestamp updateTime;

    /**
     * 采样频率
     */
    @Column(name = "frequency")
    private Integer frequency;

    /**
     * 配方类型
     */
    @Column(name = "recipe_type")
    private Integer recipeType;

    /**
     * 版本
     */
    @Column(name = "recipe_version", nullable = false)
    private Integer recipeVersion;

    /**
     * 描述
     */
    @Column(name = "description")
    private String description;

    /**
     * 状态
     */
    @Column(name = "valid", nullable = false)
    private Boolean valid;
}