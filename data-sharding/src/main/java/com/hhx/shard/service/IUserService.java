package com.hhx.shard.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hhx.shard.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author hhx
 * @since 2019-04-08
 */
public interface IUserService extends IService<User> {

    /**
     * 获取全部
     * @return
     */
    List<User> getAll();

    /**
     * 分页
     * @param number
     * @param size
     * @return
     */
    IPage<User> getPage(int number, int size);
}
