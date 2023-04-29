package com.example.uservalidation.uservalidation.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

//@RestController
@Data
@AllArgsConstructor
@NoArgsConstructor
// @EntityScan
public class User {
    @NotNull
    private Integer id;
    @NotBlank
    private String name;
    @DateTimeFormat(pattern = "dd MMMM yyyy")
    @NotNull(message = "Date of birth must not be null")
    @Past(message = "Date of birth must be in the past")
    private LocalDate dob;
    @Email
    @NotBlank
    private String email;
    @Pattern(regexp = "[0-9]{10}", message = "Invalid phone number")
    private String phoneno;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDate date;
    private LocalTime time;

}
