package me.zhengjie.modules.process.service.dto;

import lombok.Data;
import me.zhengjie.modules.process.domain.WorkStepInfo;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author jie
 * @date 2019-04-26
 */
@Data
public class DivisionRecipeDTO implements Serializable {

    /**
     * ID
     */
    private String id;

    /**
     * 名称
     */
    private String recipeName;

    /**
     * 编辑者
     */
    private String editorName;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 更新者
     */
    private String updaterName;

    /**
     * 更新时间
     */
    private Timestamp updateTime;

    /**
     * 采样频率
     */
    private Integer frequency;

    /**
     * 版本
     */
    private Integer recipeVersion;

    /**
     * 描述
     */
    private String description;

    /**
     * 状态
     */
    private Boolean valid;

    /**
     * 配方类型
     */
    private Integer recipeType;

    /**
     * 包含的工步
     */
    List<WorkStepInfo> workStepInfos;
}