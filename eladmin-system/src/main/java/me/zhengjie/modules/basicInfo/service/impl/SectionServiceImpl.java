package me.zhengjie.modules.basicInfo.service.impl;

import me.zhengjie.modules.basicInfo.domain.Section;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.modules.basicInfo.repository.SectionRepository;
import me.zhengjie.modules.basicInfo.service.SectionService;
import me.zhengjie.modules.basicInfo.service.dto.SectionDTO;
import me.zhengjie.modules.basicInfo.service.mapper.SectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * @author jie
 * @date 2019-03-29
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SectionServiceImpl implements SectionService {

    @Autowired
    private SectionRepository sectionRepository;

    @Autowired
    private SectionMapper sectionMapper;

    @Override
    public SectionDTO findById(Long id) {
        Optional<Section> section = sectionRepository.findById(id);
        ValidationUtil.isNull(section, "Section", "id", id);
        return sectionMapper.toDto(section.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public SectionDTO create(Section resources) {
        return sectionMapper.toDto(sectionRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Section resources) {
        Optional<Section> optionalSection = sectionRepository.findById(resources.getId());
        ValidationUtil.isNull(optionalSection, "Section", "id", resources.getId());

        Section section = optionalSection.get();
        // 此处需自己修改
        resources.setId(section.getId());
        sectionRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        sectionRepository.deleteById(id);
    }
}