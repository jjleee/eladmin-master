package me.zhengjie.modules.basicInfo.service.mapper;

import me.zhengjie.mapper.EntityMapper;
import me.zhengjie.modules.basicInfo.domain.LineInfo;
import me.zhengjie.modules.basicInfo.service.dto.LineInfoDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author jie
 * @date 2019-04-10
 */
@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LineInfoMapper extends EntityMapper<LineInfoDTO, LineInfo> {

}