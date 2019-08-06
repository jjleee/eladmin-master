package me.zhengjie.modules.monitor.domain;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * pv 与 ip 统计
 *
 * @author jie
 * @date 2018-12-13
 */
@Entity
@Data
@Table(name = "visits")
public class Visits {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_visit")
    @SequenceGenerator(name = "id_visit", sequenceName = "id_visit")
    private Long id;

    @Column(name = "visit_date", unique = true)
    private String date;

    @Column(name = "pv_counts")
    private Long pvCounts;

    @Column(name = "ip_counts")
    private Long ipCounts;

    @CreationTimestamp
    @Column(name = "create_time")
    private Timestamp createTime;

    @Column(name = "week_day")
    private String weekDay;
}
