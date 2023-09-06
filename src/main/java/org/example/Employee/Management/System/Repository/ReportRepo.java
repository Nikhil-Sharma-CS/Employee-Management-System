package org.example.Employee.Management.System.Repository;

import org.example.Employee.Management.System.Model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepo extends JpaRepository<Report, Integer> {
}
