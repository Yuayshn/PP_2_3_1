package web.model;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    @NotEmpty(message = "Name should be between 2 and 25 latin characters")
    @Size(min = 2, max = 25)
    private String name;

    @Column(name = "lastName")
    @NotEmpty(message = "Name should be between 2 and 25 latin characters")
    @Size(min = 2, max = 25)
    private String lastName;

    @Column
    @NotEmpty(message = "age should me not empty")
    @Min(value = 0, message = "Age should be >= 0")
    @Max(value = 127, message = "Age should be < 128")
    private Byte age;

    public User() {

    }

    public User(String name, String lastName, Byte age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Byte getAge() {
        return age;
    }

    public void setAge(Byte age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("User {id = '%s', name = '%s', lastName = '%s', age = '%d'}", getId(), getName(), getLastName(), getAge());
    }
}
