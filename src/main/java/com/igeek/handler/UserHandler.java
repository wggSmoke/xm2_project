package com.igeek.handler;

import com.igeek.dto.TransferObj;
import com.igeek.pojo.Dep;
import com.igeek.pojo.Emp;
import com.igeek.pojo.EmpNumber;
import com.igeek.pojo.User;
import com.igeek.service.EmpService;
import com.igeek.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UserHandler {
    @Autowired
    private UserService userService;

    private EmpService empService;
    /**
     * 注册
     * @param userName
     * @param password
     * @param session
     * @return
     */

    @GetMapping("login")
    public TransferObj login(String userName, String password, HttpSession session){
        TransferObj transferObj = new TransferObj();
        System.out.println("login");
        System.out.println(userService);
        User user = userService.findUserByName(userName);
        if(user != null){
            if(user.getPassword().equals(password)){
                session.setAttribute("loginUser", user);
                transferObj.setMessage("success");
            }
            else{
                transferObj.setCode(1);
                transferObj.setMessage("密码错误！");
            }
        }
        else{
            transferObj.setCode(1);
            transferObj.setMessage("用户名不存在！");
        }
        return transferObj;
    }

    @GetMapping("hands")
    public TransferObj hand(){
        TransferObj transferObj=new TransferObj();
        List<Dep> list=userService.findAllDep();
        transferObj.setResult(list);

        return transferObj;
    }

    @GetMapping("salarys/{id}")
    public TransferObj empsSalary(@PathVariable("id") int empId){
        TransferObj transferObj=new TransferObj();
        EmpNumber empNumber=empService.findBySalary(empId);
        transferObj.setResult(empNumber);
        return transferObj;
    }
    @GetMapping("findEmp/{id}")
    public TransferObj empsByEmpId(@PathVariable("id") int empId){
        TransferObj transferObj=new TransferObj();
        List<Emp> list=empService.findBydepId(empId);
        transferObj.setResult(list);
        return transferObj;

    }


}
