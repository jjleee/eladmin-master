package me.zhengjie.modules.warning.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
* @author jie
* @date 2019-07-23
*/
@Entity
@Data
@Table(name="power_warning")
public class PowerWarning implements Serializable {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * 线号
     */
    @Column(name = "line")
    private String line;

    /**
     * 柜号
     */
    @Column(name = "cabinet")
    private Integer cabinet;

    /**
     * 库位
     */
    @Column(name = "cell")
    private Integer cell;

    /**
     * 通道
     */
    @Column(name = "channel")
    private Integer channel;

    /**
     * 父功能码
     */
    @Column(name = "func_code")
    private Integer funcCode;

    /**
     * 子功能码
     */
    @Column(name = "sub_func_code")
    private Integer subFuncCode;

    /**
     * 错误码
     */
    @Column(name = "error_code")
    private Integer errorCode;

    /**
     * 警告信息
     */
    @Column(name = "message")
    private String message;

    /**
     * 产生时间
     */
    @Column(name = "create_time")
    private Timestamp createTime;
}