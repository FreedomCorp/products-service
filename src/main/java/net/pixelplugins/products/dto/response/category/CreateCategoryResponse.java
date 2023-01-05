package net.pixelplugins.products.dto.response.category;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
@Getter
public class CreateCategoryResponse {

    private long id;

    private String name;
    private Date createdAt;

}
