package me.zhengjie.modules.process.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author jie
 * @date 2019-05-18
 */
@Entity
@Data
@Table(name = "vacuum_plan")
public class VacuumPlan implements Serializable {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * 方案名称
     */
    @Column(name = "vacuum_name")
    private String name;

    /**
     * 高低真空阀
     */
    @Column(name = "high_low_vacuum")
    private String highLowVacuum;

    /**
     * 时长（min）
     */
    @Column(name = "all_time_min")
    private Double allTimeMin;

    /**
     * 开真空时长（sec）
     */
    @Column(name = "open_vacuum_time_sec")
    private Double openVacuumTimeSec;


    /**
     * 关真空时长（sec）
     */
    @Column(name = "close_vacuum_time_sec")
    private Double closeVacuumTimeSec;

    /**
     * 最终真空度
     */
    @Column(name = "last_vacuum_value")
    private Double lastVacuumValue;

    /**
     * 保压时长（min）
     */
    @Column(name = "keep_time_min")
    private Double keepTimeMin;

    /**
     * 保压值
     */
    @Column(name = "keep_vacuum_value")
    private Double keepVacuumValue;

    /**
     * 压力容错
     */
    @Column(name = "vacuum_tolerance")
    private Double vacuumTolerance;

    /**
     *漏率
     */
    @Column(name = "leak_rate")
    private Double leakRate;

//    /**
//     *泄真空开时长
//     */
//    @Column(name = "leak_open_time")
//    private Double leakOpenTime;
//
//    /**
//     * 泄真空关时长
//     */
//    @Column(name = "leak_close_time")
//    private Double leakCloseTime;
}