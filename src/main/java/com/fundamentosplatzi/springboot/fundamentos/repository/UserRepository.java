package com.fundamentosplatzi.springboot.fundamentos.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fundamentosplatzi.springboot.fundamentos.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long>{
    
    @Query("Select u from Users u WHERE u.email=?1")
    Optional<Users> findByUserEmail(String email);

    @Query("Select u from Users u where u.name like ?1%")
    List<Users> findAndSort(String name, Sort sort);
}
