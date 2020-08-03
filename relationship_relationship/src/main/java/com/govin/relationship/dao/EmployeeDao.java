package com.govin.relationship.dao;

import com.govin.relationship.pojo.EmployeeDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.govin.relationship.pojo.Employee;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface EmployeeDao extends JpaRepository<Employee,Long>,JpaSpecificationExecutor<Employee>{
	@Query(value = "select  new com.govin.relationship.pojo.EmployeeDTO(e,d) from Employee e , Department d WHERE e.departmentId = d.id ",nativeQuery = false)
    public List<EmployeeDTO> queryEmployeeDTOs();
}
