package me.zhengjie.modules.process.service.dto;

import lombok.Data;
import me.zhengjie.modules.process.domain.DcrStep;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.Set;

/**
 * @author jie
 * @date 2019-04-09
 */
@Data
public class DcrRecipeDTO implements Serializable {

    /**
     * ID
     */
    private String id;

    /**
     * 配方名称
     */
    private String name;

    /**
     * 配方类型
     */
    private Integer recipeType;

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 状态
     */
    private Boolean valid;

    /**
     * 创建人
     */
    private String creatorName;


    private Timestamp createTime;

    private Timestamp updateTime;
    /**
     * 更新者
     */
    private String updaterName;

    /**
     * 包含工步
     */
    List<DcrStep> steps;
}