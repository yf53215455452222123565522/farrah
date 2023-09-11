//Ceating JPA Entity-Employee
package springbootbackend.backend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// @Getter and @Setter are Lombok anotations and we can use @Data anotation in the place of both @Getter and @Setter
@Getter
@Setter
//also @NoArgsContructor and @AllArgsConstructor are Lombok anotations
@NoArgsConstructor
@AllArgsConstructor
//@Entity is a JPA anotations
@Entity
//@Table anotation to provide the table details
@Table( name = "employees")
//Let's define instences variables wish are the id, firstName, LastName, emailId.
//An instance variable is a class property that can be different for each object. You create an instance variable by declaring it in the class definition, outside of any method. Instance variables are important because they allow each object to have its own copy of the data.
public class Employee {
    @Id
    // @Id anotation we use to make it as our primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // we used  @GeneratedValue because we need to provide
    private long id;
    //we specifies the name in the colum because we dont want the name to be for exemple firstName because it do it automaticaly
    @Column(name="first_name")
    private String firstName;
    @Column(name="last_name")
    private String LastName;
    @Column(name="email_id")
    private String emailId;
}
