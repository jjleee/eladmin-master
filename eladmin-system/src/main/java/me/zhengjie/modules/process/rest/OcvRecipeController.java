package me.zhengjie.modules.process.rest;

import me.zhengjie.aop.log.Log;
import me.zhengjie.exception.BadRequestException;
import me.zhengjie.modules.process.domain.OcvRecipe;
import me.zhengjie.modules.process.service.OcvRecipeService;
import me.zhengjie.modules.process.service.dto.OcvRecipeDTO;
import me.zhengjie.modules.process.service.query.OcvRecipeQueryService;
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
public class OcvRecipeController {

    @Autowired
    private OcvRecipeService ocvRecipeService;

    @Autowired
    private OcvRecipeQueryService ocvRecipeQueryService;

    private static final String ENTITY_NAME = "ocvRecipe";

    @Log("查询OcvRecipe")
    @GetMapping(value = "/ocvRecipe")
    public ResponseEntity getOcvRecipes(OcvRecipeDTO resources, Pageable pageable) {
        return new ResponseEntity(ocvRecipeQueryService.queryAll(resources, pageable), HttpStatus.OK);
    }

    @Log("新增OcvRecipe")
    @PostMapping(value = "/ocvRecipe")
    public ResponseEntity create(@Validated @RequestBody OcvRecipe resources) {
        if (resources.getId() != null) {
            throw new BadRequestException("A new " + ENTITY_NAME + " cannot already have an ID");
        }
        return new ResponseEntity(ocvRecipeService.create(resources), HttpStatus.CREATED);
    }

    @Log("修改OcvRecipe")
    @PutMapping(value = "/ocvRecipe")
    public ResponseEntity update(@Validated @RequestBody OcvRecipe resources) {
        if (resources.getId() == null) {
            throw new BadRequestException(ENTITY_NAME + " ID Can not be empty");
        }
        ocvRecipeService.update(resources);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @Log("删除OcvRecipe")
    @DeleteMapping(value = "/ocvRecipe/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        ocvRecipeService.delete(id);
        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping(value = "/ocvRecipe/names")
    public ResponseEntity getOcvNames() {
        return new ResponseEntity(ocvRecipeQueryService.queryAllName(), HttpStatus.OK);
    }
}