package me.zhengjie.modules.process.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jie
 * @date 2019-05-18
 */
@Data
public class LeakVacuumDTO implements Serializable {

    /**
     * ID
     */
    private Long id;

    /**
     * 方案名称
     */
    private String name;

    /**
     *泄真空开时长
     */
    private Double leakOpenTime;

    /**
     * 泄真空关时长
     */
    private Double leakCloseTime;
}