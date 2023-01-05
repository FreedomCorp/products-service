package net.pixelplugins.products.dto.request.product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class CreateProductRequest {

    private String name;
    private String description;
    private String author;
    private String version;

    private double price;
    private double creditPrice;

    private byte[] file;
    private long categoryId;


}
