package me.zhengjie.modules.basicInfo.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.exception.BadRequestException;
import me.zhengjie.modules.basicInfo.domain.ExperimentBattery;
import me.zhengjie.modules.basicInfo.service.ExperimentBatteryService;
import me.zhengjie.modules.basicInfo.service.dto.ExperimentBatteryDTO;
import me.zhengjie.modules.basicInfo.service.query.ExperimentBatteryQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
* @author jie
* @date 2019-08-02
*/
@RestController
@RequestMapping("api")
public class ExperimentBatteryController {

    @Autowired
    private ExperimentBatteryService experimentBatteryService;

    @Autowired
    private ExperimentBatteryQueryService experimentBatteryQueryService;

    private static final String ENTITY_NAME = "experimentBattery";

    @Log("查询ExperimentBattery")
    @GetMapping(value = "/experimentBattery")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity getExperimentBatterys(ExperimentBatteryDTO resources, Pageable pageable){
        return new ResponseEntity(experimentBatteryQueryService.queryAll(resources,pageable),HttpStatus.OK);
    }

    @Log("新增ExperimentBattery")
    @PostMapping(value = "/experimentBattery")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity create(@Validated @RequestBody ExperimentBattery resources){
        if (resources.getId() != null) {
            throw new BadRequestException("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        return new ResponseEntity(experimentBatteryService.create(resources),HttpStatus.CREATED);
    }

    @Log("批量新增ExperimentBattery")
    @PostMapping(value = "/experimentBattery/addExcel")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity create(@RequestBody String[] data){
        experimentBatteryService.createExcel(data);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @Log("修改ExperimentBattery")
    @PutMapping(value = "/experimentBattery")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity update(@Validated @RequestBody ExperimentBattery resources){
        if (resources.getId() == null) {
            throw new BadRequestException(ENTITY_NAME +" ID Can not be empty");
        }
        experimentBatteryService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除ExperimentBattery")
    @DeleteMapping(value = "/experimentBattery/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity delete(@PathVariable Long id){
        experimentBatteryService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}