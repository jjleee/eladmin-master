package me.zhengjie.modules.process.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Set;

/**
 * @author jie
 * @date 2019-04-09
 */
@Entity
@Data
@Table(name = "dcr_recipe")
public class DcrRecipe implements Serializable {

    /**
     * ID
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * 配方名称
     */
    @Column(name = "dcr_name")
    private String name;

    /**
     * 配方类型
     */
    @Column(name = "recipe_type")
    private Integer recipeType;

    /**
     * 版本号
     */
    @Column(name = "version")
    private Integer version;

    /**
     * 状态
     */
    @Column(name = "valid")
    private Boolean valid;

    /**
     * 创建人
     */
    @Column(name = "creator_Name")
    private String creatorName;

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
     * 最近更新时间
     */
    @UpdateTimestamp
    @Column(name = "update_time")
    private Timestamp updateTime;
}