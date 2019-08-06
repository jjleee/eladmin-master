package me.zhengjie.modules.rules.service.mapper;

import me.zhengjie.mapper.EntityMapper;
import me.zhengjie.modules.rules.domain.BinningRule;
import me.zhengjie.modules.rules.service.dto.BinningRuleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author jie
 * @date 2019-04-09
 */
@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface BinningRuleMapper extends EntityMapper<BinningRuleDTO, BinningRule> {

}