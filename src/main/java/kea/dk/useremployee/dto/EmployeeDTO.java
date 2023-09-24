package kea.dk.useremployee.dto;

import kea.dk.useremployee.model.Gender;
import kea.dk.useremployee.model.User;

import java.time.LocalDateTime;

public record EmployeeDTO( int id, String name, LocalDateTime born, Gender gender, Boolean vegetarian ) {
}