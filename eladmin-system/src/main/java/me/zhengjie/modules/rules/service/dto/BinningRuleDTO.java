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
     * ruleId
     */
    private Long ruleId;

    /**
     * 等级
     */
    private String grade;

    /**
     * 规则内容
     */
    private String expression;

    /**
     * 方案ID
     */
    private Long planId;
}