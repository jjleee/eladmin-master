package me.zhengjie.modules.rules.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.modules.rules.domain.BinningRule;
import me.zhengjie.modules.rules.service.dto.BinningRuleDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-09T16:12:19+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class BinningRuleMapperImpl implements BinningRuleMapper {

    @Override
    public BinningRule toEntity(BinningRuleDTO dto) {
        if ( dto == null ) {
            return null;
        }

        BinningRule binningRule = new BinningRule();

        binningRule.setRuleId( dto.getRuleId() );
        binningRule.setGrade( dto.getGrade() );
        binningRule.setExpression( dto.getExpression() );

        return binningRule;
    }

    @Override
    public BinningRuleDTO toDto(BinningRule entity) {
        if ( entity == null ) {
            return null;
        }

        BinningRuleDTO binningRuleDTO = new BinningRuleDTO();

        binningRuleDTO.setRuleId( entity.getRuleId() );
        binningRuleDTO.setGrade( entity.getGrade() );
        binningRuleDTO.setExpression( entity.getExpression() );

        return binningRuleDTO;
    }

    @Override
    public List<BinningRule> toEntity(List<BinningRuleDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<BinningRule> list = new ArrayList<BinningRule>( dtoList.size() );
        for ( BinningRuleDTO binningRuleDTO : dtoList ) {
            list.add( toEntity( binningRuleDTO ) );
        }

        return list;
    }

    @Override
    public List<BinningRuleDTO> toDto(List<BinningRule> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<BinningRuleDTO> list = new ArrayList<BinningRuleDTO>( entityList.size() );
        for ( BinningRule binningRule : entityList ) {
            list.add( toDto( binningRule ) );
        }

        return list;
    }
}
