package me.zhengjie.modules.system.service.dto;

import lombok.Data;

import java.sql.Timestamp;
import java.io.Serializable;

/**
 * @author jie
 * @date 2019-03-28
 */
@Data
public class DepartmentInfoDTO implements Serializable {

    /**
     * id
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
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 创建人
     */
    private String creatorName;
}