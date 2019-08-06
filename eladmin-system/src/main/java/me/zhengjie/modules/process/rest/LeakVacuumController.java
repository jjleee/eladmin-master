package me.zhengjie.modules.process.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.exception.BadRequestException;
import me.zhengjie.modules.process.domain.LeakVacuum;
import me.zhengjie.modules.process.domain.VacuumPlan;
import me.zhengjie.modules.process.service.LeakVacuumService;
import me.zhengjie.modules.process.service.VacuumPlanService;
import me.zhengjie.modules.process.service.dto.LeakVacuumDTO;
import me.zhengjie.modules.process.service.dto.VacuumPlanDTO;
import me.zhengjie.modules.process.service.query.LeakVacuumQueryService;
import me.zhengjie.modules.process.service.query.VacuumPlanQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author jie
 * @date 2019-05-18
 */
@RestController
@RequestMapping("api")
public class LeakVacuumController {

    @Autowired
    private LeakVacuumService leakVacuumService;

    @Autowired
    private LeakVacuumQueryService leakVacuumQueryService;

    private static final String ENTITY_NAME = "LeakVacuum";

    @Log("查询LeakVacuum")
    @GetMapping(value = "/leakVacuum")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity getLeakVacuums(LeakVacuumDTO resources, Pageable pageable) {
        return new ResponseEntity(leakVacuumQueryService.queryAll(resources, pageable), HttpStatus.OK);
    }

    @Log("新增LeakVacuum")
    @PostMapping(value = "/leakVacuum")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity create(@Validated @RequestBody LeakVacuum resources) {
        if (resources.getId() != null) {
            throw new BadRequestException("A new " + ENTITY_NAME + " cannot already have an ID");
        }
        return new ResponseEntity(leakVacuumService.create(resources), HttpStatus.CREATED);
    }

    @Log("修改LeakVacuum")
    @PutMapping(value = "/leakVacuum")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity update(@Validated @RequestBody LeakVacuum resources) {
        if (resources.getId() == null) {
            throw new BadRequestException(ENTITY_NAME + " ID Can not be empty");
        }
        leakVacuumService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除LeakVacuum")
    @DeleteMapping(value = "/leakVacuum/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity delete(@PathVariable Long id) {
        leakVacuumService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/leakVacuum/leaks")
    public ResponseEntity getLeakNames() {
        return new ResponseEntity(leakVacuumQueryService.queryAllName(), HttpStatus.OK);
    }
}