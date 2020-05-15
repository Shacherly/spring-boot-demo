package com.duyi.controller;

import com.duyi.bean.Guest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Api(tags = "访客接口", description = "这是应用接口")
public class GuestController {

    /**
     * restful 设计
     * @param guest
     * 此为普通模式
     */
    @PostMapping("/guest")
    @ApiOperation("新增")
    public String add(@Valid Guest guest, BindingResult result) {
        StringBuffer buffer = new StringBuffer();
        if (result.getErrorCount() > 0) {
            List<FieldError> list = result.getFieldErrors();
            list.forEach(x -> {
                buffer.append(x.getField()).append("\t")
                        .append(x.getDefaultMessage()).append("\n");
            });
        }
        return buffer.toString();
    }

    // 我
    @GetMapping("/guest/{name}")
    @ApiOperation("查询")
    public Guest get(@PathVariable("name") String name) {
        System.out.println(name);
        return new Guest("幻影", "天辉");
    }

    @DeleteMapping("/guest/{name}")
    @ApiOperation("删除")
    public String delete(@PathVariable("name") String name) {
        System.out.println(name);
        return "删除成功";
    }

    @PutMapping("/guest")
    @ApiOperation("更新")
    public Guest update(Guest guest) {
        System.out.println(guest);
        return guest;
    }
}
