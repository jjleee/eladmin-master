package me.zhengjie.modules.data.service.mapper;

import me.zhengjie.mapper.EntityMapper;
import me.zhengjie.modules.data.domain.CutoffData;
import me.zhengjie.modules.data.service.dto.CutoffDataDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author jie
 * @date 2019-05-22
 */
@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CutoffDataMapper extends EntityMapper<CutoffDataDTO, CutoffData> {

}