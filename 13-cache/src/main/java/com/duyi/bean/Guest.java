package com.duyi.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data@AllArgsConstructor@NoArgsConstructor
public class Guest {
    private Integer id;
    @NotBlank(message = "{guest.name.notblank}")
    private String name;
    @NotBlank(message = "别放空自己！")
    private String role;

    public Guest(String name, String role) {
        this.name = name;
        this.role = role;
    }
}
