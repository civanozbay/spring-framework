package com.spring.controller;

import com.spring.client.EmployeeClient;
import com.spring.client.UserClient;
import com.spring.dto.ResponseWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Consume_FeignClient {

    private final UserClient userClient;
    private final EmployeeClient employeeClient;

    public Consume_FeignClient(UserClient userClient,EmployeeClient employeeClient) {
        this.userClient = userClient;
        this.employeeClient=employeeClient;
    }

    @GetMapping("/api/v1/users")
    public ResponseEntity<ResponseWrapper> getUsers(){
        return ResponseEntity.ok(new ResponseWrapper("Userlist retrieved",userClient.getUsers()));
    }
    @GetMapping("api/v1/employees")
    public ResponseEntity<ResponseWrapper> getEmployees(){
        return ResponseEntity.ok(new ResponseWrapper(("Successfully"),employeeClient.getEmployee("6298ebfecd0551211fce37a6")));
    }

}
