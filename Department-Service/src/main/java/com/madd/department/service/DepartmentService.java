package com.madd.department.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madd.department.entiry.Department;
import com.madd.department.repository.DepartmentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;

	public Department saveDepartment(Department department) {
		log.info("DepartmentService.saveDepartment start");
		return departmentRepository.save(department);

	}

	public Department findByDepartmentId(Long departmentId) {
		log.info("DepartmentService.findByDepartmentId start");
		return departmentRepository.findByDepartmentId(departmentId);
	}

}
