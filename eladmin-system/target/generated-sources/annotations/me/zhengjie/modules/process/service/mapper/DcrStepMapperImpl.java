package me.zhengjie.modules.process.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.modules.process.domain.DcrStep;
import me.zhengjie.modules.process.service.dto.DcrStepDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-09T16:12:19+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class DcrStepMapperImpl implements DcrStepMapper {

    @Override
    public DcrStep toEntity(DcrStepDTO dto) {
        if ( dto == null ) {
            return null;
        }

        DcrStep dcrStep = new DcrStep();

        dcrStep.setId( dto.getId() );
        dcrStep.setStepNo( dto.getStepNo() );
        dcrStep.setStepName( dto.getStepName() );
        dcrStep.setCurrentValue( dto.getCurrentValue() );
        dcrStep.setDuration( dto.getDuration() );
        dcrStep.setSamplePoint( dto.getSamplePoint() );
        dcrStep.setRecipeId( dto.getRecipeId() );

        return dcrStep;
    }

    @Override
    public DcrStepDTO toDto(DcrStep entity) {
        if ( entity == null ) {
            return null;
        }

        DcrStepDTO dcrStepDTO = new DcrStepDTO();

        dcrStepDTO.setId( entity.getId() );
        dcrStepDTO.setStepNo( entity.getStepNo() );
        dcrStepDTO.setStepName( entity.getStepName() );
        dcrStepDTO.setCurrentValue( entity.getCurrentValue() );
        dcrStepDTO.setDuration( entity.getDuration() );
        dcrStepDTO.setSamplePoint( entity.getSamplePoint() );
        dcrStepDTO.setRecipeId( entity.getRecipeId() );

        return dcrStepDTO;
    }

    @Override
    public List<DcrStep> toEntity(List<DcrStepDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<DcrStep> list = new ArrayList<DcrStep>( dtoList.size() );
        for ( DcrStepDTO dcrStepDTO : dtoList ) {
            list.add( toEntity( dcrStepDTO ) );
        }

        return list;
    }

    @Override
    public List<DcrStepDTO> toDto(List<DcrStep> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DcrStepDTO> list = new ArrayList<DcrStepDTO>( entityList.size() );
        for ( DcrStep dcrStep : entityList ) {
            list.add( toDto( dcrStep ) );
        }

        return list;
    }
}
