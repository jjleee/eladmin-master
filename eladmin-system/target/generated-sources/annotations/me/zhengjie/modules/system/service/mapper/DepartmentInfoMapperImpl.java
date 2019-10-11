package me.zhengjie.modules.system.service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import me.zhengjie.modules.system.domain.DepartmentInfo;
import me.zhengjie.modules.system.service.dto.DepartmentInfoDTO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-09T16:12:19+0800",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_101 (Oracle Corporation)"
)
@Component
public class DepartmentInfoMapperImpl implements DepartmentInfoMapper {

    @Override
    public DepartmentInfo toEntity(DepartmentInfoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        DepartmentInfo departmentInfo = new DepartmentInfo();

        departmentInfo.setId( dto.getId() );
        departmentInfo.setName( dto.getName() );
        departmentInfo.setCode( dto.getCode() );
        departmentInfo.setDescription( dto.getDescription() );
        departmentInfo.setCreateTime( dto.getCreateTime() );
        departmentInfo.setCreatorName( dto.getCreatorName() );

        return departmentInfo;
    }

    @Override
    public DepartmentInfoDTO toDto(DepartmentInfo entity) {
        if ( entity == null ) {
            return null;
        }

        DepartmentInfoDTO departmentInfoDTO = new DepartmentInfoDTO();

        departmentInfoDTO.setId( entity.getId() );
        departmentInfoDTO.setName( entity.getName() );
        departmentInfoDTO.setCode( entity.getCode() );
        departmentInfoDTO.setDescription( entity.getDescription() );
        departmentInfoDTO.setCreateTime( entity.getCreateTime() );
        departmentInfoDTO.setCreatorName( entity.getCreatorName() );

        return departmentInfoDTO;
    }

    @Override
    public List<DepartmentInfo> toEntity(List<DepartmentInfoDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<DepartmentInfo> list = new ArrayList<DepartmentInfo>( dtoList.size() );
        for ( DepartmentInfoDTO departmentInfoDTO : dtoList ) {
            list.add( toEntity( departmentInfoDTO ) );
        }

        return list;
    }

    @Override
    public List<DepartmentInfoDTO> toDto(List<DepartmentInfo> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DepartmentInfoDTO> list = new ArrayList<DepartmentInfoDTO>( entityList.size() );
        for ( DepartmentInfo departmentInfo : entityList ) {
            list.add( toDto( departmentInfo ) );
        }

        return list;
    }
}
