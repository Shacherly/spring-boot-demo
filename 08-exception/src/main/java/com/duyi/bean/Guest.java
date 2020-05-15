package com.duyi.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data@AllArgsConstructor@NoArgsConstructor
public class Guest {
    @NotBlank(message = "{guest.name.notblank}")
    private String name;
    @NotBlank(message = "别放空自己！")
    private String role;
}
