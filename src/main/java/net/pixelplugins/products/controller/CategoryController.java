package net.pixelplugins.products.controller;

import lombok.AllArgsConstructor;
import net.pixelplugins.products.dto.request.category.CreateCategoryRequest;
import net.pixelplugins.products.dto.response.category.CreateCategoryResponse;
import net.pixelplugins.products.dto.response.category.ReadCategoryResponse;
import net.pixelplugins.products.exception.CategoryNotFoundException;
import net.pixelplugins.products.service.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService service;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public CreateCategoryResponse create(@RequestBody CreateCategoryRequest request) {
        return service.create(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReadCategoryResponse findById(@PathVariable long id) throws CategoryNotFoundException {
        return service.findById(id);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ReadCategoryResponse> findAll() {
        return service.findAll();
    }

}
