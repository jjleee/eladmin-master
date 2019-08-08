package me.zhengjie.modules.basicInfo.domain.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

/**
 * @author jie
 * @date 2019-04-01
 */
@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ExpBatteryInfoVO implements Serializable {

    /**
     * ID
     */
    private Long id;

    /**
     * 型号
     */
    private String number;

    /**
     * 类型
     */
    private String typeName;

    /**
     * 产线
     */
    private List<String> lineNames;

    /**
     * 化成工艺
     */
    private String formationRecipeName;

    /**
     * 分容工艺
     */
    private String divisionRecipeName;

    /**
     * DCR工艺
     */
    private String dcrRecipeName;

    /**
     * 调荷工艺
     */
    private String chargeRecipeName;

    /**
     * 保护参数
     */
    private String protectParamName;

    /**
     * NG规则
     */
    private String ngRuleName;

    /**
     * 创建者
     */
    private String creatorName;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 状态
     */
    private Integer available;
}