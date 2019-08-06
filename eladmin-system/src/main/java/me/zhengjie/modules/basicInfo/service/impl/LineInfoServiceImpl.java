package me.zhengjie.modules.basicInfo.service.impl;

import me.zhengjie.modules.basicInfo.domain.LineInfo;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.modules.basicInfo.repository.LineInfoRepository;
import me.zhengjie.modules.basicInfo.service.LineInfoService;
import me.zhengjie.modules.basicInfo.service.dto.LineInfoDTO;
import me.zhengjie.modules.basicInfo.service.mapper.LineInfoMapper;
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
public class LineInfoServiceImpl implements LineInfoService {

    @Autowired
    private LineInfoRepository lineInfoRepository;

    @Autowired
    private LineInfoMapper lineInfoMapper;

    @Override
    public LineInfoDTO findById(Long id) {
        Optional<LineInfo> lineInfo = lineInfoRepository.findById(id);
        ValidationUtil.isNull(lineInfo, "LineInfo", "id", id);
        return lineInfoMapper.toDto(lineInfo.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public LineInfoDTO create(LineInfo resources) {
        return lineInfoMapper.toDto(lineInfoRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(LineInfo resources) {
        Optional<LineInfo> optionalLineInfo = lineInfoRepository.findById(resources.getId());
        ValidationUtil.isNull(optionalLineInfo, "LineInfo", "id", resources.getId());

        LineInfo lineInfo = optionalLineInfo.get();
        // 此处需自己修改
        resources.setId(lineInfo.getId());
        lineInfoRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        lineInfoRepository.deleteById(id);
    }
}