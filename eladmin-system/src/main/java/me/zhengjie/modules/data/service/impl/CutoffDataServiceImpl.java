package me.zhengjie.modules.data.service.impl;

import me.zhengjie.modules.data.domain.CutoffData;
import me.zhengjie.modules.data.repository.CutoffDataRepository;
import me.zhengjie.modules.data.service.CutoffDataService;
import me.zhengjie.modules.data.service.dto.CutoffDataDTO;
import me.zhengjie.modules.data.service.mapper.CutoffDataMapper;
import me.zhengjie.utils.ValidationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author jie
 * @date 2019-05-22
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class CutoffDataServiceImpl implements CutoffDataService {

    @Autowired
    private CutoffDataRepository cutoffDataRepository;

    @Autowired
    private CutoffDataMapper cutoffDataMapper;

    @Override
    public CutoffDataDTO findById(String id) {
        Optional<CutoffData> cutoffData = cutoffDataRepository.findById(id);
        ValidationUtil.isNull(cutoffData, "CutoffData", "id", id);
        return cutoffDataMapper.toDto(cutoffData.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CutoffDataDTO create(CutoffData resources) {
        return cutoffDataMapper.toDto(cutoffDataRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(CutoffData resources) {
        Optional<CutoffData> optionalCutoffData = cutoffDataRepository.findById(resources.getId());
        ValidationUtil.isNull(optionalCutoffData, "CutoffData", "id", resources.getId());

        CutoffData cutoffData = optionalCutoffData.get();
        // 此处需自己修改
        resources.setId(cutoffData.getId());
        cutoffDataRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id) {
        cutoffDataRepository.deleteById(id);
    }
}