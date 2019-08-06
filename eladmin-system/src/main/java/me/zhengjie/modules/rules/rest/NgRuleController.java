package me.zhengjie.modules.rules.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.exception.BadRequestException;
import me.zhengjie.modules.rules.domain.NgRule;
import me.zhengjie.modules.rules.service.NgRuleService;
import me.zhengjie.modules.rules.service.dto.NgRuleDTO;
import me.zhengjie.modules.rules.service.query.NgRuleQueryService;
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
public class NgRuleController {

    @Autowired
    private NgRuleService ngRuleService;

    @Autowired
    private NgRuleQueryService ngRuleQueryService;

    private static final String ENTITY_NAME = "ngRule";

    @Log("查询NgRule")
    @GetMapping(value = "/ngRule")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity getNgRules(NgRuleDTO resources, Pageable pageable) {
        return new ResponseEntity(ngRuleQueryService.queryAll(resources, pageable), HttpStatus.OK);
    }

    @Log("新增NgRule")
    @PostMapping(value = "/ngRule")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity create(@Validated @RequestBody NgRule resources) {
        if (resources.getId() != null) {
            throw new BadRequestException("A new " + ENTITY_NAME + " cannot already have an ID");
        }
        return new ResponseEntity(ngRuleService.create(resources), HttpStatus.CREATED);
    }

    @Log("修改NgRule")
    @PutMapping(value = "/ngRule")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity update(@Validated @RequestBody NgRule resources) {
        if (resources.getId() == null) {
            throw new BadRequestException(ENTITY_NAME + " ID Can not be empty");
        }
        ngRuleService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除NgRule")
    @DeleteMapping(value = "/ngRule/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity delete(@PathVariable Long id) {
        ngRuleService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/ngRule/names")
    public ResponseEntity getNgNames() {
        return new ResponseEntity(ngRuleQueryService.queryAllName(), HttpStatus.OK);
    }
}