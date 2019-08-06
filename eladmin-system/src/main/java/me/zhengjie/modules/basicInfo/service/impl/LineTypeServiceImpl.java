package me.zhengjie.modules.basicInfo.service.impl;

import me.zhengjie.modules.basicInfo.domain.LineType;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.modules.basicInfo.repository.LineTypeRepository;
import me.zhengjie.modules.basicInfo.service.LineTypeService;
import me.zhengjie.modules.basicInfo.service.dto.LineTypeDTO;
import me.zhengjie.modules.basicInfo.service.mapper.LineTypeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author jie
 * @date 2019-04-10
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class LineTypeServiceImpl implements LineTypeService {

    @Autowired
    private LineTypeRepository lineTypeRepository;

    @Autowired
    private LineTypeMapper lineTypeMapper;

    @Override
    public LineTypeDTO findById(Long id) {
        Optional<LineType> lineType = lineTypeRepository.findById(id);
        ValidationUtil.isNull(lineType, "LineType", "id", id);
        return lineTypeMapper.toDto(lineType.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LineTypeDTO create(LineType resources) {
        return lineTypeMapper.toDto(lineTypeRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(LineType resources) {
        Optional<LineType> optionalLineType = lineTypeRepository.findById(resources.getId());
        ValidationUtil.isNull(optionalLineType, "LineType", "id", resources.getId());

        LineType lineType = optionalLineType.get();
        // 此处需自己修改
        resources.setId(lineType.getId());
        lineTypeRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        lineTypeRepository.deleteById(id);
    }
}