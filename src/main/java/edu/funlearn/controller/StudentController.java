package edu.funlearn.controller;

import edu.funlearn.dto.Student;
import edu.funlearn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/students")
@Tag(description = "Students", name = "Students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/{id}")
    @Operation(summary = "Get Student")
    public Mono<ResponseEntity<Student>> getStudent(@PathVariable Long id) {
        return studentService.getStudentById(id)
                .map(student -> ResponseEntity.ok(student))
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @GetMapping
    @Operation(summary = "Get All Student")
    public Flux<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PostMapping
    @Operation(summary = "Add Student")
    public Mono<Student> createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Student")
    public Mono<ResponseEntity<Void>> deleteStudent(@PathVariable long id) {
        return studentService.deleteStudent(id)
                .map(r -> ResponseEntity.ok().<Void>build())
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
}

