package net.pixelplugins.products.dto.response.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import net.pixelplugins.products.entity.Product;

@AllArgsConstructor
@Getter
@Setter
public class ReadProductResponse {

    private String name;
    private String description;
    private String author;
    private String version;

    private double price;

    private double creditPrice;

    private byte[] file;

    private long categoryId;

    public ReadProductResponse(Product product) {
        this.name = product.getName();
        this.description = product.getDescription();
        this.author = product.getAuthor();
        this.version = product.getVersion();
        this.price = product.getPrice();
        this.creditPrice = product.getCreditPrice();
        this.file = product.getFile();
        this.categoryId = product.getCategory().getId();
    }

}
