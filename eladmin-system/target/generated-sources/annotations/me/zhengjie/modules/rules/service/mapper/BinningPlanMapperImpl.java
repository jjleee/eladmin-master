package me.zhengjie.modules.rules.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.modules.rules.domain.BinningPlan;
import me.zhengjie.modules.rules.domain.BinningRule;
import me.zhengjie.modules.rules.service.dto.BinningPlanDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-09T16:12:19+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class BinningPlanMapperImpl implements BinningPlanMapper {

    @Override
    public BinningPlan toEntity(BinningPlanDTO dto) {
        if ( dto == null ) {
            return null;
        }

        BinningPlan binningPlan = new BinningPlan();

        binningPlan.setPlanId( dto.getPlanId() );
        binningPlan.setPlanName( dto.getPlanName() );
        binningPlan.setCreatorName( dto.getCreatorName() );
        binningPlan.setCreateTime( dto.getCreateTime() );
        binningPlan.setUpdaterName( dto.getUpdaterName() );
        binningPlan.setBatteryNumber( dto.getBatteryNumber() );
        binningPlan.setUpdateTime( dto.getUpdateTime() );
        List<BinningRule> list = dto.getRules();
        if ( list != null ) {
            binningPlan.setRules( new ArrayList<BinningRule>( list ) );
        }
        else {
            binningPlan.setRules( null );
        }

        return binningPlan;
    }

    @Override
    public BinningPlanDTO toDto(BinningPlan entity) {
        if ( entity == null ) {
            return null;
        }

        BinningPlanDTO binningPlanDTO = new BinningPlanDTO();

        binningPlanDTO.setPlanId( entity.getPlanId() );
        binningPlanDTO.setPlanName( entity.getPlanName() );
        binningPlanDTO.setBatteryNumber( entity.getBatteryNumber() );
        binningPlanDTO.setCreatorName( entity.getCreatorName() );
        binningPlanDTO.setCreateTime( entity.getCreateTime() );
        binningPlanDTO.setUpdaterName( entity.getUpdaterName() );
        binningPlanDTO.setUpdateTime( entity.getUpdateTime() );
        List<BinningRule> list = entity.getRules();
        if ( list != null ) {
            binningPlanDTO.setRules( new ArrayList<BinningRule>( list ) );
        }
        else {
            binningPlanDTO.setRules( null );
        }

        return binningPlanDTO;
    }

    @Override
    public List<BinningPlan> toEntity(List<BinningPlanDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<BinningPlan> list = new ArrayList<BinningPlan>( dtoList.size() );
        for ( BinningPlanDTO binningPlanDTO : dtoList ) {
            list.add( toEntity( binningPlanDTO ) );
        }

        return list;
    }

    @Override
    public List<BinningPlanDTO> toDto(List<BinningPlan> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<BinningPlanDTO> list = new ArrayList<BinningPlanDTO>( entityList.size() );
        for ( BinningPlan binningPlan : entityList ) {
            list.add( toDto( binningPlan ) );
        }

        return list;
    }
}
