package com.example.back2.service.impl.view;

import com.example.back2.entity.view.AdminsearchorderTable;
import com.example.back2.dao.view.AdminsearchorderTableDao;
import com.example.back2.service.view.AdminsearchorderTableService;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.thymeleaf.spring5.util.FieldUtils;

import javax.annotation.Resource;
import java.util.concurrent.Future;

/**
 * (AdminsearchorderTable)表服务实现类
 *
 * @author makejava
 * @since 2022-01-10 19:56:49
 */
@Service("adminsearchorderTableService")
public class AdminsearchorderTableServiceImpl implements AdminsearchorderTableService {
    @Resource
    private AdminsearchorderTableDao adminsearchorderTableDao;

    /**
     * 分页查询
     *
     * @param adminsearchorderTable 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Async
    @Override
    public Future<Page<AdminsearchorderTable>> queryByPage(AdminsearchorderTable adminsearchorderTable, PageRequest pageRequest) {
        long total = this.adminsearchorderTableDao.count(adminsearchorderTable);
        return new AsyncResult<>(new PageImpl<>(this.adminsearchorderTableDao.queryAllByLimit(adminsearchorderTable, pageRequest), pageRequest, total));
    }

    /**
     * 新增数据
     *
     * @param adminsearchorderTable 实例对象
     * @return 实例对象
     */
    @Override
    public AdminsearchorderTable insert(AdminsearchorderTable adminsearchorderTable) {
        this.adminsearchorderTableDao.insert(adminsearchorderTable);
        return adminsearchorderTable;
    }


    /**
     * 无条件的分页查询
     *
     * @return 查询结果
     */
    @Async
    @Override
    public Future<Page<AdminsearchorderTable>> normalQueryByPage(PageRequest pageRequest) {
        long total = this.adminsearchorderTableDao.normalCount();
        return new AsyncResult<>(new PageImpl<>(this.adminsearchorderTableDao.normalQueryAllByLimit(pageRequest), pageRequest, total));
    }

    /**
     * 带条件的分页查询：只传参数
     *
     * @param workOrderType 工单类型
     * @param workerName 工人姓名
     * @return 查询结果
     */
    public Page<AdminsearchorderTable> parameterQueryByPage(String workOrderType, String workerName,PageRequest pageRequest) {
        long total = this.adminsearchorderTableDao.paramCount(workOrderType, workerName);
        return new PageImpl<>(this.adminsearchorderTableDao.parameterQueryByPage(workOrderType,workerName,pageRequest), pageRequest, total);
    }
}
