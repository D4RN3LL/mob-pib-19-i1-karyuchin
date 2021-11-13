package org.sibadi.staff;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Staff {

    private static final List<Staff> STAFF_LIST = new ArrayList<>();

    private final LocalDate date;
    private final String id;

    private String phone;
    private String name;
    private int age;

    public Staff(String name, int age, String phone) {
        id = UUID.randomUUID().toString();
        date = LocalDate.now();
        setPhone(phone);
        setName(name);
        setAge(age);

        STAFF_LIST.add(this);
    }

    public static List<Staff> getStaffList(){
        return STAFF_LIST;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getPhone() {
        return phone;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString(){
        return name + " " + age + " " + phone + " " + date + " " + id;
    }
}