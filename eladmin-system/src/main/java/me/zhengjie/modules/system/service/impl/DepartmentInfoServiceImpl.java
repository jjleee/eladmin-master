package me.zhengjie.modules.system.service.impl;

import me.zhengjie.modules.system.domain.DepartmentInfo;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.modules.system.repository.DepartmentInfoRepository;
import me.zhengjie.modules.system.service.DepartmentInfoService;
import me.zhengjie.modules.system.service.dto.DepartmentInfoDTO;
import me.zhengjie.modules.system.service.mapper.DepartmentInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author jie
 * @date 2019-03-28
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class DepartmentInfoServiceImpl implements DepartmentInfoService {

    @Autowired
    private DepartmentInfoRepository departmentInfoRepository;

    @Autowired
    private DepartmentInfoMapper departmentInfoMapper;

    @Override
    public DepartmentInfoDTO findById(Long id) {
        Optional<DepartmentInfo> departmentInfo = departmentInfoRepository.findById(id);
        ValidationUtil.isNull(departmentInfo, "DepartmentInfo", "id", id);
        return departmentInfoMapper.toDto(departmentInfo.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public DepartmentInfoDTO create(DepartmentInfo resources) {
        return departmentInfoMapper.toDto(departmentInfoRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(DepartmentInfo resources) {
        Optional<DepartmentInfo> optionalDepartmentInfo = departmentInfoRepository.findById(resources.getId());
        ValidationUtil.isNull(optionalDepartmentInfo, "DepartmentInfo", "id", resources.getId());

        DepartmentInfo departmentInfo = optionalDepartmentInfo.get();
        // 此处需自己修改
        resources.setId(departmentInfo.getId());
        departmentInfoRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        departmentInfoRepository.deleteById(id);
    }
}