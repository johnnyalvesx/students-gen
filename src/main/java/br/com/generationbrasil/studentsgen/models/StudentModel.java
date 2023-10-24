package br.com.generationbrasil.studentsgen.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table(name = "TB_STUDENTS")
public class StudentModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idStudent;
    private String name;
    private Integer age;
    private BigDecimal firstSemesterGrade;
    private BigDecimal secondSemesterGrade;
    private String teachersName;
    private Integer classroomNumber;

    public UUID getIdStudent() {
        return idStudent;
    }

    public void setIdStudent(UUID idStudent) {
        this.idStudent = idStudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getFirstSemesterGrade() {
        return firstSemesterGrade;
    }

    public void setFirstSemesterGrade(BigDecimal firstSemesterGrade) {
        this.firstSemesterGrade = firstSemesterGrade;
    }

    public BigDecimal getSecondSemesterGrade() {
        return secondSemesterGrade;
    }

    public void setSecondSemesterGrade(BigDecimal secondSemesterGrade) {
        this.secondSemesterGrade = secondSemesterGrade;
    }

    public String getTeachersName() {
        return teachersName;
    }

    public void setTeachersName(String teachersName) {
        this.teachersName = teachersName;
    }

    public Integer getClassroomNumber() {
        return classroomNumber;
    }

    public void setClassroomNumber(Integer classroomNumber) {
        this.classroomNumber = classroomNumber;
    }
}
