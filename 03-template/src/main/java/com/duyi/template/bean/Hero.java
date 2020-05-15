package com.duyi.template.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hero {
    private String name;
    private String camp;
    private String equipment;
}
