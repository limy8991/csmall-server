package cn.tedu.csmall.product.webapi.controller;

import cn.tedu.csmall.common.web.JsonResult;
import cn.tedu.csmall.pojo.dto.CategoryAddNewDTO;
import cn.tedu.csmall.product.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categories", produces = "application/json;charset=utf-8")
public class CategoryController {
    public CategoryController() {
        System.out.println("CategoryController.CategoryController");
    }

    @Autowired
    private ICategoryService categoryService;

    @PostMapping("/add-new")
    @Validated
    public JsonResult<Void> addNew(@Validated CategoryAddNewDTO categoryAddNewDTO) {
        categoryService.addNew(categoryAddNewDTO);
        return JsonResult.ok();
    }
}
