package com.fsd.data.entity.Changepw;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangepwEntity {

    private String username;
    private String oldpassword;
    private PasswordsGroup passwordsgroup;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class PasswordsGroup {
        public String password;
        public String pwconfirm;
    }
}
