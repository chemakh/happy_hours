package com.ch.happyhours.service.utils;


import com.ch.happyhours.service.domain.Authority;
import com.ch.happyhours.service.domain.User;
import com.ch.happyhours.service.web.dto.UserDto;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.stream.Collectors;


@Component
public class BusinessAndDomainConverter {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Inject
    private ModelMapper modelMapper;


    @PostConstruct
    public void init() {
    }




    public UserDto fromUserToBusiness(User user) {
        UserDto userDto = modelMapper.map(user, UserDto.class);
        userDto.setAuthorities(user.getAuthorities().stream().map(Authority::getName)
                .collect(Collectors.toList()));
        return userDto;
    }

    public User fromBusinessToUser(UserDto userDto) {
        return modelMapper.map(userDto, User.class);

    }
}
