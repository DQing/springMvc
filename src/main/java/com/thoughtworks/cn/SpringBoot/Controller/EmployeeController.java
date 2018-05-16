package com.thoughtworks.cn.SpringBoot.Controller;

import com.thoughtworks.cn.SpringBoot.Entity.Employee;
import com.thoughtworks.cn.SpringBoot.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by douqing on 18-5-16.
 */

@RestController
@RequestMapping(value = "/api")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping(value = "/employees")
    public ResponseEntity getEmployee() throws Exception {
        List<Employee> employeeList = employeeRepository.findAll();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @PostMapping(value = "/employees")
    public ResponseEntity addEmployee(@RequestBody Map<String,String> data) throws Exception{
        String name = data.get("name");
        Long age = Long.valueOf(data.get("age"));
        String gender = data.get("gender");
        Employee employee = new Employee(name,age,gender);
        employeeRepository.save(employee);
        List<Employee> employeeList = employeeRepository.findAll();
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @PutMapping(value = "/employees/{id}")
    public ResponseEntity updateEmployee(@PathVariable String id, @RequestBody Map<String, String> data) throws Exception {
        Employee employee = employeeRepository.findOne(Long.valueOf(id));
        String name = data.get("name");
        Long age = Long.valueOf(data.get("age"));
        String gender = data.get("gender");
        employee.setName(name);
        employee.setAge(age);
        employee.setGender(gender);
        employeeRepository.save(employee);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @DeleteMapping(value = "/employees/{id}")
    public ResponseEntity deleteEmployee(@PathVariable Long id) throws Exception{
        employeeRepository.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
