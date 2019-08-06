package me.zhengjie.modules.rules.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.exception.BadRequestException;
import me.zhengjie.modules.rules.domain.BinningRule;
import me.zhengjie.modules.rules.service.BinningRuleService;
import me.zhengjie.modules.rules.service.dto.BinningRuleDTO;
import me.zhengjie.modules.rules.service.query.BinningRuleQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author jie
 * @date 2019-04-09
 */
@RestController
@RequestMapping("api")
public class BinningRuleController {

    @Autowired
    private BinningRuleService binningRuleService;

    @Autowired
    private BinningRuleQueryService binningRuleQueryService;

    private static final String ENTITY_NAME = "binningRule";

    @Log("查询BinningRule")
    @GetMapping(value = "/binningRule")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity getBinningRules(BinningRuleDTO resources, Pageable pageable) {
        return new ResponseEntity(binningRuleQueryService.queryAll(resources, pageable), HttpStatus.OK);
    }

    @Log("新增BinningRule")
    @PostMapping(value = "/binningRule")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity create(@Validated @RequestBody BinningRule resources) {
        if (resources.getId() != null) {
            throw new BadRequestException("A new " + ENTITY_NAME + " cannot already have an ID");
        }
        return new ResponseEntity(binningRuleService.create(resources), HttpStatus.CREATED);
    }

    @Log("修改BinningRule")
    @PutMapping(value = "/binningRule")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity update(@Validated @RequestBody BinningRule resources) {
        if (resources.getId() == null) {
            throw new BadRequestException(ENTITY_NAME + " ID Can not be empty");
        }
        binningRuleService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除BinningRule")
    @DeleteMapping(value = "/binningRule/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity delete(@PathVariable Long id) {
        binningRuleService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/binningRule/names")
    public ResponseEntity getBinningNames() {
        return new ResponseEntity(binningRuleQueryService.queryAllName(), HttpStatus.OK);
    }
}