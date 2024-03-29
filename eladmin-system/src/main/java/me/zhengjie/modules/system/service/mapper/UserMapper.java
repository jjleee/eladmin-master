package me.zhengjie.modules.system.service.mapper;

import me.zhengjie.modules.system.domain.User;
import me.zhengjie.mapper.EntityMapper;
import me.zhengjie.modules.system.service.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author jie
 * @date 2018-11-23
 */
@Mapper(componentModel = "spring", uses = {RoleMapper.class}, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper extends EntityMapper<UserDTO, User> {

}
