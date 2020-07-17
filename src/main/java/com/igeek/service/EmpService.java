package com.igeek.service;

import com.igeek.dao.EmpDao;
import com.igeek.pojo.Emp;
import com.igeek.pojo.EmpNumber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpService {
    @Autowired
    private EmpDao empDao;

    @Transactional
    public EmpNumber findBySalary(int depId){
        EmpNumber empNumber=null;
        empNumber=empDao.findSomeSalary(depId);
        return empNumber;
    }
    @Transactional
    public List<Emp> findBydepId(int depId){
        return empDao.findByDepId(depId);
    }



}
