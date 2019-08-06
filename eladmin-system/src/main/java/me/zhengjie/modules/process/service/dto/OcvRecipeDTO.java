package me.zhengjie.modules.process.service.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author jie
 * @date 2019-04-09
 */
@Data
public class OcvRecipeDTO implements Serializable {

    /**
     * ID
     */
    private Long id;

    /**
     * 名称
     */
    private String name;

    /**
     * 时间
     */
    private Integer time;

    /**
     * 电流
     */
    private Integer current;
}