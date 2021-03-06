package com.example.back2.controller;

import com.example.back2.entity.table.Department;
import com.example.back2.service.table.DepartmentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("depart")
public class DepartmentController {

    @Resource
    private DepartmentService departmentService;

    /**
     *
     * @param depNum 部门
     * @return 获取该部门预算
     */
    @GetMapping("getDepBudget")
    public Double getDepBudget(Integer depNum){
        Department department = departmentService.queryById(depNum);
        return department.getDepBudget();
    }

    @GetMapping("getDepInfo")
    private Department getDepInfo(Integer depNum){
        return departmentService.queryById(depNum);
    }

    @PutMapping("updateDep")
    private Department updateDep(String depName,Integer depNum){
        Department department = this.departmentService.queryById(depNum);
        department.setDepName(depName);
        return this.departmentService.update(department);
    }
}
