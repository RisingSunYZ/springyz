package com.anotation.dao;

import com.anotation.model.MyDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.inject.Inject;

@Repository
public class StudentDaoImpl implements IStudentDao{


    private MyDataSource myDataSource;

    @Qualifier("dataSource2")
    @Autowired(required = false)
    public void setMyDataSource(MyDataSource myDataSource) {
        this.myDataSource = myDataSource;
    }

    @Override
    public void save() {
        System.out.println(myDataSource);
    }
}
