package me.zhengjie.modules.process.repository;

import me.zhengjie.modules.process.domain.StepProtectParam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

/**
 * @author jie
 * @date 2019-04-25
 */
public interface StepProtectParamRepository extends JpaRepository<StepProtectParam, Long>, JpaSpecificationExecutor {
    /**
     * 根据工步名称查询所有模板
     *
     * @param stroke
     * @return
     */
    List<StepProtectParam> findAllByStepName(String stroke);

    /**
     * 根据模板名称查找模板
     * @param protectName
     * @return
     */

    StepProtectParam findByProtectName(String protectName);
}