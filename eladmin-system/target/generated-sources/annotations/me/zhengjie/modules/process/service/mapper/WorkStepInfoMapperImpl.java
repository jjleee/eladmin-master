package me.zhengjie.modules.process.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.modules.process.domain.WorkStepInfo;
import me.zhengjie.modules.process.service.dto.WorkStepInfoDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-09T16:12:19+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class WorkStepInfoMapperImpl implements WorkStepInfoMapper {

    @Override
    public WorkStepInfo toEntity(WorkStepInfoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        WorkStepInfo workStepInfo = new WorkStepInfo();

        workStepInfo.setId( dto.getId() );
        workStepInfo.setStroke( dto.getStroke() );
        workStepInfo.setOrderNumber( dto.getOrderNumber() );
        workStepInfo.setCurrent( dto.getCurrent() );
        workStepInfo.setVoltage( dto.getVoltage() );
        workStepInfo.setOffCurrent( dto.getOffCurrent() );
        workStepInfo.setOffVoltage( dto.getOffVoltage() );
        workStepInfo.setOffCapacity( dto.getOffCapacity() );
        if ( dto.getOffTimeMin() != null ) {
            workStepInfo.setOffTimeMin( dto.getOffTimeMin().doubleValue() );
        }
        if ( dto.getOffTimeSec() != null ) {
            workStepInfo.setOffTimeSec( dto.getOffTimeSec().doubleValue() );
        }
        workStepInfo.setProtectTemplate( dto.getProtectTemplate() );
        workStepInfo.setPositiveIntervalCurrent( dto.getPositiveIntervalCurrent() );
        workStepInfo.setPositiveIntervalCurrentCount( dto.getPositiveIntervalCurrentCount() );
        workStepInfo.setPositiveIntervalVoltage( dto.getPositiveIntervalVoltage() );
        workStepInfo.setPositiveIntervalVoltageCount( dto.getPositiveIntervalVoltageCount() );
        workStepInfo.setNegativeIntervalCurrent( dto.getNegativeIntervalCurrent() );
        workStepInfo.setNegativeIntervalCurrentCount( dto.getNegativeIntervalCurrentCount() );
        workStepInfo.setNegativeIntervalVoltage( dto.getNegativeIntervalVoltage() );
        workStepInfo.setNegativeIntervalVoltageCount( dto.getNegativeIntervalVoltageCount() );
        workStepInfo.setUpperLimitCapacity( dto.getUpperLimitCapacity() );
        workStepInfo.setLowerLimitCapacity( dto.getLowerLimitCapacity() );
        workStepInfo.setUpperLimitCurrent( dto.getUpperLimitCurrent() );
        workStepInfo.setLowerLimitCurrent( dto.getLowerLimitCurrent() );
        workStepInfo.setUpperLimitVoltage( dto.getUpperLimitVoltage() );
        workStepInfo.setLowerLimitVoltage( dto.getLowerLimitVoltage() );
        workStepInfo.setUpperLimitTemperature( dto.getUpperLimitTemperature() );
        workStepInfo.setVacuumPlan( dto.getVacuumPlan() );
        workStepInfo.setCycleCount( dto.getCycleCount() );
        workStepInfo.setCycleNumber( dto.getCycleNumber() );
        workStepInfo.setRecipeId( dto.getRecipeId() );

        return workStepInfo;
    }

    @Override
    public WorkStepInfoDTO toDto(WorkStepInfo entity) {
        if ( entity == null ) {
            return null;
        }

        WorkStepInfoDTO workStepInfoDTO = new WorkStepInfoDTO();

        workStepInfoDTO.setId( entity.getId() );
        workStepInfoDTO.setStroke( entity.getStroke() );
        workStepInfoDTO.setOrderNumber( entity.getOrderNumber() );
        workStepInfoDTO.setCurrent( entity.getCurrent() );
        workStepInfoDTO.setVoltage( entity.getVoltage() );
        workStepInfoDTO.setOffCurrent( entity.getOffCurrent() );
        workStepInfoDTO.setOffVoltage( entity.getOffVoltage() );
        workStepInfoDTO.setOffCapacity( entity.getOffCapacity() );
        if ( entity.getOffTimeMin() != null ) {
            workStepInfoDTO.setOffTimeMin( entity.getOffTimeMin().intValue() );
        }
        if ( entity.getOffTimeSec() != null ) {
            workStepInfoDTO.setOffTimeSec( entity.getOffTimeSec().intValue() );
        }
        workStepInfoDTO.setPositiveIntervalCurrent( entity.getPositiveIntervalCurrent() );
        workStepInfoDTO.setPositiveIntervalCurrentCount( entity.getPositiveIntervalCurrentCount() );
        workStepInfoDTO.setPositiveIntervalVoltage( entity.getPositiveIntervalVoltage() );
        workStepInfoDTO.setPositiveIntervalVoltageCount( entity.getPositiveIntervalVoltageCount() );
        workStepInfoDTO.setNegativeIntervalCurrent( entity.getNegativeIntervalCurrent() );
        workStepInfoDTO.setNegativeIntervalCurrentCount( entity.getNegativeIntervalCurrentCount() );
        workStepInfoDTO.setNegativeIntervalVoltage( entity.getNegativeIntervalVoltage() );
        workStepInfoDTO.setNegativeIntervalVoltageCount( entity.getNegativeIntervalVoltageCount() );
        workStepInfoDTO.setUpperLimitCapacity( entity.getUpperLimitCapacity() );
        workStepInfoDTO.setLowerLimitCapacity( entity.getLowerLimitCapacity() );
        workStepInfoDTO.setUpperLimitCurrent( entity.getUpperLimitCurrent() );
        workStepInfoDTO.setLowerLimitCurrent( entity.getLowerLimitCurrent() );
        workStepInfoDTO.setUpperLimitVoltage( entity.getUpperLimitVoltage() );
        workStepInfoDTO.setLowerLimitVoltage( entity.getLowerLimitVoltage() );
        workStepInfoDTO.setUpperLimitTemperature( entity.getUpperLimitTemperature() );
        workStepInfoDTO.setVacuumPlan( entity.getVacuumPlan() );
        workStepInfoDTO.setCycleCount( entity.getCycleCount() );
        workStepInfoDTO.setCycleNumber( entity.getCycleNumber() );
        workStepInfoDTO.setRecipeId( entity.getRecipeId() );
        workStepInfoDTO.setProtectTemplate( entity.getProtectTemplate() );

        return workStepInfoDTO;
    }

    @Override
    public List<WorkStepInfo> toEntity(List<WorkStepInfoDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<WorkStepInfo> list = new ArrayList<WorkStepInfo>( dtoList.size() );
        for ( WorkStepInfoDTO workStepInfoDTO : dtoList ) {
            list.add( toEntity( workStepInfoDTO ) );
        }

        return list;
    }

    @Override
    public List<WorkStepInfoDTO> toDto(List<WorkStepInfo> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<WorkStepInfoDTO> list = new ArrayList<WorkStepInfoDTO>( entityList.size() );
        for ( WorkStepInfo workStepInfo : entityList ) {
            list.add( toDto( workStepInfo ) );
        }

        return list;
    }
}
