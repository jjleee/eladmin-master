package me.zhengjie.modules.process.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author jie
 * @date 2019-04-08
 */
@Entity
@Data
@Table(name = "process_item")
public class ProcessItem implements Serializable {

    /**
     * ID
     */
    @Id
    @Column(name = "id")
    private String id;

    /**
     * 步骤名称
     */
    @Column(name = "item_name")
    private String itemName;

    /**
     * 步骤时间
     */
    @Column(name = "item_time")
    private Long itemTime;

    /**
     * 所属工艺
     */
    @Column(name = "process_id")
    private String processId;

    /**
     * 排序号
     */
    @Column(name = "order_no", nullable = false)
    private Integer orderNo;
}