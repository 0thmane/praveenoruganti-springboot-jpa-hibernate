package com.praveen.spring.jpa.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.praveen.spring.jpa.entity.Employee;
import com.praveen.spring.jpa.entity.FullTimeEmployee;
import com.praveen.spring.jpa.entity.PartTimeEmployee;

@Repository
@Transactional
public class EmployeeRepository {

	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	// insert Employee

	public void insert(Employee employee) {
		em.persist(employee);
	}

	public List<Employee> retrieveAllEmployees(){
		return em.createQuery("Select e from Employee e", Employee.class).getResultList();
	}
	
	public List<PartTimeEmployee> retrievePartTimeEmployees(){
		return em.createQuery("Select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
	}
	
	public List<FullTimeEmployee> retrieveFullTimeEmployees(){
		return em.createQuery("Select e from FullTimeEmployee e", FullTimeEmployee.class).getResultList();
	}

}
