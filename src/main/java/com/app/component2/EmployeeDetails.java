package com.app.component2;

import javax.persistence.*;

@Entity
@Table(name="employee_detail")
public class EmployeeDetails {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="detail_one")
    private String detailOne;

    @Column(name="detail_two")
    private String detailTwo;

    @OneToOne(mappedBy = "employeeDetails")
    private Employee employee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDetailOne() {
        return detailOne;
    }

    public void setDetailOne(String detailOne) {
        this.detailOne = detailOne;
    }

    public String getDetailTwo() {
        return detailTwo;
    }

    public void setDetailTwo(String detailTwo) {
        this.detailTwo = detailTwo;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public EmployeeDetails() {
    }

    public EmployeeDetails(int id, String detailOne, String detailTwo, Employee employee) {
        this.id = id;
        this.detailOne = detailOne;
        this.detailTwo = detailTwo;
        this.employee = employee;
    }
}
