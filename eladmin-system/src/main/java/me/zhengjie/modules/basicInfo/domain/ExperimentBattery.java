package me.zhengjie.modules.basicInfo.domain;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

/**
* @author jie
* @date 2019-08-02
*/
@Entity
@Data
@Table(name="experiment_battery",uniqueConstraints = {@UniqueConstraint(columnNames="battery_number")})
public class ExperimentBattery implements Serializable {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * 电芯号
     */
    @Column(name = "battery_number")
    private String batteryNumber;
}