package com.botwy.erp.repository;

import com.botwy.erp.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    List<User> findByName (String name);
    void deleteByName (String name);
}
