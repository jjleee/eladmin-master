package me.zhengjie.modules.rules.service.dto;

import lombok.Data;
import me.zhengjie.modules.rules.domain.BinningRule;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author jie
 * @date 2019-04-09
 */
@Data
public class BinningPlanDTO implements Serializable {

    /**
     * ID
     */
    private Long planId;

    /**
     * 名称
     */
    private String planName;

    /**
     * 电池批次号
     */
    private String batteryNumber;

    /**
     * 创建人
     */
    private String creatorName;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 更新人
     */
    private String updaterName;


    /**
     * 更新时间
     */
    private Timestamp updateTime;

    /**
     * 包含等级
     */
    private List<BinningRule> rules;
}