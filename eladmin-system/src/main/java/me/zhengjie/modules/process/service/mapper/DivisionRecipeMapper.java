package me.zhengjie.modules.process.service.mapper;

import me.zhengjie.mapper.EntityMapper;
import me.zhengjie.modules.process.domain.DivisionRecipe;
import me.zhengjie.modules.process.service.dto.DivisionRecipeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author jie
 * @date 2019-04-26
 */
@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DivisionRecipeMapper extends EntityMapper<DivisionRecipeDTO, DivisionRecipe> {

}