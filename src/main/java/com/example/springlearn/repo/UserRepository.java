package com.example.springlearn.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springlearn.entity.MyUser;

@Repository
public interface UserRepository extends JpaRepository<MyUser, Long>{

	public MyUser findByUsername(String username);
}
