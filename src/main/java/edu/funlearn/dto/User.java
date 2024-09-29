package edu.funlearn.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import lombok.Data;

import java.util.List;

@Data
@Table("users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Automatically generate ID
    private Long id;
    private String username;
    private String password; // This should be stored in an encoded format
}

