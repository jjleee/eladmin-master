package me.zhengjie.modules.basicInfo.repository;

import me.zhengjie.modules.basicInfo.domain.Factory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author jie
 * @date 2019-04-10
 */
public interface FactoryRepository extends JpaRepository<Factory, Long>, JpaSpecificationExecutor {
    /**
     * 根据名称查找
     *
     * @param name
     * @return
     */
    Factory findByName(String name);
}