package models.POJO;

import java.sql.Date;
import java.sql.Time;

/**
 * Created by Ирина on 24.02.2017.
 */
public class Journal {
    public int id;
    public int id_group;
    public int id_lesson;
    public Date date_lec;
    public String time_lec;

    public String name_group;
    public String name_lection;

    public Journal(int id, int id_group, int id_lesson, Date date_lec, String time_lec) {
        this.id = id;
        this.id_group = id_group;
        this.id_lesson = id_lesson;
        this.date_lec = date_lec;
        this.time_lec = time_lec;
    }

    public Journal() {
    }

    public String getName_group() {
        return name_group;
    }

    public void setName_group(String name_group) {
        this.name_group = name_group;
    }

    public String getName_lection() {
        return name_lection;
    }

    public void setName_lection(String name_lection) {
        this.name_lection = name_lection;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_group() {
        return id_group;
    }

    public void setId_group(int id_group) {
        this.id_group = id_group;
    }

    public int getId_lesson() {
        return id_lesson;
    }

    public void setId_lesson(int id_lesson) {
        this.id_lesson = id_lesson;
    }

    public Date getDate_lec() {
        return date_lec;
    }

    public void setDate_lec(Date date_lec) {
        this.date_lec = date_lec;
    }

    public String getTime_lec() {
        return time_lec;
    }

    public void setTime_lec(String time_lec) {
        this.time_lec = time_lec;
    }
}
