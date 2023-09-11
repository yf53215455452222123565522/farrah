package springbootbackend.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springbootbackend.backend.model.Employee;
import springbootbackend.backend.repositoy.EmployeeRepository;

@SpringBootApplication
public class BackEndApplication implements CommandLineRunner {
//Main ava class in our project is BackEndApplication
	public static void main(String[] args) {
		SpringApplication.run(BackEndApplication.class, args);
	}
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
		Employee employee= new Employee();
		employee.setFirstName("youssef");
		employee.setLastName("farrah");
		employee.setEmailId("youssef.farrah7@gmail.com");
		employeeRepository.save(employee);



		Employee employee1= new Employee();
		employee1.setFirstName("john");
		employee1.setLastName("cena");
		employee1.setEmailId("cena@gmail.com");
		employeeRepository.save(employee1);

	}
}
