package com.spring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@AllArgsConstructor
public class Mentor {
    private String firstName;
    private String lastName;
    private boolean graduated;
    private String email;
    private String gender;
    private String batch;
    private String company;

}
