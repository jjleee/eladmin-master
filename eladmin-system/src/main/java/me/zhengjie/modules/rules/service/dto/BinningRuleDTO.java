package me.zhengjie.modules.rules.service.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.io.Serializable;

/**
 * @author jie
 * @date 2019-04-09
 */
@Data
public class BinningRuleDTO implements Serializable {

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
     * 创建人
     */
    private String creatorName;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 更新时间
     */
    private Timestamp updateTime;

    /**
     * 描述
     */
    private String description;

    /**
     * 电池型号
     */
    private String batteryNumber;
}