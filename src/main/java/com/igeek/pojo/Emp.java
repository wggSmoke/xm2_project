package com.igeek.pojo;

import java.util.Date;

public class Emp {
    private Integer empId;
    private String empName;
    private Integer salary;
    private Integer depId;
    private Date pushTime;


    public Emp(Integer empId, String empName, Integer salary, Integer depId, Date pushTime) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.depId = depId;
        this.pushTime = pushTime;
    }

    public Emp() {
    }

    public Integer getEmpId() {
        return empId;
    }

    public void setEmpId(Integer empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public Date getPushTime() {
        return pushTime;
    }

    public void setPushTime(Date pushTime) {
        this.pushTime = pushTime;
    }
}
