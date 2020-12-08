package eu.fade.jpa.domain;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @Column(name="employee_id")
    private Integer id;
    @Column(name = "first_name", columnDefinition = "VARCHAR(40)")
    private String firstName;
    @Column(name = "last_name", columnDefinition = "VARCHAR(60)", nullable = false)
    private String lastName;
    @Column(name = "employee_number", columnDefinition = "VARCHAR(15)", unique = true)
    private String employeeNumber;
    @Column(name = "date_in_service", nullable = false)
    private LocalDate dateInService;
    private boolean active;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(50)")
    private Function function;
    @Lob
    private byte[] picture;
    @Column(nullable = false)
    private Double wage;

    @ManyToMany(mappedBy="employees")
    private Set<Department> departments = new HashSet<>();

    @Embedded
    private Address address = new Address();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public LocalDate getDateInService() {
        return dateInService;
    }

    public void setDateInService(LocalDate dateInService) {
        this.dateInService = dateInService;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public Function getFunction() {
        return function;
    }

    public void setFunction(Function function) {
        this.function = function;
    }

    public byte[] getPicture() {
        return picture;
    }

    public void setPicture(byte[] picture) {
        this.picture = picture;
    }

    public Double getWage() {
        return wage;
    }

    public void setWage(Double wage) {
        this.wage = wage;
    }

    public Set<Department> getDepartments() {
        return departments;
    }

    public void setDepartments(Set<Department> departments) {
        this.departments = departments;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
