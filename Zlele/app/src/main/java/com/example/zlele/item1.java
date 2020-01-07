package com.example.zlele;

import java.text.SimpleDateFormat;
import java.util.Date;

public class item1 {
    final static SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String title;
    Date date;


    public item1(String title, Date date) {
        this.title = title;
        this.date = date;
    }

    public String getTitle() {
        return title;
    }

    public Date getDate() {
        return date;
    }

    public String getDateFormatted() {
        return format.format(date);
    }
}
