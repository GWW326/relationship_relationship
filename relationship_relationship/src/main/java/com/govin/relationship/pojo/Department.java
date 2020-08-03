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
@Table(name="tb_department")
public class Department implements Serializable{

	@Id
	private Long id;//


	@Column(name = "name")
	private String departmentName;//

	
	public Long getId() {		
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getDepartmentName() {
		return departmentName;
	}
	public void setName(String departmentName) {
		this.departmentName = departmentName;
	}


	
}
