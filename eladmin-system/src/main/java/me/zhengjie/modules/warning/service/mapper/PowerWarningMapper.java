package me.zhengjie.modules.warning.service.mapper;

import me.zhengjie.mapper.EntityMapper;
import me.zhengjie.modules.warning.domain.PowerWarning;
import me.zhengjie.modules.warning.service.dto.PowerWarningDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
* @author jie
* @date 2019-07-23
*/
@Mapper(componentModel = "spring",uses = {},unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PowerWarningMapper extends EntityMapper<PowerWarningDTO, PowerWarning> {

}