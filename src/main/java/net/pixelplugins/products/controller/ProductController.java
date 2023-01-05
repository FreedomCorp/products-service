package net.pixelplugins.products.controller;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.pixelplugins.products.dto.request.product.CreateProductRequest;
import net.pixelplugins.products.dto.response.product.ReadProductResponse;
import net.pixelplugins.products.exception.CategoryNotFoundException;
import net.pixelplugins.products.exception.ProductNotFoundException;
import net.pixelplugins.products.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private ProductService service;

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public ReadProductResponse create(@RequestBody CreateProductRequest request) throws CategoryNotFoundException {
        return service.create(request);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ReadProductResponse findById(@PathVariable long id) throws ProductNotFoundException {
        return service.findById(id);
    }

    @GetMapping("/all")
    @ResponseStatus(HttpStatus.OK)
    public List<ReadProductResponse> findAll() {
        return service.findAll();
    }

}
