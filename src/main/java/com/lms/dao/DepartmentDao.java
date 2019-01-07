package com.lms.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDao extends JpaRepository<Department,Integer> {
    Department findAllByDepartmentId(Integer departmentId);
    Department findDepartmentByDepartmentId(Integer departmentId);

    void deleteDepartmentsByParentId(Integer parentId);

}
