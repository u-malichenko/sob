package ru.malichenko.lesson7.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.malichenko.lesson7.entityes.Student;

@Data
@NoArgsConstructor
public class StudentDto {

    private Long id;
    private String name;
    private int age;

    public StudentDto(Student p) {
        this.id = p.getId();
        this.name = p.getName();
        this.age = p.getAge();
    }
}
