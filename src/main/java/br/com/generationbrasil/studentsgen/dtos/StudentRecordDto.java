package br.com.generationbrasil.studentsgen.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record StudentRecordDto(@NotBlank String name,
                               @NotNull Integer age,
                               @NotNull BigDecimal firstSemesterGrade,
                               @NotNull BigDecimal secondSemesterGrade,
                               @NotBlank String teachersName,
                               @NotNull Integer classroomNumber) {
}
