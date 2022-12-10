package com.department.service.app.repository;

import com.department.service.app.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author danfe
 */

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
