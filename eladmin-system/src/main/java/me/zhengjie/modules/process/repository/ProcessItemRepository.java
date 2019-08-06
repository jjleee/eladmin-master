package me.zhengjie.modules.process.repository;

import me.zhengjie.modules.process.domain.ProcessItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

/**
 * @author jie
 * @date 2019-04-08
 */
public interface ProcessItemRepository extends JpaRepository<ProcessItem, String>, JpaSpecificationExecutor {

    void deleteProcessItemsByProcessId(String processId);

    List<ProcessItem> findByProcessId(String processId);
}