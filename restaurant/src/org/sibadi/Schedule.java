package org.sibadi;

import org.sibadi.staff.Staff;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public record Schedule(LocalDate date, Staff staff, int hours) {
    private static final List<Schedule> SCHEDULE_LIST = new ArrayList<>();

    public Schedule {
        SCHEDULE_LIST.add(this);
    }

    public static List<Schedule> getScheduleList() {
        return SCHEDULE_LIST;
    }

    public LocalDate getDate() {
        return date;
    }

    public Staff getStaff() {
        return staff;
    }

    public int getHours() {
        return hours;
    }

    @Override
    public String toString(){
        return staff + " " + date + " " + hours;
    }
}