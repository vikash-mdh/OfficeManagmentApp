package com.Acciojob.OfficeManagementApp;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class Controller {
    Map<Integer,Employee> empDb =  new HashMap<>();

    // add employee
    @PostMapping("/add-employee")
    public  String addEmployee( @RequestBody Employee employee){
        empDb.put(employee.getEmpId(), employee);
        return "Employee Register Sussesfully";
    }


    // get employee
    @GetMapping("/get-employee")
    public Employee getEmployee(@RequestParam("id") int empId, @RequestParam("name") String name) {
        return empDb.get(empId);
    }

    // delete employee
    @DeleteMapping("/delete-employee/{id}")
    public String deleteEmployee(@PathVariable("id") int empId) {
        empDb.remove(empId);
        return "Employee Deleted Successfully";
    }
}
