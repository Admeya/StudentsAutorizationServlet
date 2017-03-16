package ru.students.spring.models.POJO;


import javax.persistence.*;

/**
 * Created by Ирина on 22.02.2017.
 */
@Entity
@Table(name = "student")
public class Students {
    @Id
    @GeneratedValue
    public int id;
    @Column
    public String name;
    @Column
    public int age;

    public int id_group;

    public Students(int id, String name, int age, int id_group) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.id_group = id_group;
    }

    public Students() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId_group() {
        return id_group;
    }

    public void setId_group(int id_group) {
        this.id_group = id_group;
    }

    @Override
    public String toString() {
        return "Students{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", id_group=" + id_group +
                '}';
    }
}
