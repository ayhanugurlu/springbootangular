package com.au.example.repository;

import com.au.example.repository.entity.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Ayhan Ugurlu - (ayhan.ugurlu@odc.com.tr) on 13.09.2017.
 */
public interface UserRepository extends CrudRepository<User,Long> {

        User findByUserName(String username);
}
