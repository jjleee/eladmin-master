package me.zhengjie.modules.process.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jie
 * @date 2019-05-18
 */
@Data
public class VacuumPlanDTO implements Serializable {

    /**
     * ID
     */
    private Long id;

    /**
     * 方案名称
     */
    private String name;

    /**
     * 高低真空阀
     */
    private String highLowVacuum;

    /**
     * 时长（min）
     */
    private Double allTimeMin;

    /**
     * 开真空时长（sec）
     */
    private Double openVacuumTimeSec;

    /**
     * 关真空时长（sec）
     */
    private Double closeVacuumTimeSec;

    /**
     * 最终真空度
     */
    private Double lastVacuumValue;

    /**
     * 保压时长（min）
     */
    private Double keepTimeMin;

    /**
     * 保压值
     */
    private Double keepVacuumValue;

    /**
     * 压力容错
     */
    private Double vacuumTolerance;

    /**
     *漏率
     */
    private Double leakRate;

//    /**
//     *泄真空开时长
//     */
//    private Double leakOpenTime;
//
//    /**
//     * 泄真空关时长
//     */
//    private Double leakCloseTime;
}