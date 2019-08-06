package me.zhengjie.modules.process.service.mapper;

import me.zhengjie.mapper.EntityMapper;
import me.zhengjie.modules.process.domain.WorkStepInfo;
import me.zhengjie.modules.process.service.dto.WorkStepInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author jie
 * @date 2019-04-03
 */
@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface WorkStepInfoMapper extends EntityMapper<WorkStepInfoDTO, WorkStepInfo> {

}