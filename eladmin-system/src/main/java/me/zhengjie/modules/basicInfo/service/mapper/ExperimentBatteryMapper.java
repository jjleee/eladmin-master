package me.zhengjie.modules.basicInfo.service.mapper;

import me.zhengjie.mapper.EntityMapper;
import me.zhengjie.modules.basicInfo.domain.ExperimentBattery;
import me.zhengjie.modules.basicInfo.service.dto.ExperimentBatteryDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author jie
* @date 2019-08-02
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ExperimentBatteryMapper extends EntityMapper<ExperimentBatteryDTO, ExperimentBattery> {

}