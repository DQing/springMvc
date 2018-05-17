package com.thoughtworks.cn.SpringBoot.Controller;

import com.thoughtworks.cn.SpringBoot.Entity.Employee;
import com.thoughtworks.cn.SpringBoot.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/api")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping()
    public String getEmployee(Model model) throws Exception {
        List<Employee> employeeList = employeeRepository.findAll();
        model.addAttribute("employeeList", employeeList);
        return "list";
    }
}
