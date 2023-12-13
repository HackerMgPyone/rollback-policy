package com.example.rollbackpolicy.service;

import com.example.rollbackpolicy.dao.EmployeeDao;
import com.example.rollbackpolicy.ds.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    private final EmployeeDao employeeDao;
    public void deleteEmployee(){
        employeeDao.deleteEmployee();
    }

    public List<Employee> findAllEmployee(){
        return employeeDao.findAllEmployee();
    }
    @Transactional
    public void createEmployee () throws InterruptedException{
        employeeDao.createEmployee(new Employee(1,"Mg","Mg","mgmg@gmail.com",
                "000-000-000", Date.valueOf("2023-04-13"),2000));
        employeeDao.createEmployee(new Employee(2,"Aung","Aung","aungaung@gmail.com",
                "111-111-111", Date.valueOf("2023-05-13"),2800));
        employeeDao.createEmployee(new Employee(3,"Tun","Tun","tuntun@gmail.com",
                "222-222-222", Date.valueOf("2023-08-13"),2500));
        throw new RuntimeException();
    }

}
