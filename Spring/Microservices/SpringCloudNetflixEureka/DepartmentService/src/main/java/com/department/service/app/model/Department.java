package com.department.service.app.model;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author danfe
 */

@Entity
@Table(name = "departments")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;
}
