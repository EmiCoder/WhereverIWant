package com.example.wherever_i_want.mapper;

import com.example.wherever_i_want.domain.dto.UserDto;
import com.example.wherever_i_want.domain.loginRegisterStaff.User;
import com.example.wherever_i_want.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserMapper {


    public User mapToUser(UserDto userDto) {
        User user = new User();
        user.setId(userDto.getId());
        user.setNick(userDto.getNick());
        user.setFirstname(userDto.getFirstname());
        user.setLastname( userDto.getLastname());
        user.setAge(userDto.getAge());
        user.setEMail(userDto.getEMail());
        user.setPassword(userDto.getPassword());
        return user;
    }

    public UserDto mapToUserDto(User user) {
        return new UserDto(user.getId(),
                            user.getNick(),
                            user.getFirstname(),
                            user.getLastname(),
                            user.getAge(),
                            user.getEMail(),
                            user.getPassword());
    }

    public List<UserDto> getUserDtoList(List<User> list) {
        return list.stream().map(user -> new UserDto(user.getId(),
                                                        user.getNick(),
                                                        user.getFirstname(),
                                                        user.getLastname(),
                                                        user.getAge(),
                                                        user.getEMail(),
                                                        user.getPassword()))
                            .collect(Collectors.toList());
    }
}
