package com.DBS.Transaction.Service;

import java.util.List;
import java.util.Optional;

import javax.print.attribute.standard.JobOriginatingUserName;

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
    public Employee findbyname(String employeename) {
    	
    	return employee_Repository.findByEmployeename(employeename);
    }
    public Boolean employeeLogin( String employeename,String employeepasssword ) {
    	Employee employee= employee_Repository.findByEmployeename(employeename);
    	//Optional<Employee>emOptional=Optional.of(employee_Repository.findByEmployeename(employeename));
    	if(employee!=null)
    	return (employee.getEmployeepasssword().equals( employeepasssword));
    	return false;
    	
    }

}
