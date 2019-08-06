package me.zhengjie.modules.process.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author jie
 * @date 2019-04-03
 */
@Entity
@Data
@Table(name = "formation_recipe")
public class FormationRecipe implements Serializable {

    /**
     * ID
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * 创建时间
     */
    @CreationTimestamp
    @Column(name = "create_time")
    private Timestamp createTime;

    /**
     * 描述
     */
    @Column(name = "description")
    private String description;

    /**
     * 编辑者
     */
    @Column(name = "editor_name")
    private String editorName;

    /**
     * 配方名称
     */
    @Column(name = "recipe_name")
    private String name;

    /**
     * 配方类型
     */
    @Column(name = "recipe_type")
    private Integer recipeType;

    /**
     * 最近更新时间
     */
    @UpdateTimestamp
    @Column(name = "update_time")
    private Timestamp updateTime;

    /**
     * 更新者
     */
    @Column(name = "updater_name")
    private String updaterName;

    /**
     * 版本号
     */
    @Column(name = "recipe_version")
    private Integer version;

    /**
     * 采样频率
     */
    private Integer frequency;

    /**
     * 状态
     */
    @Column(name = "valid")
    private Boolean valid;
}