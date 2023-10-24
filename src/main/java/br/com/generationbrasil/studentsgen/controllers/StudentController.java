package br.com.generationbrasil.studentsgen.controllers;

import br.com.generationbrasil.studentsgen.dtos.StudentRecordDto;
import br.com.generationbrasil.studentsgen.models.StudentModel;
import br.com.generationbrasil.studentsgen.repositories.StudentRepository;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @PostMapping("/students")
    public ResponseEntity<StudentModel> saveStudent(@RequestBody @Valid StudentRecordDto studentRecordDto) {
        var studentModel = new StudentModel();
        BeanUtils.copyProperties(studentRecordDto, studentModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentRepository.save(studentModel));
    }

    @GetMapping("/students")
    public ResponseEntity<List<StudentModel>> getAllStudents() {
        return ResponseEntity.status(HttpStatus.OK).body(studentRepository.findAll());
    }

    @GetMapping("/students/{idStudent}")
    public ResponseEntity<Object> getOneStudent(@PathVariable(value = "idStudent") UUID idStudent) {
        Optional<StudentModel> student = studentRepository.findById(idStudent);
        if (student.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(student.get());
    }

    @PutMapping("/students/{idStudent}")
    public ResponseEntity<Object> updateStudent(@PathVariable(value = "idStudent") UUID idStudent,
                                                @RequestBody @Valid StudentRecordDto studentRecordDto) {
        Optional<StudentModel> student = studentRepository.findById(idStudent);
        if (student.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado.");
        }
        var studentModel = student.get();
        BeanUtils.copyProperties(studentRecordDto, studentModel);
        return ResponseEntity.status(HttpStatus.OK).body(studentRepository.save(studentModel));
    }

    @DeleteMapping("/students/{idStudent}")
    public ResponseEntity<Object> deleteStudent(@PathVariable(value = "idStudent") UUID idStudent) {
        Optional<StudentModel> student = studentRepository.findById(idStudent);
        if (student.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado.");
        }
        studentRepository.delete(student.get());
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Aluno deletado do sistema com sucesso.");
    }
}
