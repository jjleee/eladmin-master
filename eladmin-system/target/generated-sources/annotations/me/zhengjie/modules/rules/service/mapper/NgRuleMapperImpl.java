package me.zhengjie.modules.rules.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.modules.rules.domain.NgRule;
import me.zhengjie.modules.rules.service.dto.NgRuleDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-09T16:12:18+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class NgRuleMapperImpl implements NgRuleMapper {

    @Override
    public NgRule toEntity(NgRuleDTO dto) {
        if ( dto == null ) {
            return null;
        }

        NgRule ngRule = new NgRule();

        ngRule.setId( dto.getId() );
        ngRule.setName( dto.getName() );
        ngRule.setCode( dto.getCode() );
        ngRule.setDescription( dto.getDescription() );
        ngRule.setCron( dto.getCron() );
        ngRule.setCreatorName( dto.getCreatorName() );
        ngRule.setCreateTime( dto.getCreateTime() );
        ngRule.setUpdatTime( dto.getUpdatTime() );

        return ngRule;
    }

    @Override
    public NgRuleDTO toDto(NgRule entity) {
        if ( entity == null ) {
            return null;
        }

        NgRuleDTO ngRuleDTO = new NgRuleDTO();

        ngRuleDTO.setId( entity.getId() );
        ngRuleDTO.setName( entity.getName() );
        ngRuleDTO.setCode( entity.getCode() );
        ngRuleDTO.setDescription( entity.getDescription() );
        ngRuleDTO.setCron( entity.getCron() );
        ngRuleDTO.setCreatorName( entity.getCreatorName() );
        ngRuleDTO.setCreateTime( entity.getCreateTime() );
        ngRuleDTO.setUpdatTime( entity.getUpdatTime() );

        return ngRuleDTO;
    }

    @Override
    public List<NgRule> toEntity(List<NgRuleDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<NgRule> list = new ArrayList<NgRule>( dtoList.size() );
        for ( NgRuleDTO ngRuleDTO : dtoList ) {
            list.add( toEntity( ngRuleDTO ) );
        }

        return list;
    }

    @Override
    public List<NgRuleDTO> toDto(List<NgRule> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<NgRuleDTO> list = new ArrayList<NgRuleDTO>( entityList.size() );
        for ( NgRule ngRule : entityList ) {
            list.add( toDto( ngRule ) );
        }

        return list;
    }
}
