package me.zhengjie.modules.process.service.dto;

import lombok.Data;
import me.zhengjie.modules.process.domain.ProcessItem;

import java.sql.Timestamp;
import java.io.Serializable;
import java.util.List;

/**
 * @author jie
 * @date 2019-04-08
 */
@Data
public class ProcessRecipeDTO implements Serializable {

    /**
     * ID
     */
    private String id;

    /**
     * 工艺名称
     */
    private String name;

    /**
     * 工艺代码
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

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 状态
     */
    private Boolean valid;
    /**
     * 包含item
     */
    private List<ProcessItem> processItems;
}