package com.madd.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.madd.user.VO.Department;
import com.madd.user.VO.ResponseTemplateVO;
import com.madd.user.entity.User;
import com.madd.user.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;
	

	public User saveUser(User user) {
		log.info("UserService.ˇstart");
		return userRepository.save(user);
	}
	
	
	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		log.info("UserService.ˇgetUserWithDepartment");
		ResponseTemplateVO vo = new ResponseTemplateVO();
		User user =userRepository.getById(userId);
		
		vo.setUser(user);
		log.info(user.getDepartmentId() + " ########");
		//Department department = restTemplate.getForObject("http://localhost:8001/departments/"+user.getDepartmentId(), Department.class);
		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(), Department.class);
		
		// Call the other service 
		vo.setDepartment(department);
		return vo;
	}

}
