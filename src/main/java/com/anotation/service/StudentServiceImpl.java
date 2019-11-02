package com.anotation.service;

import com.anotation.dao.IStudentDao;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class StudentServiceImpl implements IStudentService{

    @Resource
    private IStudentDao studentDao;

    @Override
    public void save() {
        studentDao.save();
    }
}
