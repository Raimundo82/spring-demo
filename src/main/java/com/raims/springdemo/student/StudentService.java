package com.raims.springdemo.student;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class StudentService {

    public List<Student> getStudents() {
        return List.of(
                new Student(1L,
                        "Raimundo",
                        "raimundo@gmail.com",
                        LocalDate.of(1982, Month.OCTOBER, 19),
                        38
                ));
    }
}
