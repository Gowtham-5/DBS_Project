package com.DBS.Transaction.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.DBS.Transaction.Model.Employee;
import com.DBS.Transaction.Repository.Employee_Repository;

@Service
public class Employee_Service {
    @Autowired  
    private Employee_Repository employee_Repository;

    public List<Employee> Employee_List(){
        return employee_Repository.findAll();
    }
    public Employee AddEmployee(@RequestBody Employee employee) {
        return employee_Repository.save(employee);
    }

}
