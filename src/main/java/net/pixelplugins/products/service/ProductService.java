package net.pixelplugins.products.service;

import lombok.AllArgsConstructor;
import net.pixelplugins.products.dto.request.product.CreateProductRequest;
import net.pixelplugins.products.dto.response.product.ReadProductResponse;
import net.pixelplugins.products.entity.Product;
import net.pixelplugins.products.exception.CategoryNotFoundException;
import net.pixelplugins.products.exception.ProductNotFoundException;
import net.pixelplugins.products.repository.CategoryRepository;
import net.pixelplugins.products.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ProductService {

    private final ProductRepository repository;
    private final CategoryRepository categoryRepository;

    public ReadProductResponse create(CreateProductRequest request) throws CategoryNotFoundException {
        var category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(CategoryNotFoundException::new);

        var product = repository.save(Product.builder()
                        .category(category)
                        .name(request.getName())
                        .description(request.getDescription())
                        .author(request.getAuthor())
                        .version(request.getVersion())
                        .price(request.getPrice())
                        .creditPrice(request.getCreditPrice())
                        .version(request.getVersion())
                        .file(request.getFile())
                .build());

        category.getProducts().add(product);
        categoryRepository.save(category);

        return new ReadProductResponse(product);
    }

    public ReadProductResponse findById(long id) throws ProductNotFoundException {
        return repository.findById(id)
                .map(ReadProductResponse::new)
                .orElseThrow(ProductNotFoundException::new);
    }

    public List<ReadProductResponse> findAll() {
        return repository.findAll().stream()
                .map(ReadProductResponse::new)
                .toList();
    }

}
