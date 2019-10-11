package me.zhengjie.modules.basicInfo.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.modules.basicInfo.domain.ExperimentBattery;
import me.zhengjie.modules.basicInfo.service.dto.ExperimentBatteryDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-09T16:12:19+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class ExperimentBatteryMapperImpl implements ExperimentBatteryMapper {

    @Override
    public ExperimentBattery toEntity(ExperimentBatteryDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ExperimentBattery experimentBattery = new ExperimentBattery();

        experimentBattery.setId( dto.getId() );
        experimentBattery.setBatteryNumber( dto.getBatteryNumber() );

        return experimentBattery;
    }

    @Override
    public ExperimentBatteryDTO toDto(ExperimentBattery entity) {
        if ( entity == null ) {
            return null;
        }

        ExperimentBatteryDTO experimentBatteryDTO = new ExperimentBatteryDTO();

        experimentBatteryDTO.setId( entity.getId() );
        experimentBatteryDTO.setBatteryNumber( entity.getBatteryNumber() );

        return experimentBatteryDTO;
    }

    @Override
    public List<ExperimentBattery> toEntity(List<ExperimentBatteryDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<ExperimentBattery> list = new ArrayList<ExperimentBattery>( dtoList.size() );
        for ( ExperimentBatteryDTO experimentBatteryDTO : dtoList ) {
            list.add( toEntity( experimentBatteryDTO ) );
        }

        return list;
    }

    @Override
    public List<ExperimentBatteryDTO> toDto(List<ExperimentBattery> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ExperimentBatteryDTO> list = new ArrayList<ExperimentBatteryDTO>( entityList.size() );
        for ( ExperimentBattery experimentBattery : entityList ) {
            list.add( toDto( experimentBattery ) );
        }

        return list;
    }
}
