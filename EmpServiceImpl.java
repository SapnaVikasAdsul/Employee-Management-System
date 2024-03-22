package com.example.empproject;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

@Service
public class EmpServiceImpl implements EmpService {
   @Autowired
   private EmpRepos emprepos;
   // List<Employee> employees = new ArrayList<>();

   @Override
   public String createEmployee(Employee employee) {
      EmpEntity empEntity = new EmpEntity();
      BeanUtils.copyProperties(employee, empEntity);
      emprepos.save(empEntity);
      // employees.add(employee);
      return "Saved Successfully";
   }

   @Override
   public List<Employee> readEmployees() {
      List<EmpEntity> empList = emprepos.findAll();
      List<Employee> employees = new ArrayList<>();

      for (EmpEntity empEntity : empList) {
         Employee emp = new Employee();
         emp.setName(empEntity.getName());
         emp.setEmail(empEntity.getEmail());
         employees.add(emp);
      }
      return employees;
   }

   @Override
   public boolean deleteEmployee(Long id) {
      EmpEntity emp = emprepos.findById(id).get();
      emprepos.delete(emp);
      return true;
   }

   @Override
   public String updateEmp(Long id, Employee employee) {
      EmpEntity existEmp = emprepos.findById(id).get();
      existEmp.setName(employee.getName());
      existEmp.setPhone(employee.getPhone());
      existEmp.setEmail(employee.getEmail());
      emprepos.save(existEmp);
      return "updated successfully";
   }

}
