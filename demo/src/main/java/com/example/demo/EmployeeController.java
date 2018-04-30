package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployRepository employRepository;

    @PostMapping(value = "/employee")
    public Employee addEmployee(@RequestParam("name") String name, @RequestParam("id") int id, @RequestParam("gender") String gender, @RequestParam("age") int age) {
        Employee employee = new Employee();
        employee.setAge(age);
        employee.setGender(gender);
        employee.setId(id);
        employee.setName(name);
        return employRepository.save(employee);
    }



    @GetMapping(value = "/employee")
    private List<Employee> personList() {
        return employRepository.findAll();
    }
}
