package com.anotation.controller;


import com.anotation.service.IStudentService;
import org.springframework.stereotype.Controller;

import javax.inject.Inject;

@Controller
public class StudentController {

    @Inject
    private IStudentService studentService;

    public void save(){
        studentService.save();
    }

}
