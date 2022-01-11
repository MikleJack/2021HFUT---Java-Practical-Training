package com.example.back2.service.impl.view;

import com.example.back2.entity.view.Leaderworkorderall;
import com.example.back2.dao.view.LeaderworkorderallDao;
import com.example.back2.service.view.LeaderworkorderallService;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Leaderworkorderall)表服务实现类
 *
 * @author makejava
 * @since 2022-01-11 11:28:34
 */
@Service("leaderworkorderallService")
public class LeaderworkorderallServiceImpl implements LeaderworkorderallService {
    @Resource
    private LeaderworkorderallDao leaderworkorderallDao;


    /**
     * 分页查询
     *
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Leaderworkorderall> queryByPage(Integer second_leader_num,Integer first_leader_num, PageRequest pageRequest) {
        long total = this.leaderworkorderallDao.count(second_leader_num,first_leader_num);
        return new PageImpl<>(this.leaderworkorderallDao.queryAllByLimit(second_leader_num,first_leader_num, pageRequest), pageRequest, total);
    }

}
