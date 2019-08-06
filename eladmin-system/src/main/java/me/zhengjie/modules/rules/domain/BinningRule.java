package me.zhengjie.modules.rules.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.io.Serializable;

/**
 * @author jie
 * @date 2019-04-09
 */
@Entity
@Data
@Table(name = "binning_rule")
public class BinningRule implements Serializable {

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
    @Column(name = "binning_name")
    private String name;

    /**
     * 代码
     */
    @Column(name = "code")
    private String code;

    /**
     * 创建人
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
     * 描述
     */
    @Column(name = "description")
    private String description;

    /**
     * 电池型号
     */
    @Column(name = "battery_number")
    private String batteryNumber;
}