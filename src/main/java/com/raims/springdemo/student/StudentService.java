package com.raims.springdemo.student;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        checkEmailExistence(student.getEmail());
        studentRepository.save(student);
    }

    private void checkEmailExistence(String email) {
        Optional<Student> studentByEmail = studentRepository
                .findStudentByEmail(email);
        if (studentByEmail.isPresent())
            throw new IllegalStateException("EMAIL ALREADY REGISTERED");
    }

    public void addNewStudents(List<Student> students) {
        students.forEach(this::addNewStudent);
    }

    public void deleteStudent(Long id) {
        Student student = checkIfStudentExists(id);
        studentRepository.delete(student);
    }

    private Student checkIfStudentExists(Long id) {
        return studentRepository.findById(id).orElseThrow(() -> new IllegalStateException("STUDENT WITH ID: " + id + " DOES NOT EXIST"));
    }

    @Transactional
    public void updateStudent(Long id, Student studentUpdate) {
        Student student = checkIfStudentExists(id);
        if (checkStringConsistency(studentUpdate.getName(), student.getName()))
            student.setName(studentUpdate.getName());
        if (checkStringConsistency(studentUpdate.getEmail(), student.getEmail())) {
            checkEmailExistence(studentUpdate.getEmail());
            student.setEmail(studentUpdate.getEmail());
        }
    }

    private boolean checkStringConsistency(String string, String oldString) {
        return !string.isBlank() && !string.equals(oldString);
    }
}
