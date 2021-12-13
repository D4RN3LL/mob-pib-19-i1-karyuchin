package org.sibadi.staff;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Waiter extends Staff implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private static final List<Waiter> WAITER_LIST = new ArrayList<>();

    public Waiter(String name, int age, String phone) {
        super(name, age, phone);
        WAITER_LIST.add(this);
    }

    public static List<Waiter> getWaiterList() {
        return WAITER_LIST;
    }
}