package com.example.springlearn.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.springlearn.entity.Ncdex;

@Repository
public interface NcdexRepository extends JpaRepository<Ncdex, Long>{

}
