package com.springlearn.service;

import com.springlearn.entity.Student;
import com.springlearn.entity.Teacher;
import com.springlearn.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;

    @Autowired
    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }
    public Long saveTeacher(String name, Long uin) {
        return teacherRepository.save(new Teacher(name, uin)).getTeacherId();
    }

    public Teacher findTeacherById(Long teacherId){
        return teacherRepository.findById(teacherId);
    }

    public Teacher updateTeacher(Long teacherId, String name, Long uin) {
        return teacherRepository.updateById(teacherId, new Teacher(name, uin));
    }

    public Teacher deleteTeacherById(Long teacherId) {
        return teacherRepository.deleteById(teacherId);
    }
}