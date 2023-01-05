package net.pixelplugins.products.dto.request.category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class AddCategoryProductRequest {

    private long categoryId;
    private long productId;

}
