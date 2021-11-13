package org.sibadi.product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Steak extends Product {

    private final static List<Steak> STEAK_LIST = new ArrayList<>();

    public Steak(String name, String composition, BigDecimal price) {
        super(name, composition, price);
        STEAK_LIST.add(this);
    }

    public static List<Steak> getSoupList() {
        return STEAK_LIST;
    }
}