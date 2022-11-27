package com.user.service.app.repository;

import com.user.service.app.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author danfe
 */

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
