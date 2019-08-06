package me.zhengjie.modules.warning.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.exception.BadRequestException;
import me.zhengjie.modules.warning.domain.PowerWarning;
import me.zhengjie.modules.warning.service.PowerWarningService;
import me.zhengjie.modules.warning.service.dto.PowerWarningDTO;
import me.zhengjie.modules.warning.service.query.PowerWarningQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
* @author jie
* @date 2019-07-23
*/
@RestController
@RequestMapping("api")
public class PowerWarningController {

    @Autowired
    private PowerWarningService powerWarningService;

    @Autowired
    private PowerWarningQueryService powerWarningQueryService;

    private static final String ENTITY_NAME = "powerWarning";

    @Log("查询PowerWarning")
    @GetMapping(value = "/powerWarning")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity getPowerWarnings(PowerWarningDTO resources, Pageable pageable){
        return new ResponseEntity(powerWarningQueryService.queryAll(resources,pageable),HttpStatus.OK);
    }

    @Log("新增PowerWarning")
    @PostMapping(value = "/powerWarning")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity create(@Validated @RequestBody PowerWarning resources){
        if (resources.getId() != null) {
            throw new BadRequestException("A new "+ ENTITY_NAME +" cannot already have an ID");
        }
        return new ResponseEntity(powerWarningService.create(resources),HttpStatus.CREATED);
    }

    @Log("修改PowerWarning")
    @PutMapping(value = "/powerWarning")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity update(@Validated @RequestBody PowerWarning resources){
        if (resources.getId() == null) {
            throw new BadRequestException(ENTITY_NAME +" ID Can not be empty");
        }
        powerWarningService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除PowerWarning")
    @DeleteMapping(value = "/powerWarning/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity delete(@PathVariable Long id){
        powerWarningService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}