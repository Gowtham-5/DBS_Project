package com.DBS.Transaction.Model;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {


    @Id
    private Integer employeeid;
    private String employeename;
    private String employeepasssword;
    public Integer getEmployeeid() {
        return employeeid;
    }
    public void setEmployeeid(Integer employeeid) {
        this.employeeid = employeeid;
    }
    public String getEmployeename() {
        return employeename;
    }
    public void setEmployeename(String employeename) {
        this.employeename = employeename;
    }
    public String getEmployeepasssword() {
        return employeepasssword;
    }
    public void setEmployeepasssword(String employeepasssword) {
        this.employeepasssword = employeepasssword;
    }
    @Override
    public int hashCode() {
        return Objects.hash(employeeid, employeename, employeepasssword);
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Employee other = (Employee) obj;
        return Objects.equals(employeeid, other.employeeid) && Objects.equals(employeename, other.employeename)
                && Objects.equals(employeepasssword, other.employeepasssword);
    }
    @Override
    public String toString() {
        return "Employee [employeeid=" + employeeid + ", employeename=" + employeename + ", employeepasssword="
                + employeepasssword + "]";
    }


}
