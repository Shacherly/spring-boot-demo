package com.duyi.mapper;

import com.duyi.bean.Guest;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GuestMapper {

    @Select("SELECT * FROM guest")
    List<Guest> listGuests();

    @Select("select * from guest where id = #{id}")
    Guest getGuest(int id);

    @Update("update guest set name = #{name}, role = #{role} where id = #{id}")
    int update(Guest guest);

    @Delete("delete from guest where id = #{id}")
    int delete(int id);

    @Delete("delete from guest")
    int deleteAll();

}
