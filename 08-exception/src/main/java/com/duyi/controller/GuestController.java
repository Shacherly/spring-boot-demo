package com.duyi.controller;

import com.duyi.bean.Guest;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GuestController {

    /**
     * restful 设计
     * @param guest
     * 此为普通模式
     */
    @PostMapping("/guest")
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
}
