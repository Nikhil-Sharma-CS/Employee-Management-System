package org.example.Employee.Management.System.Service;

import org.example.Employee.Management.System.Model.Employee;
import org.example.Employee.Management.System.Model.Report;
import org.example.Employee.Management.System.Repository.EmpRepo;
import org.example.Employee.Management.System.Repository.ReportRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReportService {

    @Autowired
    ReportRepo reportRepo;

    @Autowired
    EmpRepo empRepo;

    @Autowired
    EmpService empService;

    public ResponseEntity<String> addReport(Integer hr, Report empReport) {
        //Check if hr is real
        if(!empService.checkHR(hr))
            return new ResponseEntity<>("HR does not exists", HttpStatus.FORBIDDEN);

        //Check if employee exists or not
        Integer empId = empReport.getEmployee().getId();

        if(empId == null)
            return new ResponseEntity<>("Employee Id can't be null", HttpStatus.NOT_FOUND);

        Employee employee = empRepo.findById(empId).orElse(null);

        if(employee == null)
            return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);

        empReport.setEmployee(employee);

        reportRepo.save(empReport);

        return new ResponseEntity<>("Report created", HttpStatus.CREATED);
    }

    public ResponseEntity<String> updateReport(Integer hr, Report empReport) {
        //Check if hr is real
        if(!empService.checkHR(hr))
            return new ResponseEntity<>("HR does not exists", HttpStatus.FORBIDDEN);

        Report original = reportRepo.findById(empReport.getId()).orElse(null);

        if(original == null)
            return new ResponseEntity<>("Report does not exists", HttpStatus.NOT_FOUND);

        if(empReport.getAttendance()!= null)
            original.setAttendance(empReport.getAttendance());
        if(empReport.getRating()!= null)
            original.setRating(empReport.getRating());

        reportRepo.save(original);
        return new ResponseEntity<>("Report saved", HttpStatus.OK);
    }

    public List<Report> getReport() {
        return reportRepo.findAll();
    }
}
