package edu.funlearn.dto;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.List;
import java.util.Map;

@Data
@Table("student")  // The table name in H2 database
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Automatically generate ID
    private Long id;
    private String name;
    private String email;

    @ElementCollection
    private List<Long> enrolledClassIds;

    // Map of classId to grade
    @ElementCollection
    private Map<Long, String> grades;
}


