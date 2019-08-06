package me.zhengjie.modules.basicInfo.service.impl;

import me.zhengjie.exception.EntityExistException;
import me.zhengjie.modules.basicInfo.domain.Factory;
import me.zhengjie.utils.ValidationUtil;
import me.zhengjie.modules.basicInfo.repository.FactoryRepository;
import me.zhengjie.modules.basicInfo.service.FactoryService;
import me.zhengjie.modules.basicInfo.service.dto.FactoryDTO;
import me.zhengjie.modules.basicInfo.service.mapper.FactoryMapper;
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
public class FactoryServiceImpl implements FactoryService {

    @Autowired
    private FactoryRepository factoryRepository;

    @Autowired
    private FactoryMapper factoryMapper;

    @Override
    public FactoryDTO findById(Long id) {
        Optional<Factory> factory = factoryRepository.findById(id);
        ValidationUtil.isNull(factory, "Factory", "id", id);
        return factoryMapper.toDto(factory.get());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public FactoryDTO create(Factory resources) {
        if (factoryRepository.findByName(resources.getName()) != null) {
            throw new EntityExistException(Factory.class, "name", resources.getName());
        }
        return factoryMapper.toDto(factoryRepository.save(resources));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(Factory resources) {
        Optional<Factory> optionalFactory = factoryRepository.findById(resources.getId());
        ValidationUtil.isNull(optionalFactory, "Factory", "id", resources.getId());

        Factory factory = optionalFactory.get();
        // 此处需自己修改
        resources.setId(factory.getId());
        factoryRepository.save(resources);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Long id) {
        factoryRepository.deleteById(id);
    }
}