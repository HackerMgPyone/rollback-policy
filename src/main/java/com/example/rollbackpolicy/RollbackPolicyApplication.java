package com.example.rollbackpolicy;

import com.example.rollbackpolicy.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class RollbackPolicyApplication implements CommandLineRunner{
    private final EmployeeService employeeService;


    public static void main(String[] args) {
        SpringApplication.run(RollbackPolicyApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        employeeService.deleteEmployee();
        try {
            employeeService.createEmployee();
        }catch (Exception e){
            System.out.println("Exception Caught:" + e);
        }
        employeeService.findAllEmployee()
                .forEach(System.out::println);

    }
}
