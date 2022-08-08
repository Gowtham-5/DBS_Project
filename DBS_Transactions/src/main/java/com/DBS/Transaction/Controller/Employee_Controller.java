package com.DBS.Transaction.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.DBS.Transaction.Model.Employee;
import com.DBS.Transaction.Repository.Employee_Repository;
import com.DBS.Transaction.Service.Employee_Service;

@RestController
@RequestMapping("/payment/employee")
public class Employee_Controller {

    @Autowired
    private Employee_Service employee_Service;

    @Autowired
    private Employee_Repository employee_Repository;

    @PostMapping("/add")
    public Employee addEmployee(@RequestBody Employee employee) {
        return employee_Service.AddEmployee(employee);
    }
    @GetMapping("/findall")
    public List<Employee> getListofEmployee(){
        return employee_Service.Employee_List();
    }
    @GetMapping("/empid/{employeeid}/get")
    public Employee findById(@PathVariable Integer employeeid ) {
        Optional<Employee> data=employee_Repository.findById(employeeid);
        if(data.isPresent()) {
            return data.get();
        }
        else {
            return new Employee();
        }
    }

}
