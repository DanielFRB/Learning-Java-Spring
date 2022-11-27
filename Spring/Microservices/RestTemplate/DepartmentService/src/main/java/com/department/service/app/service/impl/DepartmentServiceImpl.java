package com.department.service.app.service.impl;

import com.department.service.app.model.Department;
import com.department.service.app.repository.DepartmentRepository;
import com.department.service.app.service.DepartmentServiceInter;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author danfe
 */

@Service
@AllArgsConstructor
@Slf4j
public class DepartmentServiceImpl implements DepartmentServiceInter {
    private DepartmentRepository departmentRepository;

    @Override
    public Department saveDepartment(Department d) {
        return departmentRepository.save(d);
    }

    @Override
    public Department getDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId).get();
    }
}
