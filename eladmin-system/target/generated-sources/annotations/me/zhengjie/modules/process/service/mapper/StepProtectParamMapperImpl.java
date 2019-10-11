package me.zhengjie.modules.process.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.modules.process.domain.StepProtectParam;
import me.zhengjie.modules.process.service.dto.StepProtectParamDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-09T16:12:19+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class StepProtectParamMapperImpl implements StepProtectParamMapper {

    @Override
    public StepProtectParam toEntity(StepProtectParamDTO dto) {
        if ( dto == null ) {
            return null;
        }

        StepProtectParam stepProtectParam = new StepProtectParam();

        stepProtectParam.setId( dto.getId() );
        stepProtectParam.setProtectName( dto.getProtectName() );
        stepProtectParam.setStepName( dto.getStepName() );
        stepProtectParam.setPositiveIntervalCurrent( dto.getPositiveIntervalCurrent() );
        stepProtectParam.setPositiveIntervalCurrentCount( dto.getPositiveIntervalCurrentCount() );
        stepProtectParam.setPositiveIntervalVoltage( dto.getPositiveIntervalVoltage() );
        stepProtectParam.setPositiveIntervalVoltageCount( dto.getPositiveIntervalVoltageCount() );
        stepProtectParam.setNegativeIntervalCurrent( dto.getNegativeIntervalCurrent() );
        stepProtectParam.setNegativeIntervalCurrentCount( dto.getNegativeIntervalCurrentCount() );
        stepProtectParam.setNegativeIntervalVoltage( dto.getNegativeIntervalVoltage() );
        stepProtectParam.setNegativeIntervalVoltageCount( dto.getNegativeIntervalVoltageCount() );
        stepProtectParam.setUpperLimitCapacity( dto.getUpperLimitCapacity() );
        stepProtectParam.setLowerLimitCapacity( dto.getLowerLimitCapacity() );
        stepProtectParam.setUpperLimitCurrent( dto.getUpperLimitCurrent() );
        stepProtectParam.setLowerLimitCurrent( dto.getLowerLimitCurrent() );
        stepProtectParam.setUpperLimitVoltage( dto.getUpperLimitVoltage() );
        stepProtectParam.setLowerLimitVoltage( dto.getLowerLimitVoltage() );
        stepProtectParam.setUpperLimitTemperature( dto.getUpperLimitTemperature() );

        return stepProtectParam;
    }

    @Override
    public StepProtectParamDTO toDto(StepProtectParam entity) {
        if ( entity == null ) {
            return null;
        }

        StepProtectParamDTO stepProtectParamDTO = new StepProtectParamDTO();

        stepProtectParamDTO.setId( entity.getId() );
        stepProtectParamDTO.setProtectName( entity.getProtectName() );
        stepProtectParamDTO.setStepName( entity.getStepName() );
        stepProtectParamDTO.setPositiveIntervalCurrent( entity.getPositiveIntervalCurrent() );
        stepProtectParamDTO.setPositiveIntervalCurrentCount( entity.getPositiveIntervalCurrentCount() );
        stepProtectParamDTO.setPositiveIntervalVoltage( entity.getPositiveIntervalVoltage() );
        stepProtectParamDTO.setPositiveIntervalVoltageCount( entity.getPositiveIntervalVoltageCount() );
        stepProtectParamDTO.setNegativeIntervalCurrent( entity.getNegativeIntervalCurrent() );
        stepProtectParamDTO.setNegativeIntervalCurrentCount( entity.getNegativeIntervalCurrentCount() );
        stepProtectParamDTO.setNegativeIntervalVoltage( entity.getNegativeIntervalVoltage() );
        stepProtectParamDTO.setNegativeIntervalVoltageCount( entity.getNegativeIntervalVoltageCount() );
        stepProtectParamDTO.setUpperLimitCapacity( entity.getUpperLimitCapacity() );
        stepProtectParamDTO.setLowerLimitCapacity( entity.getLowerLimitCapacity() );
        stepProtectParamDTO.setUpperLimitCurrent( entity.getUpperLimitCurrent() );
        stepProtectParamDTO.setLowerLimitCurrent( entity.getLowerLimitCurrent() );
        stepProtectParamDTO.setUpperLimitVoltage( entity.getUpperLimitVoltage() );
        stepProtectParamDTO.setLowerLimitVoltage( entity.getLowerLimitVoltage() );
        stepProtectParamDTO.setUpperLimitTemperature( entity.getUpperLimitTemperature() );

        return stepProtectParamDTO;
    }

    @Override
    public List<StepProtectParam> toEntity(List<StepProtectParamDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<StepProtectParam> list = new ArrayList<StepProtectParam>( dtoList.size() );
        for ( StepProtectParamDTO stepProtectParamDTO : dtoList ) {
            list.add( toEntity( stepProtectParamDTO ) );
        }

        return list;
    }

    @Override
    public List<StepProtectParamDTO> toDto(List<StepProtectParam> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<StepProtectParamDTO> list = new ArrayList<StepProtectParamDTO>( entityList.size() );
        for ( StepProtectParam stepProtectParam : entityList ) {
            list.add( toDto( stepProtectParam ) );
        }

        return list;
    }
}
