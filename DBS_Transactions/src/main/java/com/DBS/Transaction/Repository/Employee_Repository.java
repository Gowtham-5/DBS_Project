
package com.DBS.Transaction.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.DBS.Transaction.Model.Employee;
@Repository
public interface Employee_Repository extends JpaRepository<Employee, Integer> {
}


