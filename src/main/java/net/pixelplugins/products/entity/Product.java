package net.pixelplugins.products.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @Lob
    @Column
    private String description;

    @Column
    private String author;

    @Column
    private String version;

    @Column
    private double price;

    @Column
    private double creditPrice;

    @Column
    private byte[] file;

    @Column
    private Date createdAt = new Date();

    @Column
    private Date updatedAt = new Date();

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
