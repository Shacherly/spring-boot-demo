package org.lion.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String name;
    private String magic;


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", magic='" + magic + '\'' +
                '}';
    }
}
