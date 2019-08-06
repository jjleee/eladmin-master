package me.zhengjie.modules.basicInfo.service.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.io.Serializable;

/**
 * @author jie
 * @date 2019-03-29
 */
@Data
public class MachineInfoDTO implements Serializable {

    /**
     * ID
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 代码
     */
    private String code;

    /**
     * 描述
     */
    private String description;

    /**
     * 所在产线
     */
    private String lineName;

    /**
     * 所在区段
     */
    private String sectionName;

    /**
     * 位置
     */
    private String position;

    /**
     * 创建者
     */
    private String creatorName;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 状态
     */
    private Integer available;
}