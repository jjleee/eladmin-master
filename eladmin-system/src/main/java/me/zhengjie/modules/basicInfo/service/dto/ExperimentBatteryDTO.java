package me.zhengjie.modules.basicInfo.service.dto;

import lombok.Data;
import java.io.Serializable;

/**
* @author jie
* @date 2019-08-02
*/
@Data
public class ExperimentBatteryDTO implements Serializable {

    /**
     * ID
     */
    private Long id;

    /**
     * 电芯号
     */
    private String batteryNumber;
}