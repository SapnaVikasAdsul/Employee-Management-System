package com.example.empproject;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepos extends JpaRepository<EmpEntity, Long> {

}