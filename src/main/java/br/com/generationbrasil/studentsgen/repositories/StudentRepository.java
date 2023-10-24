package br.com.generationbrasil.studentsgen.repositories;

import br.com.generationbrasil.studentsgen.models.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, UUID> {

}
