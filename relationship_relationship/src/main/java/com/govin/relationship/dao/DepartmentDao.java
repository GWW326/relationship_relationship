package com.govin.relationship.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.govin.relationship.pojo.Department;
/**
 * 数据访问接口
 * @author Administrator
 *
 */
public interface DepartmentDao extends JpaRepository<Department,Long>,JpaSpecificationExecutor<Department>{
	
}
