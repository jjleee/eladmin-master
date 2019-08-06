package me.zhengjie.modules.basicInfo.service.mapper;

import me.zhengjie.mapper.EntityMapper;
import me.zhengjie.modules.basicInfo.domain.BatteryInfo;
import me.zhengjie.modules.basicInfo.service.dto.BatteryInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author jie
 * @date 2019-04-01
 */
@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BatteryInfoMapper extends EntityMapper<BatteryInfoDTO, BatteryInfo> {

}