package com.raims.springdemo.student;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping(path = "api/v1/student")
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping(path = "api/v1/add-student")
    public void registerStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    @PostMapping(path = "api/v1/add-students")
    public void registerStudent(@RequestBody List<Student> students) {
        studentService.addNewStudents(students);
    }

    @DeleteMapping(path = "api/v1/delete-student/{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long id) {
        studentService.deleteStudent(id);
    }

    @PutMapping(path = "api/v1/update-student/{studentId}")
    public void updateStudent(
            @PathVariable("studentId") Long id, @RequestBody Student studentUpdate) {
        studentService.updateStudent(id, studentUpdate);
    }
}
