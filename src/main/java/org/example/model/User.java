package org.example.model;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usert")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message = "Name shouldn't be empty")
    @Size(min = 2, max = 30, message = "incorrect filled field")
    @Column(nullable = false, name = "name")
    private String name;

    @NotEmpty(message = "Mail shouldn't be empty")
    @Email(message = "Mail should be valid")
    @Column(name = "eMail")
    private String mail;

    @Min(value=1,message = "Age should be greater than 0")
    private int age;

    public User() {
    }

    public User(int id, String name, String mail, int age) {
        this.id = id;
        this.name = name;
        this.mail = mail;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String firstName) {
        this.name = firstName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
