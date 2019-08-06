package me.zhengjie.modules.system.service.mapper;

import me.zhengjie.mapper.EntityMapper;
import me.zhengjie.modules.system.domain.DepartmentInfo;
import me.zhengjie.modules.system.service.dto.DepartmentInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author jie
 * @date 2019-03-28
 */
@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DepartmentInfoMapper extends EntityMapper<DepartmentInfoDTO, DepartmentInfo> {

}