package com.madd.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.madd.user.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
