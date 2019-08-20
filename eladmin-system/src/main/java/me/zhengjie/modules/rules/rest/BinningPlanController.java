package me.zhengjie.modules.rules.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.exception.BadRequestException;
import me.zhengjie.modules.basicInfo.service.query.BatteryInfoQueryService;
import me.zhengjie.modules.rules.domain.BinningPlan;
import me.zhengjie.modules.rules.domain.BinningRule;
import me.zhengjie.modules.rules.service.BinningPlanService;
import me.zhengjie.modules.rules.service.dto.BinningPlanDTO;
import me.zhengjie.modules.rules.service.query.BinningPlanQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jie
 * @date 2019-04-09
 */
@RestController
@RequestMapping("api")
public class BinningPlanController {

    @Autowired
    private BinningPlanService binningPlanService;

    @Autowired
    private BinningPlanQueryService binningPlanQueryService;

    private BatteryInfoQueryService batteryInfoQueryService;

    private static final String ENTITY_NAME = "BinningPlan";

    @Log("查询BinningPlan")
    @GetMapping(value = "/binningPlan")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity getBinningPlans(BinningPlanDTO resources, Pageable pageable) {
        Object o = binningPlanQueryService.queryAll(resources, pageable);
        return new ResponseEntity(o, HttpStatus.OK);
    }

    @Log("新增BinningPlan")
    @PostMapping(value = "/binningPlan")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity create(@Validated @RequestBody BinningPlan resources) {
        if (resources.getPlanId() != null) {
            throw new BadRequestException("A new " + ENTITY_NAME + " cannot already have an ID");
        }
        resources.getRules().forEach(e -> e.setPlan(resources));
        return new ResponseEntity(binningPlanService.create(resources), HttpStatus.CREATED);
    }

    @Log("修改BinningPlan")
    @PutMapping(value = "/binningPlan")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity update(@Validated @RequestBody BinningPlan resources) {
        if (resources.getPlanId() == null) {
            throw new BadRequestException(ENTITY_NAME + " ID Can not be empty");
        }
        resources.getRules().forEach(e -> e.setPlan(resources));
        binningPlanService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除BinningPlan")
    @DeleteMapping(value = "/binningPlan/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity delete(@PathVariable Long id) {
        binningPlanService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/binningPlan/names")
    public ResponseEntity getPlanNames() {
        return new ResponseEntity(binningPlanQueryService.queryAllName(), HttpStatus.OK);
    }

    @Log("获取工步名")
    @PostMapping(value = "/binningPlan/step/{batteryNumber}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity getStepNames(@Validated @PathVariable String batteryNumber) {
        return new ResponseEntity(binningPlanQueryService.queryAllStepName(batteryNumber), HttpStatus.OK);
    }
}