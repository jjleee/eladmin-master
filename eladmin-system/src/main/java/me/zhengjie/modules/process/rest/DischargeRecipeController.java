package me.zhengjie.modules.process.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.exception.BadRequestException;
import me.zhengjie.modules.process.domain.DischargeRecipe;
import me.zhengjie.modules.process.service.DischargeRecipeService;
import me.zhengjie.modules.process.service.dto.DischargeRecipeDTO;
import me.zhengjie.modules.process.service.query.DischargeRecipeQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

/**
 * @author jie
 * @date 2019-04-26
 */
@RestController
@RequestMapping("api")
public class DischargeRecipeController {

    @Autowired
    private DischargeRecipeService dischargeRecipeService;

    @Autowired
    private DischargeRecipeQueryService dischargeRecipeQueryService;

    private static final String ENTITY_NAME = "dischargeRecipe";

    @Log("查询DischargeRecipe")
    @GetMapping(value = "/dischargeRecipe")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity getDischargeRecipes(DischargeRecipeDTO resources, Pageable pageable) {
        return new ResponseEntity(dischargeRecipeQueryService.queryAllPlus(resources, pageable), HttpStatus.OK);
    }

    @Log("新增DischargeRecipe")
    @PostMapping(value = "/dischargeRecipe")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity create(@Validated @RequestBody DischargeRecipeDTO resources) {
        if (resources.getId() != null && resources.getId() != "") {
            throw new BadRequestException("A new " + ENTITY_NAME + " cannot already have an ID");
        }
        return new ResponseEntity(dischargeRecipeService.create(resources), HttpStatus.CREATED);
    }

    @Log("修改DischargeRecipe")
    @PutMapping(value = "/dischargeRecipe")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity update(@Validated @RequestBody DischargeRecipeDTO resources, Principal principal) {
        if (resources.getId() == null) {
            throw new BadRequestException(ENTITY_NAME + " ID Can not be empty");
        }
        dischargeRecipeService.update(resources, principal);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除DischargeRecipe")
    @DeleteMapping(value = "/dischargeRecipe/{id}")
    @PreAuthorize("hasAnyRole('ADMIN')")
    public ResponseEntity delete(@PathVariable String id) {
        dischargeRecipeService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/dischargeRecipe/names/{type}")
    public ResponseEntity getDischargeNames(@PathVariable Integer type) {
        return new ResponseEntity(dischargeRecipeQueryService.queryAllName(type), HttpStatus.OK);
    }
}