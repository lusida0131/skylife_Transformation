package com.skylife_Transformation.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
public class Skylife {
    private int bno;
    private String id;
    private String pw;
    private String name;
    private Date bday;
    private String email;
    private String phone;
}
