package me.zhengjie.modules.data.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @author jie
 * @date 2019-05-22
 */
@Entity
@Data
@Table(name = "process_data")
public class ProcessData implements Serializable {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * 批次号
     */
    @Column(name = "batch_no")
    private String batchNo;

    /**
     * 电池编号
     */
    @Column(name = "battery_no")
    private String batteryNo;

    /**
     * 电池温度
     */
    @Column(name = "battery_temperature")
    private Double batteryTemperature;

    /**
     * 柜号
     */
    @Column(name = "cabinet_no")
    private String cabinetNo;

    /**
     * 容量
     */
    @Column(name = "capacity")
    private Double capacity;

    /**
     * 恒流比
     */
    @Column(name = "cc_ratio")
    private Double ccRatio;

    /**
     * 库位
     */
    @Column(name = "cell_no")
    private String cellNo;

    /**
     * 库位温度
     */
    @Column(name = "cell_temperature")
    private Double cellTemperature;

    /**
     * 通道
     */
    @Column(name = "channel_no")
    private String channelNo;

    /**
     * 电流
     */
    @Column(name = "battery_current")
    private Double current;

    /**
     * 能量
     */
    @Column(name = "energy")
    private Double energy;

    /**
     * 功能码
     */
    @Column(name = "func_code")
    private String funcCode;

    /**
     * 循环号
     */
    @Column(name = "loop_no")
    private Integer loopNo;

    /**
     * 功率线电压
     */
    @Column(name = "power_line_voltage")
    private Double powerLineVoltage;

    /**
     * 配方名称
     */
    @Column(name = "recipe_name")
    private String recipeName;

    /**
     * 当前时间
     */
    @Column(name = "record_time")
    private Timestamp recordTime;

    /**
     * 电阻
     */
    @Column(name = "resistance")
    private Double resistance;

    /**
     * 运行状态
     */
    @Column(name = "run_state")
    private Integer runState;

    /**
     * 运行时长
     */
    @Column(name = "run_time")
    private Long runTime;

    /**
     * 工步错误代码
     */
    @Column(name = "step_error_code")
    private Integer stepErrorCode;

    /**
     * 工步名称
     */
    @Column(name = "step_name")
    private String stepName;

    /**
     * 工步号
     */
    @Column(name = "step_no")
    private Integer stepNo;

    /**
     * 累加工步
     */
    @Column(name = "sum_step")
    private Integer sumStep;

    /**
     * 托盘号
     */
    @Column(name = "tray_no")
    private String trayNo;

    /**
     * 真空值
     */
    @Column(name = "vacuum_value")
    private Double vacuumValue;

    /**
     * 电压
     */
    @Column(name = "voltage")
    private Double voltage;
}