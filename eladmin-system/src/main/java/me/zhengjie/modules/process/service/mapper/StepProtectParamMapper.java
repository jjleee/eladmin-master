package me.zhengjie.modules.process.service.mapper;

import me.zhengjie.mapper.EntityMapper;
import me.zhengjie.modules.process.domain.StepProtectParam;
import me.zhengjie.modules.process.service.dto.StepProtectParamDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author jie
 * @date 2019-04-25
 */
@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface StepProtectParamMapper extends EntityMapper<StepProtectParamDTO, StepProtectParam> {

}