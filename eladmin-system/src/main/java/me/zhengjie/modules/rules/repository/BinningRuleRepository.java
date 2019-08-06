package me.zhengjie.modules.rules.repository;

import me.zhengjie.modules.rules.domain.BinningRule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

/**
 * @author jie
 * @date 2019-04-09
 */
public interface BinningRuleRepository extends JpaRepository<BinningRule, Long>, JpaSpecificationExecutor {
}