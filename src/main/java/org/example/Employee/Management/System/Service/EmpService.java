package org.example.Employee.Management.System.Service;

import org.example.Employee.Management.System.Model.Employee;
import org.example.Employee.Management.System.Repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpService {

    @Autowired
    EmpRepo empRepo;

    public ResponseEntity<String> createEmployee(Employee employee, Integer Hr) {

        //Check if Hr exists or not
        if(!checkHR(Hr))
            return new ResponseEntity<>("HR does not exists", HttpStatus.FORBIDDEN);

        if(employee.getJobRole().equals("HR"))
            return new ResponseEntity<>("HRs are not saved here", HttpStatus.NOT_ACCEPTABLE);

        empRepo.save(employee);
        return new ResponseEntity<>("Data Saved", HttpStatus.CREATED);
    }

    public List<Employee> getAll() {
        return empRepo.findAll();
    }

    public ResponseEntity<String> updateEmployee(Integer id, Employee employee) {
        if(!empRepo.existsById(id))
            return new ResponseEntity<>("Does not exist", HttpStatus.NOT_FOUND);

        Employee employeeDetails = empRepo.findById(id).get();

        if(employee.getEmail()!=null)
        {
            employeeDetails.setEmail(employee.getEmail());
        }
        if(employee.getSalary()!=null)
        {
            employeeDetails.setSalary(employee.getSalary());
        }
        if(employee.getJobRole()!=null)
        {
            employeeDetails.setJobRole(employee.getJobRole());
        }
        if(employee.getFirstName()!=null)
        {
            employeeDetails.setFirstName(employee.getFirstName());
        }
        if(employee.getLastName()!=null)
        {
            employeeDetails.setLastName(employee.getLastName());
        }
        if(employee.getPhoneNumber()!=null)
        {
            employeeDetails.setPhoneNumber(employee.getPhoneNumber());
        }
        empRepo.save(employeeDetails);

        return new ResponseEntity<>("Successfully Updated Data", HttpStatus.OK);
    }

    public ResponseEntity<String> deleteEmployee(Integer id,Integer Hr) {
        if(!empRepo.existsById(id))
            return new ResponseEntity<>("Employee does not exists", HttpStatus.NOT_FOUND);

        if(!checkHR(Hr))
            return new ResponseEntity<>("HR does not exists", HttpStatus.FORBIDDEN);

        empRepo.deleteById(id);
        return new ResponseEntity<>("Employee data deleted", HttpStatus.OK);
    }

    public ResponseEntity<String> createHR(Employee hr, Integer Password) {

        if(Password != 34567)
            return new ResponseEntity<>("You are not authenticated to create a HR", HttpStatus.FORBIDDEN);

        if(!hr.getJobRole().equals("HR"))
            return new ResponseEntity<>("Not a HR", HttpStatus.NOT_ACCEPTABLE);
        empRepo.save(hr);
        return new ResponseEntity<>("HR saved", HttpStatus.OK);
    }

    public boolean checkHR(Integer Hr)
    {
        if(!empRepo.existsById(Hr))
            return false;

        //Get the Hr jobRole, check if it true
        Employee HR = empRepo.findById(Hr).get();

        return HR.getJobRole().equals("HR");
    }
}
