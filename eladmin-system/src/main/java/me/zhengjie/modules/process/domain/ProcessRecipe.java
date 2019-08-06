package me.zhengjie.modules.process.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jie
 * @date 2019-04-08
 */
@Entity
@Data
@Table(name = "process_recipe")
public class ProcessRecipe implements Serializable {

    /**
     * ID
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * 工艺名称
     */
    @Column(name = "recipe_name")
    private String name;

    /**
     * 工艺代码
     */
    @Column(name = "recipe_code")
    private String code;

    /**
     * 描述
     */
    @Column(name = "description")
    private String description;

    /**
     * 创建时间
     */
    @CreationTimestamp
    @Column(name = "create_time")
    private Timestamp createTime;

    /**
     * 创建人
     */
    @Column(name = "creator_name")
    private String creatorName;

    /**
     * 版本号
     */
    @Column(name = "recipe_version")
    private Integer version;

    /**
     * 状态
     */
    @Column(name = "valid", nullable = false)
    private Boolean valid;
}