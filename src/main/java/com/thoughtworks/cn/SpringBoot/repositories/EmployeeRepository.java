package com.thoughtworks.cn.SpringBoot.repositories;

import com.thoughtworks.cn.SpringBoot.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
