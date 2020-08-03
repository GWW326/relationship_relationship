package com.govin.relationship.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
/**
 * 实体类
 * @author Administrator
 *
 */
@Entity
@Table(name="tb_employee")
public class Employee implements Serializable{

	@Id
	private Long id;//


	
	private String name;//

	private String departmentId;//

	
	public Long getId() {		
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {		
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getDepartmentId() {
		return departmentId;
	}
    @Column(name = "department_id")
	public void setDepartmentId(String departmentId) {
		this.departmentId = departmentId;
	}


	
}
