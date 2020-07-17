package com.igeek.dao;

import com.igeek.pojo.Emp;
import com.igeek.pojo.EmpNumber;

import java.util.List;

public interface EmpDao {



    public EmpNumber findSomeSalary(int depId);
    public List<Emp> findByDepId(int depId);
}
