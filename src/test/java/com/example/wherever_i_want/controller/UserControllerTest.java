package com.example.wherever_i_want.controller;

import com.example.wherever_i_want.domain.Request;
import com.example.wherever_i_want.domain.dto.RequestDto;
import com.example.wherever_i_want.domain.dto.UserDto;
import com.example.wherever_i_want.domain.loginRegisterStaff.User;
import com.example.wherever_i_want.mapper.UserMapper;
import com.example.wherever_i_want.repository.RegisterRepository;
import com.example.wherever_i_want.service.RegisterService;
import com.example.wherever_i_want.service.UserService;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyList;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;




@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService userService;
    @MockBean
    private UserMapper userMapper;
    @MockBean
    private RegisterRepository registerRepository;
    @MockBean
    private RegisterService registerService;


    @Test
    public void shouldCreateNewUser() throws Exception {
        User user = new User();
        UserDto userDto = new UserDto(1,
                "Nick",
                "Name",
                "Name",
                11,
                "Updated",
                "Updated");

        when(userMapper.mapToUserDto(any(User.class))).thenReturn(userDto);
        when(userMapper.mapToUserDto(any())).thenReturn(userDto);
        when(userService.save(user)).thenReturn(user);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(user);

        mockMvc.perform(post("/whereverIWant/user/createUser")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(jsonPath("$.id", is(1)))
                .andExpect(jsonPath("$.nick", is("Nick")))
                .andExpect(jsonPath("$.firstname", is("Name")))
                .andExpect(jsonPath("$.lastname", is("Name")))
                .andExpect(jsonPath("$.age", is(11)))
                .andExpect(jsonPath("$.email", is("Updated")))
                .andExpect(jsonPath("$.password", is("Updated")));
    }

    @Test
    public void shouldDeleteUser() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders
                .delete("/whereverIWant/user/deleteUserById/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldUpdateUser() throws Exception {

        User user = new User();
                    user.setId(1);
                    user.setNick("Nick1");
                    user.setFirstname("Firstname1");
                    user.setLastname("Lastname1");
                    user.setAge(10);
                    user.setEMail("eMailAddress1");
                    user.setPassword("password1");
        UserDto userDto = new UserDto(1,
                "Updated",
                "Updated",
                "Updated",
                11,
                "Updated",
                "Updated");

        when(userService.findById(user.getId())).thenReturn(user);
        when(userMapper.mapToUserDto(any(User.class))).thenReturn(userDto);

        Gson gson = new Gson();
        String jsonContent = gson.toJson(userDto);

        mockMvc.perform(put("/whereverIWant/user/updateUser")
                .contentType(MediaType.APPLICATION_JSON)
                .characterEncoding("UTF-8")
                .content(jsonContent))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetUser() throws Exception {
        User user = new User();
                    user.setId(1);
                    user.setNick("Nick1");
                    user.setFirstname("Firstname1");
                    user.setLastname("Lastname1");
                    user.setAge(10);
                    user.setEMail("eMailAddress1");
                    user.setPassword("password1");
        UserDto userDto = new UserDto(1,
                                        "Nick1",
                                        "Firstname1",
                                        "Lastname1",
                                        10,
                                        "eMailAddress1",
                                        "password1");
        List<User> userList = new ArrayList<>();
        List<UserDto> userDtoList = new ArrayList<>();
        userList.add(user);
        userDtoList.add(userDto);

        when(userService.findById(user.getId())).thenReturn(user);
        when(userMapper.mapToUserDto(any(User.class))).thenReturn(userDto);
        when(userService.getAllUsers()).thenReturn(userList);
        when(userMapper.getUserDtoList(anyList())).thenReturn(userDtoList);

        mockMvc.perform(get("/whereverIWant/user/getUser/1")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldGetAllUsers() throws Exception {
        UserDto userDto1 = new UserDto(1,
                                        "Nick1",
                                        "Firstname1",
                                        "Lastname1",
                                        10,
                                        "eMailAddress1",
                                        "password1");
        UserDto userDto2 = new UserDto(2,
                                        "Nick2",
                                        "Firstname2",
                                        "Lastname2",
                                        10,
                                        "eMailAddress2",
                                        "password2");
        List<UserDto> usersDtoList = new ArrayList<>();
        usersDtoList.add(userDto1);
        usersDtoList.add(userDto2);

        when(userMapper.getUserDtoList(anyList())).thenReturn(usersDtoList);

        mockMvc.perform(get("/whereverIWant/user/getAllUsers")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].nick", is("Nick1")))
                .andExpect(jsonPath("$[0].firstname", is("Firstname1")))
                .andExpect(jsonPath("$[0].lastname", is("Lastname1")))
                .andExpect(jsonPath("$[0].age", is(10)))
                .andExpect(jsonPath("$[0].email", is("eMailAddress1")))
                .andExpect(jsonPath("$[0].password", is("password1")))
                .andExpect(jsonPath("$[1].nick", is("Nick2")))
                .andExpect(jsonPath("$[1].firstname", is("Firstname2")))
                .andExpect(jsonPath("$[1].lastname", is("Lastname2")))
                .andExpect(jsonPath("$[1].age", is(10)))
                .andExpect(jsonPath("$[1].email", is("eMailAddress2")))
                .andExpect(jsonPath("$[1].password", is("password2")));
    }


    @Test
    public void shouldFetchEmptyUsersList() throws Exception {

        List<User> usersList = new ArrayList<>();
        List<UserDto> usersDtoList = new ArrayList<>();

        when(userService.getAllUsers()).thenReturn(usersList);
        when(userMapper.getUserDtoList(anyList())).thenReturn(usersDtoList);
        mockMvc.perform(get("/whereverIWant/user/getAllUsers").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(0)));
    }

    @Test
    public void contextLoads() {
    }
}
