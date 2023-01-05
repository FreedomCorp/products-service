package net.pixelplugins.products.service;

import lombok.AllArgsConstructor;
import net.pixelplugins.products.dto.request.category.CreateCategoryRequest;
import net.pixelplugins.products.dto.response.category.CreateCategoryResponse;
import net.pixelplugins.products.dto.response.category.ReadCategoryResponse;
import net.pixelplugins.products.entity.Category;
import net.pixelplugins.products.exception.CategoryNotFoundException;
import net.pixelplugins.products.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CategoryService {

    private CategoryRepository repository;

    public CreateCategoryResponse create(CreateCategoryRequest request) {
        var category = repository.save(Category.builder()
                        .name(request.getName())
                .build());

        return new CreateCategoryResponse(category.getId(), category.getName(), category.getCreatedAt());
    }

    public ReadCategoryResponse findById(long id) throws CategoryNotFoundException {
        var category = repository.findById(id).orElseThrow(CategoryNotFoundException::new);
        return new ReadCategoryResponse(category);
    }

    public List<ReadCategoryResponse> findAll() {
        return repository.findAll().stream()
                .map(ReadCategoryResponse::new)
                .toList();
    }

}
