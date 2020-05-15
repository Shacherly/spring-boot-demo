package com.duyi.controller;

import com.duyi.bean.Guest;
import com.duyi.service.GuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class GuestController {

    @Autowired
    private GuestService guestService;

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

    @GetMapping("/guest/{id}")
    public Guest getGuest(@PathVariable("id") int id) {
        return guestService.getGuest(id);
    }

    @GetMapping("/guests")
    public List<Guest> listGuest() {
        return guestService.listGuests();
    }

    @PutMapping("/guest")
    public Guest update(Guest guest) {
        return guestService.update(guest);
    }

    @DeleteMapping("/guest/{id}")
    public String delete(@PathVariable("id") int id) {
        int delete = guestService.delete(id);
        String msg = "删除失败";
        if (delete > 0) {
            msg = "删除成功";
        }
        return msg;
    }
}
