package me.zhengjie.modules.process.service.mapper;

import me.zhengjie.mapper.EntityMapper;
import me.zhengjie.modules.process.domain.DcrRecipe;
import me.zhengjie.modules.process.service.dto.DcrRecipeDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author jie
 * @date 2019-04-09
 */
@Mapper(componentModel = "spring", uses = {}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DcrRecipeMapper extends EntityMapper<DcrRecipeDTO, DcrRecipe> {

}