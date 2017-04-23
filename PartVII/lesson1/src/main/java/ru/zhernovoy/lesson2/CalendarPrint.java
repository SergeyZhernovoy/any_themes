package ru.zhernovoy.lesson2;

import java.time.LocalDate;

/**
 * @author Sergey Zhernovoy
 * create on 21.04.2017.
 */

/**
 * @see LocalDate
 */

public class CalendarPrint {

    private LocalDate currentDate;

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(LocalDate currentDate) {
        this.currentDate = currentDate;
    }

    public void printCalendarDate(){
        System.out.println(String.format("%tm %tB %tY года",this.getCurrentDate(),this.getCurrentDate(),this.getCurrentDate()));
    }

    public static void main(String[] args) {
        CalendarPrint calendarPrint = new CalendarPrint();
        calendarPrint.setCurrentDate(LocalDate.now());
        calendarPrint.printCalendarDate();
        System.gc();
    }

}

    