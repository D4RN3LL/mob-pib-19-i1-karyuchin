package org.sibadi.product;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Pudding extends Product implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private final static List<Pudding> PUDDING_LIST = new ArrayList<>();

    public Pudding(String name, String composition, BigDecimal price) {
        super(name, composition, price);
        PUDDING_LIST.add(this);
    }

    public static List<Pudding> getPasteList() {
        return PUDDING_LIST;
    }
}