package com.springlearn.controller;

import com.springlearn.controller.dto.StudentRequestDto;
import com.springlearn.controller.dto.StudentResponseDto;
import com.springlearn.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public Long createStudent(@RequestBody StudentRequestDto studentRequestDto) {
        return studentService.saveStudent(studentRequestDto.getName(), studentRequestDto.getUin());
    }

    @RequestMapping(value = "/students/{studentId}", method = RequestMethod.GET)
    public StudentResponseDto getStudent(@PathVariable Long studentId){
        return new StudentResponseDto(studentService.findStudentById(studentId));
    }
}