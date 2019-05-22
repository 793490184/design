package com.restaurant.entity;

public class Person {
    private Integer id;
    private String account;
    private String password;
    private String name;
    private String telephone;
    private String position;

    public Person(String account, String password, String name, String telephone, String position) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.telephone = telephone;
        this.position = position;
    }


    public Person(String account, String password, String name, String telephone) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.telephone = telephone;
    }

    public Person(Integer id, String account, String password, String name, String telephone) {
        this.id = id;
        this.account = account;
        this.password = password;
        this.name = name;
        this.telephone = telephone;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", account=" + account +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
