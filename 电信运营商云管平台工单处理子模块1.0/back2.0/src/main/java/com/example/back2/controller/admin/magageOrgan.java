package com.example.back2.controller.admin;

import com.example.back2.entity.table.DepRelate;
import com.example.back2.entity.table.Department;
import com.example.back2.entity.view.Adminorganmanage;
import com.example.back2.service.table.DepRelateService;
import com.example.back2.service.table.DepartmentService;
import com.example.back2.service.view.AdminorganmanageService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("Organ")
public class magageOrgan {

    @Resource
    private DepartmentService departmentService;
    @Resource
    private AdminorganmanageService adminorganmanageService;

    @GetMapping("getTree")
    public List<Department> getTree(){
        List<Department> departments = new ArrayList<>();
        departments.add(get(departmentService.queryById(1)));
        return departments;
    }

    private Department get(Department department){
        while (true){
            List<Adminorganmanage> lowDep = this.adminorganmanageService.queryById(department.getDepNum());

            List<Department> child = new ArrayList<>();
            for(Adminorganmanage i:lowDep){
                child.add(get(this.departmentService.queryById(i.getLowNum())));
            }
            department.setChildren(child);
            return department;
        }
    }

    @PostMapping("insert")
    public Department insert(String depName,Integer depLevel){
        Department department = new Department();
        department.setDepName(depName);
        department.setDepLevel(depLevel);
        department.setDepBudget(0.0);
        return this.departmentService.insert(department);
    }

    @Resource
    private DepRelateService depRelateService;

    /**
     * ????????????
     *
     * @param depRelate ??????
     * @return ????????????
     */
    @PostMapping("addRelate")
    public ResponseEntity<DepRelate> add(Integer supe,Integer low) {
        DepRelate depRelate = new DepRelate();
        depRelate.setDepNumSuperior(supe);
        depRelate.setDepNumJunior(low);
        return ResponseEntity.ok(this.depRelateService.insert(depRelate));
    }
}
