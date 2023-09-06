package org.example.Employee.Management.System.Controller;


import org.example.Employee.Management.System.Model.Employee;
import org.example.Employee.Management.System.Model.Report;
import org.example.Employee.Management.System.Service.EmpService;
import org.example.Employee.Management.System.Service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmpController {

    @Autowired
    EmpService empService;

    @Autowired
    ReportService reportService;

    //HR registration
    @PostMapping("HR/{Password}")
    public ResponseEntity<String> createHR(@RequestBody Employee Hr, @PathVariable Integer Password)
    {
        return empService.createHR(Hr, Password);
    }

    //Employee registration
    @PostMapping("Employee/{Hr}")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee, @PathVariable Integer Hr)
    {
        return empService.createEmployee(employee, Hr);
    }


    //See Employees
    @GetMapping("Employee")
    public List<Employee> getAll()
    {
        return empService.getAll();
    }

    //Update Info
    @PutMapping("Employee/{Id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Integer Id, @RequestBody Employee employee)
    {
        return empService.updateEmployee(Id, employee);
    }

    //Delete Employee
    @DeleteMapping("Employee/{Id}/{Hr}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Integer Id, @PathVariable Integer Hr)
    {
        return empService.deleteEmployee(Id, Hr);
    }

    //Create report only by HR
    @PostMapping("report/{Hr}")
    public ResponseEntity<String> addReport(@PathVariable Integer Hr, @RequestBody Report empReport)
    {
        return reportService.addReport(Hr, empReport);
    }

    //Update report only by HR
    @PutMapping("report/{Hr}")
    public ResponseEntity<String> updateReport(@PathVariable Integer Hr, @RequestBody Report empReport)
    {
        return reportService.updateReport(Hr, empReport);
    }

    //Get reports
    @GetMapping("report")
    public List<Report> getReport()
    {
        return reportService.getReport();
    }
}
