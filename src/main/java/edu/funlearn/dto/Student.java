package edu.funlearn.dto;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;

import java.util.List;
import java.util.Map;

@Data
@Table("student")  // The table name in H2 database
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Automatically generate ID
    private Long id;

    @Column("firstname")
    private String firstName;

    @Column("lastname")
    private String lastName;

}


