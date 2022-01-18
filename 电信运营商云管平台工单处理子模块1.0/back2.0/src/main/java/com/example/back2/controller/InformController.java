package com.example.back2.controller;

import com.example.back2.entity.table.Inform;
import com.example.back2.service.table.InformService;
import com.example.back2.service.table.InformService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * (Inform)表控制层
 *
 * @author makejava
 * @since 2022-01-18 16:02:49
 */
@RestController
@RequestMapping("inform")
public class InformController {
    /**
     * 服务对象
     */
    @Resource
    private InformService informService;

    /**
     * 分页查询
     *
     * @param inform 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Inform>> queryByPage(Inform inform, PageRequest pageRequest) {
        return ResponseEntity.ok(this.informService.queryByPage(inform, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Inform> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.informService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param inform 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Inform> add(Inform inform) {
        return ResponseEntity.ok(this.informService.insert(inform));
    }

    /**
     * 编辑数据
     *
     * @param inform 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Inform> edit(Inform inform) {
        return ResponseEntity.ok(this.informService.update(inform));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.informService.deleteById(id));
    }

    /**
     * 测试
     */
    @PostMapping("insertInform")
    public ResponseEntity<Boolean> insertInform(String workOrderNum, Integer workNum) {
        this.informService.firstLeaderInsertInform(workOrderNum,workNum, "挂起工单");
        return ResponseEntity.ok(true);
    }

}

