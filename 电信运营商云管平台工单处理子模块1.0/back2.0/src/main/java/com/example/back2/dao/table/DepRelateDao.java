package com.example.back2.dao.table;

import com.example.back2.entity.table.DepRelate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (DepRelate)表数据库访问层
 *
 * @author makejava
 * @since 2022-01-18 10:31:34
 */
@Mapper
public interface DepRelateDao {

    /**
     * 通过ID查询单条数据
     *
     * @param depNumSuperior 主键
     * @return 实例对象
     */
    DepRelate queryById(Integer depNumSuperior);

    /**
     * 查询指定行数据
     *
     * @param depRelate 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<DepRelate> queryAllByLimit(DepRelate depRelate, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param depRelate 查询条件
     * @return 总行数
     */
    long count(DepRelate depRelate);

    /**
     * 新增数据
     *
     * @param depRelate 实例对象
     * @return 影响行数
     */
    int insert(DepRelate depRelate);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<DepRelate> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<DepRelate> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<DepRelate> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<DepRelate> entities);

    /**
     * 修改数据
     *
     * @param depRelate 实例对象
     * @return 影响行数
     */
    int update(DepRelate depRelate);

    /**
     * 通过主键删除数据
     *
     * @param depNumSuperior 主键
     * @return 影响行数
     */
    int deleteById(Integer depNumSuperior);

}

