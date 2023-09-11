//Creating Spring Data JPA Repository
package springbootbackend.backend.repositoy;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springbootbackend.backend.model.Employee;
@Repository
// we have to add jpa anotation(@Repository) because spring data jpa enternaly take care adding at jpaRepository implementation class
//this repository should extend a jpaRepository wich expect two parameters that are type of jpaEntity that is Employee and secondly type of primary key(id) that is Long
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    //all crud database methods
}

