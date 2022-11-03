package com.study.algorithms.examples;

public class Employee {

    private int id;
    private String name;

    private String departament;

    private double salary;

    public Employee(int id, String name, String departament, double salary) {
        this.id = id;
        this.name = name;
        this.departament = departament;
        this.salary = salary;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}