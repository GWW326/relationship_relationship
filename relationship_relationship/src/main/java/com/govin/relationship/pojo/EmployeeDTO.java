package com.govin.relationship.pojo;

import java.io.Serializable;

public class EmployeeDTO implements Serializable {
    private Employee employee;
    private Department department;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public EmployeeDTO(Employee employee, Department department) {
        this.employee = employee;
        this.department = department;
    }
}
