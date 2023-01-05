package net.pixelplugins.products.dto.response.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.pixelplugins.products.dto.response.product.ReadProductResponse;
import net.pixelplugins.products.entity.Category;

import java.util.List;

@AllArgsConstructor
@Getter
public class ReadCategoryResponse {

    private long id;

    private String name;
    private List<ReadProductResponse> products;

    public ReadCategoryResponse(Category category) {
        this.id = category.getId();
        this.name = category.getName();
        this.products = category.getProducts().stream()
                .map(ReadProductResponse::new)
                .toList();
    }
}
