package com.guangxing.mapper;

import com.guangxing.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author apple
 * @create time 2020/4/22 3:25 下午
 **/
//@Mapper或者@MapperScan将接口扫描装配到容器中去
//@Mapper
public interface EmployeeMapper {

    public Employee getEmById(Integer id);

    public void insertEmp(Employee employee);

}
