package me.zhengjie.modules.rules.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author jie
 * @date 2019-04-09
 */
@Entity
@Getter
@Setter
@Table(name = "binning_rule")
public class BinningRule implements Serializable {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rule_id")
    private Long ruleId;

    /**
     * 等级
     */
    @Column(name = "grade")
    private String grade;

    /**
     * 规则内容
     */
    @Column(name = "expression")
    private String expression;

    @ManyToOne(fetch = FetchType.LAZY,targetEntity = BinningPlan.class,cascade=CascadeType.ALL)
    @JoinColumn(name="plan_id")
    @JsonIgnore
    private BinningPlan plan;
}