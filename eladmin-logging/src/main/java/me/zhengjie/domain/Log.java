package me.zhengjie.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author jie
 * @date 2018-11-24
 */
@Entity
@Data
@Table(name = "log_info")
@NoArgsConstructor
public class Log {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 操作用户
     */
    private String username;

    /**
     * 描述
     */
    private String description;

    /**
     * 方法名
     */
    private String methodName;

    /**
     * 参数
     */
    @Column(columnDefinition = "clob")
    private String params;

    /**
     * 日志类型
     */
    @Column(name = "log_type")
    private String logType;

    /**
     * 请求ip
     */
    @Column(name = "request_ip")
    private String requestIp;

    /**
     * 请求耗时
     */
    @Column(name = "times")
    private Long time;

    /**
     * 异常详细
     */
    @Column(name = "exception_detail", columnDefinition = "clob")
    private String exceptionDetail;

    /**
     * 创建日期
     */
    @CreationTimestamp
    @Column(name = "create_time")
    private Timestamp createTime;

    public Log(String logType, Long time) {
        this.logType = logType;
        this.time = time;
    }
}
