package com.department.service.app.service;

import com.department.service.app.model.Department;

/**
 * @author danfe
 */

public interface DepartmentServiceInter {
    Department saveDepartment(Department d);

    Department getDepartmentById(Long departmentId);
}
