package me.zhengjie.modules.basicInfo.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.io.Serializable;

/**
 * @author jie
 * @date 2019-04-10
 */
@Entity
@Data
@Table(name = "factory")
public class Factory implements Serializable {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * 名称
     */
    @Column(name = "factory_name")
    private String name;

    /**
     * 代码
     */
    @Column(name = "code")
    private String code;

    /**
     * 描述
     */
    @Column(name = "description")
    private String description;

    /**
     * 创建者
     */
    @Column(name = "creator_name")
    private String creatorName;

    /**
     * 创建时间
     */
    @CreationTimestamp
    @Column(name = "create_time")
    private Timestamp createTime;

    /**
     * 更新时间
     */
    @UpdateTimestamp
    @Column(name = "update_time")
    private Timestamp updateTime;

    /**
     * 状态
     */
    @Column(name = "available")
    private Integer available;
}