package com.api.controllers;

import com.api.exception.ResouceNotFoundException;
import com.api.model.Student;
import com.api.repoistory.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @PostMapping("/student")
    public Student createStudent(@RequestBody Student student) {
        return studentRepository.save(student);
    }

    @GetMapping("/student")
    public List<Student> getAllStudent(){
        return studentRepository.findAll();
    }

    @GetMapping("/student/{id}")
    public ResponseEntity <Student> getStudentById(@PathVariable Integer id){
       Student student = studentRepository.findById(id)
               .orElseThrow(() -> new ResouceNotFoundException("Id cant not find"+id));
       return ResponseEntity.ok(student);
    }

    @PutMapping("/student/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Integer id , @RequestBody Student student){
       Student std = studentRepository.findById(id)
               .orElseThrow(()-> new ResouceNotFoundException("Id cant not find" + id));

       std.setFirstName(student.getFirstName());
       std.setLastName(student.getLastName());
       std.setContact(student.getContact());
       std.setEmai(student.getEmai());

       Student updateStudent = studentRepository.save(std);
       return ResponseEntity.ok(updateStudent);
    }

    @DeleteMapping("/student/{id}")
    public ResponseEntity<Map<String , Boolean>> deleteStudent(@PathVariable Integer id) {
        Student std = studentRepository.findById(id)
                .orElseThrow(()-> new ResouceNotFoundException("Cant not find id"+id));
        studentRepository.delete(std);

        Map<String , Boolean> response = new HashMap<>();
        response.put("delete",Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}
