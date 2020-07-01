package com.fsd.data.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDB {
    private String user_name;
    private String password;
    private String user_type;
    private String email;
    private String mobile_num;
    private String confirmed;
    private String veri_code;
}
