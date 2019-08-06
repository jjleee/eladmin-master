package me.zhengjie.modules.process.service.dto;

import lombok.Data;
import me.zhengjie.modules.process.domain.WorkStepInfo;

import java.sql.Timestamp;
import java.io.Serializable;
import java.util.List;

/**
 * @author jie
 * @date 2019-04-03
 */
@Data
public class FormationRecipeDTO implements Serializable {

    /**
     * ID
     */
    private String id;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 描述
     */
    private String description;

    /**
     * 编辑者
     */
    private String editorName;

    /**
     * 配方名称
     */
    private String name;

    /**
     * 最近更新时间
     */
    private Timestamp updateTime;

    /**
     * 更新者
     */
    private String updaterName;

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 采样频率
     */
    private Integer frequency;

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