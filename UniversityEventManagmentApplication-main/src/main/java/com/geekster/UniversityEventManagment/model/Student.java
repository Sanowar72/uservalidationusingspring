package com.geekster.UniversityEventManagment.model;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table
public class Student {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentId;

    @NotBlank(message = "First name is required")
    @Pattern(regexp = "[A-Z][a-zA-Z]*", message = "First name should start with a capital letter")
    private String firstName;

    @NotBlank(message = "Last name is required")
    @Pattern(regexp = "[A-Za-z]+", message = "Last name should contain only alphabets")
    private String lastName;

    @NotNull(message = "Age is required")
    @Min(value = 18, message = "Age should not be less than 18")
    @Max(value = 25, message = "Age should not be greater than 25")
    private Integer age;

    @NotNull(message = "Department is required")
    @Enumerated(EnumType.STRING)
    private Department department;

}

