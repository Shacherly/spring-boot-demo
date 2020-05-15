package com.duyi.service;

import com.duyi.bean.Guest;
import com.duyi.mapper.GuestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
// 设置整个类中所有缓存的名字，具体方法中就不用写cacheNames了
@CacheConfig(cacheNames = "guests")
public class GuestServiceImpl implements GuestService {

    @Autowired
    private GuestMapper guestMapper;


    @Override
    public List<Guest> listGuests() {
        return guestMapper.listGuests();
    }

    // 打开缓存之后第一次从数据库查询然后放入缓存
    // 第二次就不进方法了直接从缓存中取值

    /**
     *
     * @param id
     * @return
     * condition缓存条件，满足条件则放入缓存
     * unless是相反的条件就放入缓存
     */
    @Cacheable(/*cacheNames = "guests", */key = "#id"
            /*condition = "#id > 1",*/)
    @Override
    public Guest getGuest(int id) {
        System.out.println("查询第" + id + "位嘉宾，说明缓存没了才找数据库！！！");
        return guestMapper.getGuest(id);
    }

    /**
     * 设置key的值和Cacheable保持一致，这样Cacheable在查询的时候就能放入的缓存了
     * 如何保持一致？
     * 1、放入参数的ID
     * 2、拿到结果的ID
     * @param guest
     * @return
     */
    @CachePut(/*cacheNames = "guests", */key = "#guest.id")
    @Override
    public Guest update(Guest guest) {
        System.out.println("更新第" + guest.getId() + "位嘉宾");
        int update = guestMapper.update(guest);
        Guest newGuest = new Guest();
        if (update > 0) {
            newGuest = guestMapper.getGuest(guest.getId());
            return newGuest;
        }
        return guest;
    }

    /**
     * 驱逐的意思，删除缓存
     * @param id
     * @return
     * 仍然从cacheNames为guests的缓存中进行操作
     * beforeInvocation默认为false表示先执行方法再清除缓存，
     * 如果删除数据库的方法执行了，但后面马上报错了，导致整个方法没执行完成，从而导致缓存没被清除掉可不行
     * 可以将beforeInvocation设置为true，这样缓存会先被清除掉，这样才对
     */
    @CacheEvict(cacheNames = "guests", key = "#id", allEntries = true, beforeInvocation = false)
    @Override
    public int delete(int id) {
        if (id == 0) {
            System.out.println("删除所有嘉宾");
            return guestMapper.deleteAll();
        }
        System.out.println("删除第" + id + "位嘉宾");
        return guestMapper.delete(id);
    }

}
