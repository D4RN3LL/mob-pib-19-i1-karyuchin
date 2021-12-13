package org.sibadi.product;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Steak extends Product implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final static List<Steak> STEAK_LIST = new ArrayList<>();

    public Steak(String name, String composition, BigDecimal price) {
        super(name, composition, price);
        STEAK_LIST.add(this);
    }

    public static List<Steak> getSoupList() {
        return STEAK_LIST;
    }
}