package me.zhengjie.modules.basicInfo.service.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.io.Serializable;

/**
 * @author jie
 * @date 2019-04-10
 */
@Data
public class LineTypeDTO implements Serializable {

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
     * 创建者
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
     * 状态
     */
    private Integer available;
}