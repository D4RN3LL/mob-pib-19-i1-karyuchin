package org.sibadi.product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Product {

    private final static List<Product> PRODUCT_LIST = new ArrayList<>();
    private final String id;

    private String composition;
    private BigDecimal price;
    private String name;

    public Product(String name, String composition, BigDecimal price){
        id = UUID.randomUUID().toString();
        setComposition(composition);
        setPrice(price);
        setName(name);

        PRODUCT_LIST.add(this);
    }

    public static List<Product> getProductList() {
        return PRODUCT_LIST;
    }

    public String getComposition() {
        return composition;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public void setComposition(String composition) {
        this.composition = composition;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString(){
        return name + " " + composition + " " + price + " " + id;
    }
}