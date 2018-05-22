package com.juddar.service;

import com.juddar.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookService {

//    @Qualifier("bookDao") //指定装配的bean的id，优先级比 @Primary高，
    @Autowired
//    @Resource
    private BookDao bookDao;

    public void print(){
        System.err.println(bookDao);
    }
}
