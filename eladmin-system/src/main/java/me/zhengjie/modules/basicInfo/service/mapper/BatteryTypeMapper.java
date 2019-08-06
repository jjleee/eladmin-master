package me.zhengjie.modules.basicInfo.service.mapper;

import me.zhengjie.mapper.EntityMapper;
import me.zhengjie.modules.basicInfo.domain.BatteryType;
import me.zhengjie.modules.basicInfo.service.dto.BatteryTypeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author jie
 * @date 2019-03-29
 */
@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BatteryTypeMapper extends EntityMapper<BatteryTypeDTO, BatteryType> {

}