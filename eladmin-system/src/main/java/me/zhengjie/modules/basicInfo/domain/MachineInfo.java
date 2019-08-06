package me.zhengjie.modules.basicInfo.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.io.Serializable;

/**
 * @author jie
 * @date 2019-03-29
 */
@Entity
@Data
@Table(name = "machine_info")
public class MachineInfo implements Serializable {

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
    @Column(name = "machine_name", nullable = false)
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
     * 所在产线
     */
    @Column(name = "line_name", nullable = false)
    private String lineName;

    /**
     * 所在区段
     */
    @Column(name = "section_name", nullable = false)
    private String sectionName;

    /**
     * 位置
     */
    @Column(name = "position", nullable = false)
    private String position;

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
     * 状态
     */
    @Column(name = "available", nullable = false)
    private Integer available;
}