package me.zhengjie.modules.basicInfo.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.exception.BadRequestException;
import me.zhengjie.modules.basicInfo.domain.ExpBatteryInfo;
import me.zhengjie.modules.basicInfo.service.ExpBatteryInfoService;
import me.zhengjie.modules.basicInfo.service.dto.ExpBatteryInfoDTO;
import me.zhengjie.modules.basicInfo.service.query.ExpBatteryInfoQueryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author jie
 * @date 2019-04-01
 */
@RestController
@RequestMapping("api")
public class ExpBatteryInfoController {

    @Autowired
    private ExpBatteryInfoService batteryInfoService;

    @Autowired
    private ExpBatteryInfoQueryService batteryInfoQueryService;

    private static final String ENTITY_NAME = "expBatteryInfo";

    @Log("查询ExpBatteryInfo")
    @GetMapping(value = "/expBatteryInfo")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity getBatteryInfos(ExpBatteryInfoDTO resources, Pageable pageable) {
        return new ResponseEntity(batteryInfoQueryService.queryAll(resources, pageable), HttpStatus.OK);
    }

    @Log("新增ExpBatteryInfo")
    @PostMapping(value = "/expBatteryInfo")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity create(@Validated @RequestBody ExpBatteryInfoDTO resources) {
        if (resources.getId() != null) {
            throw new BadRequestException("A new " + ENTITY_NAME + " cannot already have an ID");
        }
        ExpBatteryInfo batteryInfo = new ExpBatteryInfo();
        BeanUtils.copyProperties(resources, batteryInfo);
        batteryInfo.setLineName(String.join("|", resources.getLineNames()));
        return new ResponseEntity(batteryInfoService.create(batteryInfo), HttpStatus.CREATED);
    }

    @Log("修改ExpBatteryInfo")
    @PutMapping(value = "/expBatteryInfo")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity update(@Validated @RequestBody ExpBatteryInfoDTO resources) {
        if (resources.getId() == null) {
            throw new BadRequestException(ENTITY_NAME + " ID Can not be empty!!");
        }
        batteryInfoService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除ExpBatteryInfo")
    @DeleteMapping(value = "/expBatteryInfo/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity delete(@PathVariable Long id) {
        batteryInfoService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }


    @Log("查询所有电池型号")
    @GetMapping(value = "/expBatteryInfo/names")
    public ResponseEntity getBatteryInfos() {
        return new ResponseEntity(batteryInfoQueryService.queryAllName(), HttpStatus.OK);
    }
}