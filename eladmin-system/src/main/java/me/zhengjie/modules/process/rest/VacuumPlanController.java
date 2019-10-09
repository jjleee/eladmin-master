package me.zhengjie.modules.process.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.exception.BadRequestException;
import me.zhengjie.modules.process.domain.VacuumPlan;
import me.zhengjie.modules.process.service.VacuumPlanService;
import me.zhengjie.modules.process.service.dto.VacuumPlanDTO;
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
public class VacuumPlanController {

    @Autowired
    private VacuumPlanService vacuumPlanService;

    @Autowired
    private VacuumPlanQueryService vacuumPlanQueryService;

    private static final String ENTITY_NAME = "vacuumPlan";

    @Log("查询VacuumPlan")
    @GetMapping(value = "/vacuumPlan")
    public ResponseEntity getVacuumPlans(VacuumPlanDTO resources, Pageable pageable) {
        return new ResponseEntity(vacuumPlanQueryService.queryAll(resources, pageable), HttpStatus.OK);
    }

    @Log("新增VacuumPlan")
    @PostMapping(value = "/vacuumPlan")
    public ResponseEntity create(@Validated @RequestBody VacuumPlan resources) {
        if (resources.getId() != null) {
            throw new BadRequestException("A new " + ENTITY_NAME + " cannot already have an ID");
        }
        return new ResponseEntity(vacuumPlanService.create(resources), HttpStatus.CREATED);
    }

    @Log("修改VacuumPlan")
    @PutMapping(value = "/vacuumPlan")
    public ResponseEntity update(@Validated @RequestBody VacuumPlan resources) {
        if (resources.getId() == null) {
            throw new BadRequestException(ENTITY_NAME + " ID Can not be empty");
        }
        vacuumPlanService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除VacuumPlan")
    @DeleteMapping(value = "/vacuumPlan/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        vacuumPlanService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/vacuumPlan/vacuums")
    public ResponseEntity getVacuums() {
        return new ResponseEntity(vacuumPlanQueryService.queryAllName(), HttpStatus.OK);
    }
}