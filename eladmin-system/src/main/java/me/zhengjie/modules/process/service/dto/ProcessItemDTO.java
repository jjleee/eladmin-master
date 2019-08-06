package me.zhengjie.modules.process.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jie
 * @date 2019-04-08
 */
@Data
public class ProcessItemDTO implements Serializable {

    /**
     * ID
     */
    private String id;

    /**
     * 步骤名称
     */
    private String itemName;

    /**
     * 步骤时间
     */
    private Long itemTime;

    /**
     * 所属工艺
     */
    private String processId;

    /**
     * 排序号
     */
    private Integer orderNo;
}