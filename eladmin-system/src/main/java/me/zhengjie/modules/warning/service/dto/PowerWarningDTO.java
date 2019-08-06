package me.zhengjie.modules.warning.service.dto;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
* @author jie
* @date 2019-07-23
*/
@Data
public class PowerWarningDTO implements Serializable {

    /**
     * ID
     */
    private Long id;

    /**
     * 线号
     */
    private String line;

    /**
     * 柜号
     */
    private Integer cabinet;

    /**
     * 库位
     */
    private Integer cell;

    /**
     * 通道
     */
    private Integer channel;

    /**
     * 父功能码
     */
    private Integer funcCode;

    /**
     * 子功能码
     */
    private Integer subFuncCode;

    /**
     * 错误码
     */
    private Integer errorCode;

    /**
     * 警告信息
     */
    private String message;

    /**
     * 产生时间
     */
    private Timestamp createTime;
}