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

    @Select("SELECT * FROM guest WHERE ID = #{id}")
    Guest getGuest(int id);

    @Update("UPDATE guest SET NAME = #{name}, ROLE = #{role} WHERE ID = #{id}")
    int update(Guest guest);

    @Delete("DELETE FROM GUEST WHERE ID = #{id}")
    int delete(int id);

    @Delete("DELETE FROM GUEST")
    int deleteAll();

}
