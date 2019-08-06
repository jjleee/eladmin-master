package me.zhengjie.modules.basicInfo.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.io.Serializable;
import java.util.List;

/**
 * @author jie
 * @date 2019-04-01
 */
@Entity
@Data
@Table(name = "battery_info")
public class BatteryInfo implements Serializable {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * 型号
     */
    @Column(name = "battery_number", nullable = false)
    private String number;

    /**
     * 类型
     */
    @Column(name = "type_name")
    private String typeName;

    /**
     * 产线
     */
    @Column(name = "line_names")
    private String lineName;

    /**
     * 化成工艺
     */
    @Column(name = "formation_recipe_name")
    private String formationRecipeName;

    /**
     * 分容工艺
     */
    @Column(name = "division_recipe_name")
    private String divisionRecipeName;

    /**
     * OCV工艺
     */
    @Column(name = "ocv_recipe_name")
    private String ocvRecipeName;

    /**
     * DCR工艺
     */
    @Column(name = "dcr_recipe_name")
    private String dcrRecipeName;

    /**
     * 调荷工艺
     */
    @Column(name = "charge_recipe_name")
    private String chargeRecipeName;

    /**
     * 保护参数
     */
    @Column(name = "protect_param_name")
    private String protectParamName;

    /**
     * 分档规则
     */
    @Column(name = "binning_rule_name")
    private String binningRuleName;

    /**
     * NG规则
     */
    @Column(name = "ng_rule_name")
    private String ngRuleName;

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
    @Column(name = "available")
    private Integer available;
}