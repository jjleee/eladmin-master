package me.zhengjie.modules.process.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.modules.process.domain.VacuumPlan;
import me.zhengjie.modules.process.service.dto.VacuumPlanDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-09T16:12:19+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class VacuumPlanMapperImpl implements VacuumPlanMapper {

    @Override
    public VacuumPlan toEntity(VacuumPlanDTO dto) {
        if ( dto == null ) {
            return null;
        }

        VacuumPlan vacuumPlan = new VacuumPlan();

        vacuumPlan.setId( dto.getId() );
        vacuumPlan.setName( dto.getName() );
        vacuumPlan.setHighLowVacuum( dto.getHighLowVacuum() );
        vacuumPlan.setAllTimeMin( dto.getAllTimeMin() );
        vacuumPlan.setOpenVacuumTimeSec( dto.getOpenVacuumTimeSec() );
        vacuumPlan.setCloseVacuumTimeSec( dto.getCloseVacuumTimeSec() );
        vacuumPlan.setLastVacuumValue( dto.getLastVacuumValue() );
        vacuumPlan.setKeepTimeMin( dto.getKeepTimeMin() );
        vacuumPlan.setKeepVacuumValue( dto.getKeepVacuumValue() );
        vacuumPlan.setVacuumTolerance( dto.getVacuumTolerance() );
        vacuumPlan.setLeakRate( dto.getLeakRate() );

        return vacuumPlan;
    }

    @Override
    public VacuumPlanDTO toDto(VacuumPlan entity) {
        if ( entity == null ) {
            return null;
        }

        VacuumPlanDTO vacuumPlanDTO = new VacuumPlanDTO();

        vacuumPlanDTO.setId( entity.getId() );
        vacuumPlanDTO.setName( entity.getName() );
        vacuumPlanDTO.setHighLowVacuum( entity.getHighLowVacuum() );
        vacuumPlanDTO.setAllTimeMin( entity.getAllTimeMin() );
        vacuumPlanDTO.setOpenVacuumTimeSec( entity.getOpenVacuumTimeSec() );
        vacuumPlanDTO.setCloseVacuumTimeSec( entity.getCloseVacuumTimeSec() );
        vacuumPlanDTO.setLastVacuumValue( entity.getLastVacuumValue() );
        vacuumPlanDTO.setKeepTimeMin( entity.getKeepTimeMin() );
        vacuumPlanDTO.setKeepVacuumValue( entity.getKeepVacuumValue() );
        vacuumPlanDTO.setVacuumTolerance( entity.getVacuumTolerance() );
        vacuumPlanDTO.setLeakRate( entity.getLeakRate() );

        return vacuumPlanDTO;
    }

    @Override
    public List<VacuumPlan> toEntity(List<VacuumPlanDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<VacuumPlan> list = new ArrayList<VacuumPlan>( dtoList.size() );
        for ( VacuumPlanDTO vacuumPlanDTO : dtoList ) {
            list.add( toEntity( vacuumPlanDTO ) );
        }

        return list;
    }

    @Override
    public List<VacuumPlanDTO> toDto(List<VacuumPlan> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<VacuumPlanDTO> list = new ArrayList<VacuumPlanDTO>( entityList.size() );
        for ( VacuumPlan vacuumPlan : entityList ) {
            list.add( toDto( vacuumPlan ) );
        }

        return list;
    }
}
