package com.example.empproject;

import java.util.List;

public interface EmpService {
    String createEmployee(Employee employee);

    List<Employee> readEmployees();

    boolean deleteEmployee(Long id);

    String updateEmp(Long id, Employee employee);

}
