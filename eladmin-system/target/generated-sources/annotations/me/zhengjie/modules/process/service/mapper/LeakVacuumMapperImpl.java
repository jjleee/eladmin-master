package me.zhengjie.modules.process.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.modules.process.domain.LeakVacuum;
import me.zhengjie.modules.process.service.dto.LeakVacuumDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-09T16:12:19+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class LeakVacuumMapperImpl implements LeakVacuumMapper {

    @Override
    public LeakVacuum toEntity(LeakVacuumDTO dto) {
        if ( dto == null ) {
            return null;
        }

        LeakVacuum leakVacuum = new LeakVacuum();

        leakVacuum.setId( dto.getId() );
        leakVacuum.setName( dto.getName() );
        leakVacuum.setLeakOpenTime( dto.getLeakOpenTime() );
        leakVacuum.setLeakCloseTime( dto.getLeakCloseTime() );

        return leakVacuum;
    }

    @Override
    public LeakVacuumDTO toDto(LeakVacuum entity) {
        if ( entity == null ) {
            return null;
        }

        LeakVacuumDTO leakVacuumDTO = new LeakVacuumDTO();

        leakVacuumDTO.setId( entity.getId() );
        leakVacuumDTO.setName( entity.getName() );
        leakVacuumDTO.setLeakOpenTime( entity.getLeakOpenTime() );
        leakVacuumDTO.setLeakCloseTime( entity.getLeakCloseTime() );

        return leakVacuumDTO;
    }

    @Override
    public List<LeakVacuum> toEntity(List<LeakVacuumDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<LeakVacuum> list = new ArrayList<LeakVacuum>( dtoList.size() );
        for ( LeakVacuumDTO leakVacuumDTO : dtoList ) {
            list.add( toEntity( leakVacuumDTO ) );
        }

        return list;
    }

    @Override
    public List<LeakVacuumDTO> toDto(List<LeakVacuum> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<LeakVacuumDTO> list = new ArrayList<LeakVacuumDTO>( entityList.size() );
        for ( LeakVacuum leakVacuum : entityList ) {
            list.add( toDto( leakVacuum ) );
        }

        return list;
    }
}
