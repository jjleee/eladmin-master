package me.zhengjie.modules.process.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author jie
 * @date 2019-05-18
 */
@Entity
@Data
@Table(name = "leak_vacuum")
public class LeakVacuum implements Serializable {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * 方案名称
     */
    @Column(name = "leak_name")
    private String name;

    /**
     *泄真空开时长
     */
    @Column(name = "leak_open_time")
    private Double leakOpenTime;

    /**
     * 泄真空关时长
     */
    @Column(name = "leak_close_time")
    private Double leakCloseTime;
}