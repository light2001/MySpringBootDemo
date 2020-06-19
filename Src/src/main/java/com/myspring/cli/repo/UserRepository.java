package com.myspring.cli.repo;

import com.myspring.cli.model.User;
import com.myspring.cli.pojo.RegisterUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>  {
    User findByUsername(String username);
}
