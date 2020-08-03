package com.govin.relationship.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Selection;

import com.govin.relationship.pojo.EmployeeDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Persistent;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import util.IdWorker;

import com.govin.relationship.dao.EmployeeDao;
import com.govin.relationship.pojo.Employee;

/**
 * 服务层
 * 
 * @author Administrator
 *
 */
@Service
public class EmployeeService {

    @PersistenceContext
    private EntityManager em;
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private IdWorker idWorker;

	/**
	 * 查询全部列表
	 * @return
	 */
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	
	/**
	 * 条件查询+分页
	 * @param whereMap
	 * @param page
	 * @param size
	 * @return
	 */
	public Page<Employee> findSearch(Map whereMap, int page, int size) {
		Specification<Employee> specification = createSpecification(whereMap);
		PageRequest pageRequest =  PageRequest.of(page-1, size);
		return employeeDao.findAll(specification, pageRequest);
	}

	
	/**
	 * 条件查询
	 * @param whereMap
	 * @return
	 */
	public List<Employee> findSearch(Map whereMap) {
		Specification<Employee> specification = createSpecification(whereMap);
		return employeeDao.findAll(specification);
	}

	/**
	 * 根据ID查询实体
	 * @param id
	 * @return
	 */
	public Employee findById(Long id) {
		return employeeDao.findById(id).get();
	}

	/**
	 * 增加
	 * @param employee
	 */
	public void add(Employee employee) {
		//employee.setId( idWorker.nextId()+"" );
		employeeDao.save(employee);
	}

	/**
	 * 修改
	 * @param employee
	 */
	public void update(Employee employee) {
		employeeDao.save(employee);
	}

	/**
	 * 删除
	 * @param id
	 */
	public void deleteById(Long id) {
		employeeDao.deleteById(id);
	}

	/**
	 * 动态条件构建
	 * @param searchMap
	 * @return
	 */
	private Specification<Employee> createSpecification(Map searchMap) {

		return new Specification<Employee>() {

			@Override
			public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
				List<Predicate> predicateList = new ArrayList<Predicate>();
                // 
                if (searchMap.get("name")!=null && !"".equals(searchMap.get("name"))) {
                	predicateList.add(cb.like(root.get("name").as(String.class), "%"+(String)searchMap.get("name")+"%"));
                }
				
				return cb.and( predicateList.toArray(new Predicate[predicateList.size()]));

			}
		};

	}

    public Object queryEmployeeDTOs() {
	   return employeeDao.queryEmployeeDTOs();
    }
    //public void

}
