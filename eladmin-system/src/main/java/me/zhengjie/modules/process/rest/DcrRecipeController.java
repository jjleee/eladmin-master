package me.zhengjie.modules.process.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.exception.BadRequestException;
import me.zhengjie.modules.process.domain.DcrRecipe;
import me.zhengjie.modules.process.service.DcrRecipeService;
import me.zhengjie.modules.process.service.dto.DcrRecipeDTO;
import me.zhengjie.modules.process.service.query.DcrRecipeQueryService;
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
public class DcrRecipeController {

    @Autowired
    private DcrRecipeService dcrRecipeService;

    @Autowired
    private DcrRecipeQueryService dcrRecipeQueryService;

    private static final String ENTITY_NAME = "dcrRecipe";

    @Log("查询DcrRecipe")
    @GetMapping(value = "/dcrRecipe")
    public ResponseEntity getDcrRecipes(DcrRecipeDTO resources, Pageable pageable) {
        return new ResponseEntity(dcrRecipeQueryService.queryAllPlus(resources, pageable), HttpStatus.OK);
    }

    @Log("新增DcrRecipe")
    @PostMapping(value = "/dcrRecipe")
    public ResponseEntity create(@Validated @RequestBody DcrRecipeDTO resources) {
        if (resources.getId() != null&& resources.getId() != "") {
            throw new BadRequestException("A new " + ENTITY_NAME + " cannot already have an ID");
        }
        return new ResponseEntity(dcrRecipeService.create(resources), HttpStatus.CREATED);
    }

    @Log("修改DcrRecipe")
    @PutMapping(value = "/dcrRecipe")
    public ResponseEntity update(@Validated @RequestBody DcrRecipeDTO resources) {
        if (resources.getId() == null) {
            throw new BadRequestException(ENTITY_NAME + " ID Can not be empty");
        }
        dcrRecipeService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除DcrRecipe")
    @DeleteMapping(value = "/dcrRecipe/{id}")
    public ResponseEntity delete(@PathVariable String id) {
        dcrRecipeService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/dcrRecipe/names/{type}")
    public ResponseEntity getDcrNames(@PathVariable Integer type) {
        return new ResponseEntity(dcrRecipeQueryService.queryAllName(type), HttpStatus.OK);
    }
}