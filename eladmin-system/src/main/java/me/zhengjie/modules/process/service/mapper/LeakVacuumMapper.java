package me.zhengjie.modules.process.service.mapper;

import me.zhengjie.mapper.EntityMapper;
import me.zhengjie.modules.process.domain.LeakVacuum;
import me.zhengjie.modules.process.service.dto.LeakVacuumDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author jie
 * @date 2019-05-18
 */
@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LeakVacuumMapper extends EntityMapper<LeakVacuumDTO, LeakVacuum> {

}