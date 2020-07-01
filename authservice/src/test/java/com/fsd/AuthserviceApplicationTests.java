package com.fsd;

import com.alibaba.fastjson.JSON;
import com.fsd.data.entity.Login.LoginEntity;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = AuthserviceApplication.class)
public class AuthserviceApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;
    private MockMvc mockMvc;

    @Before
    public void setUp(){
        mockMvc= MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    @DisplayName("Test Login Controller")
    public void test() throws Exception {

        LoginEntity user = new LoginEntity();
        user.setUserName("dlyhua");
        user.setPassWord("111111");
        System.out.println(user.toString());
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.post("/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JSON.toJSONString(user)))
                .andReturn();

        for(String str : mvcResult.getResponse().getHeaderNames()) {
            System.out.println(str + " : " + mvcResult.getResponse().getHeader(str));
        }

        System.out.println(mvcResult.getResponse().getContentAsString());
    }
}
