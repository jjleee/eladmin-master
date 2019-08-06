package me.zhengjie.modules.data.repository;

import me.zhengjie.modules.data.domain.ProcessData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author jie
 * @date 2019-05-22
 */
public interface ProcessDataRepository extends JpaRepository<ProcessData, Long>, JpaSpecificationExecutor {
}