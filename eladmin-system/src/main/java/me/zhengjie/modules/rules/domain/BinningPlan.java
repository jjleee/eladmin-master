package me.zhengjie.modules.rules.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author jie
 * @date 2019-04-09
 */
@Entity
@Getter
@Setter
@Table(name = "binning_plan",uniqueConstraints = {@UniqueConstraint(columnNames="plan_name")})
public class BinningPlan implements Serializable {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "planId")
    private Long planId;

    /**
     * 名称
     */
    @Column(name = "plan_name")
    private String planName;

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
     * 更新人
     */
    @Column(name = "updater_name")
    private String updaterName;

    /**
     * 电池批次号
     */
    @Column(name = "battery_number")
    private String batteryNumber;
    /**
     * 更新时间
     */
    @UpdateTimestamp
    @Column(name = "update_time")
    private Timestamp updateTime;

    /**
     * 规则内容
     */
    @OneToMany(mappedBy = "plan",targetEntity = BinningRule.class,cascade=CascadeType.ALL,fetch=FetchType.LAZY)
    private List<BinningRule> rules;
}