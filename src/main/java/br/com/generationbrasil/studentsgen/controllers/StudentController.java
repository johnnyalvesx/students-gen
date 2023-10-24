package br.com.generationbrasil.studentsgen.controllers;

import br.com.generationbrasil.studentsgen.dtos.StudentRecordDto;
import br.com.generationbrasil.studentsgen.models.StudentModel;
import br.com.generationbrasil.studentsgen.repositories.StudentRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "students-gen")
public class StudentController {

    @Autowired
    StudentRepository studentRepository;

    @Operation(description = "Cadastra um aluno e suas respectivas notas semestrais. " +
            "Deve-se preencher todos os campos.")
    @PostMapping("/students")
    public ResponseEntity<StudentModel> saveStudent(@RequestBody @Valid StudentRecordDto studentRecordDto) {
        var studentModel = new StudentModel();
        BeanUtils.copyProperties(studentRecordDto, studentModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentRepository.save(studentModel));
    }

    @Operation(description = "Retorna todos os alunos cadastrados.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Lista de alunos retornada com sucesso.")
    })
    @GetMapping("/students")
    public ResponseEntity<List<StudentModel>> getAllStudents() {
        return ResponseEntity.status(HttpStatus.OK).body(studentRepository.findAll());
    }

    @Operation(description = "Busca o aluno pelo id. Deve ser informado o valor UUID gerado no cadastro.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aluno encontrado no sistema."),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado no sistema.")
    })
    @GetMapping("/students/{idStudent}")
    public ResponseEntity<Object> getOneStudent(@PathVariable(value = "idStudent") UUID idStudent) {
        Optional<StudentModel> student = studentRepository.findById(idStudent);
        if (student.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Aluno não encontrado.");
        }
        return ResponseEntity.status(HttpStatus.OK).body(student.get());
    }

    @Operation(description = "Atualiza o cadastro de um aluno. " +
            "Deve ser informado o valor UUID gerado no cadastro.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Aluno encontrado atualizado com sucesso."),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado no sistema."),
            @ApiResponse(responseCode = "400", description = "Informar todos os dados do body.")
    })
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

    @Operation(description = "Deleta o cadastro de um aluno. " +
            "Deve ser informado o valor UUID gerado no cadastro.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Aluno deletado do sistema com sucesso."),
            @ApiResponse(responseCode = "404", description = "Aluno não encontrado no sistema."),
    })
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
