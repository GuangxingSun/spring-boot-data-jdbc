package com.guangxing.controller;

import com.guangxing.bean.Department;
import com.guangxing.bean.Employee;
import com.guangxing.mapper.DepartmentMapper;
import com.guangxing.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author apple
 * @create time 2020/4/22 1:40 下午
 **/
@RestController
public class DeptController {

    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;


    @GetMapping("/dept/{id}")
    public Department getDepartment(@PathVariable("id") Integer id){
        return departmentMapper.getDeptById(id);
    }

    @GetMapping("/dept")
    public Department insetDept(Department department){
        departmentMapper.insertDept(department);
        return department;
    }

    @GetMapping("/emp/{id}")
    public Employee getEmployee(@PathVariable("id") Integer id){
        return employeeMapper.getEmById(id);
    }


    @GetMapping("/emp")
    public Employee insertEmployee(Employee employee){
        employeeMapper.insertEmp(employee);

        return  employee;
    }

}
