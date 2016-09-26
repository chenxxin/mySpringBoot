package com.xin.repository;

import com.xin.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by CHENXINXIN on 2016/8/2.
 */
public interface UserRepository extends JpaRepository<User, Long> {

}
