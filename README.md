
# Employee-Management-System

The Employee Management System using Spring Boot is a web-based application designed to streamline the management of employee data for an organisation. 

This application provides an easy-to-use interface for HR personnel to manage employee information such as personal details, job roles, salary information, and more. 

The application also allows employees to view their own information and make updates to their personal details.




## 🚀 About Me
*Hi, My name is Nikhil Sharma*,

I'm a full stack developer trainee at Geekster. I have knowledge of Java, OOPs, Maven, APIs, DSA, SpringBoot.


# Data Flow

## Controller Section
-   *This section contains a Employee Controller* :

* ### Employee Controller
    - This class contains various APIs which helps to add, update, read and delete Employee and their info.

    * @PostMapping("HR/{Password}")
    * @PostMapping("Employee/{Hr}")
    * @GetMapping("Employee")
    * @PutMapping("Employee/{Id}")
    * @DeleteMapping("Employee/{Id}/{Hr}")
    * @PostMapping("report/{Hr}")
    * @PutMapping("report/{Hr}")
    * @GetMapping("report")

## Service Section

- *This section contains 2 classes each of which contains methods for buisness logics of the APIs*

* ### Employee Service Class

    * ResponseEntity<String> createEmployee(Employee employee, Integer Hr)
    * List<Employee> getAll()
    * ResponseEntity<String> updateEmployee(Integer id, Employee employee)
    * ResponseEntity<String> deleteEmployee(Integer id,Integer Hr)
    * ResponseEntity<String> createHR(Employee hr, Integer Password)

* ### Report Service Class

    * ResponseEntity<String> addReport(Integer hr, Report empReport)
    * ResponseEntity<String> updateReport(Integer hr, Report empReport)
    * List<Report> getReport()

## Model Section

- *This section contains 2 models which are used as tables to store data in our database.*
- ***Employee** and **Report** are our two models.*

## Repository Section

- *This section contains 2 Repositories each corresponding to our 2 models.*

- *They all extend **JPA Repository**.*

## Database Design
- *Here we have used Relational Data to store information about our patients and doctors.*

- *We have used MYSQL and the database is hosted on a local server.*

## Summary

*This project demonstrates how a organisation can keep track of their employee's data and how a HR can manage that data.*

*Here HR can also create a performance report for a employee and make updates to their profile and data as required.*

*This is coded in **Java** language.*
## 🔗 Links
[![Github](https://img.shields.io/badge/Github-000?style=for-the-badge&logo=ko-fi&logoColor=white)](https://github.com/Nikhil-Sharma-CS)
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/nikhil-sharma-cse)


