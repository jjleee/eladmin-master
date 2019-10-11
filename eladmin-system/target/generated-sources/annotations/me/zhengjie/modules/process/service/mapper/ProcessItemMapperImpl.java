package me.zhengjie.modules.process.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.modules.process.domain.ProcessItem;
import me.zhengjie.modules.process.service.dto.ProcessItemDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-09T16:12:19+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class ProcessItemMapperImpl implements ProcessItemMapper {

    @Override
    public ProcessItem toEntity(ProcessItemDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ProcessItem processItem = new ProcessItem();

        processItem.setId( dto.getId() );
        processItem.setItemName( dto.getItemName() );
        processItem.setItemTime( dto.getItemTime() );
        processItem.setProcessId( dto.getProcessId() );
        processItem.setOrderNo( dto.getOrderNo() );

        return processItem;
    }

    @Override
    public ProcessItemDTO toDto(ProcessItem entity) {
        if ( entity == null ) {
            return null;
        }

        ProcessItemDTO processItemDTO = new ProcessItemDTO();

        processItemDTO.setId( entity.getId() );
        processItemDTO.setItemName( entity.getItemName() );
        processItemDTO.setItemTime( entity.getItemTime() );
        processItemDTO.setProcessId( entity.getProcessId() );
        processItemDTO.setOrderNo( entity.getOrderNo() );

        return processItemDTO;
    }

    @Override
    public List<ProcessItem> toEntity(List<ProcessItemDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<ProcessItem> list = new ArrayList<ProcessItem>( dtoList.size() );
        for ( ProcessItemDTO processItemDTO : dtoList ) {
            list.add( toEntity( processItemDTO ) );
        }

        return list;
    }

    @Override
    public List<ProcessItemDTO> toDto(List<ProcessItem> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ProcessItemDTO> list = new ArrayList<ProcessItemDTO>( entityList.size() );
        for ( ProcessItem processItem : entityList ) {
            list.add( toDto( processItem ) );
        }

        return list;
    }
}
