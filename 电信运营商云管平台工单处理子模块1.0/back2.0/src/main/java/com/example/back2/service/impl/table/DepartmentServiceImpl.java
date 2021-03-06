package com.example.back2.service.impl.table;

import com.example.back2.entity.table.Department;
import com.example.back2.dao.table.DepartmentDao;
import com.example.back2.service.table.DepartmentService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Department)表服务实现类
 *
 * @author makejava
 * @since 2022-01-11 15:19:28
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentDao departmentDao;

    /**
     * 通过ID查询单条数据
     *
     * @param depNum 主键
     * @return 实例对象
     */
    @Override
    public Department queryById(Integer depNum) {
        return this.departmentDao.queryById(depNum);
    }

    /**
     * 分页查询
     *
     * @param department 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Department> queryByPage(Department department, PageRequest pageRequest) {
        long total = this.departmentDao.count(department);
        return new PageImpl<>(this.departmentDao.queryAllByLimit(department, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    @Override
    public Department insert(Department department) {
        this.departmentDao.insert(department);
        return department;
    }

    /**
     * 修改数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    @Override
    public Department update(Department department) {
        this.departmentDao.update(department);
        return this.queryById(department.getDepNum());
    }

    /**
     * 通过主键删除数据
     *
     * @param depNum 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer depNum) {
        return this.departmentDao.deleteById(depNum) > 0;
    }

    @Override
    public List<Department> AllDep(){
        return this.departmentDao.AllDep();
    }

    @Override
    public List<Department> getDepBudget(){
        return this.departmentDao.getDepBudget();
    }

    @Override
    public int setDepBudget(Integer DepNum,double DepBudget){
        return this.departmentDao.setDepBudget(DepNum,DepBudget);
    }
}
