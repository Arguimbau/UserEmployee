package kea.dk.useremployee.dto;

import kea.dk.useremployee.model.Gender;

import java.time.LocalDateTime;

public record EmployeeNoIdDTO(String name, LocalDateTime born, Gender gender, Boolean vegetarian ) {
}
