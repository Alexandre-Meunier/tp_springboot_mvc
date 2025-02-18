package fr.devavance.tp_springboot_mvc_jpa.dao;

import fr.devavance.tp_springboot_mvc_jpa.beans.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IEmployeeRepository extends CrudRepository<Employee, Long> {
}
