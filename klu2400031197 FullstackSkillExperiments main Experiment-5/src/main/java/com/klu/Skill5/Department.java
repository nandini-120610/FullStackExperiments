package com.klu.Skill5;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees;

    public Department() {}

    public Department(String name, List<Employee> employees) {
        this.name = name;
        this.employees = employees;
    }

    public void setId(int id) {
		this.id = id;
	}

	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}

	public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

	public void setName(String string) {
		// TODO Auto-generated method stub
		
	}
}