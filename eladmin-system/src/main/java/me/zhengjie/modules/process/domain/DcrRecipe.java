package me.zhengjie.modules.process.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * 配方名称
     */
    @Column(name = "dcr_name")
    private String name;

    /**
     * 测试方法
     */
    @Column(name = "method_name")
    private String methodName;

    /**
     * I1
     */
    @Column(name = "current_first")
    private Double currentFirst;

    /**
     * I2
     */
    @Column(name = "current_second")
    private Double currentSecond;

    /**
     * T1
     */
    @Column(name = "time_first")
    private Double timeFirst;

    /**
     * T2
     */
    @Column(name = "time_second")
    private Double timeSecond;
    /**
     * t1
     */
    @Column(name = "time_first_dot")
    private Double timeFirstDot;
    /**
     * t2
     */
    @Column(name = "time_second_dot")
    private Double timeSecondDot;
    /**
     * 上限电压
     */
    @Column(name = "upper_limit_voltage")
    private Double upperLimitVoltage;
    /**
     * 下限电压
     */
    @Column(name = "lower_limit_voltage")
    private Double lowerLimitVoltage;
}