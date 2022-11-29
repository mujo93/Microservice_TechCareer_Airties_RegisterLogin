package com.hamitmizrak.business.services.impl;

import com.hamitmizrak.bean.ModelMapperBean;
import com.hamitmizrak.bean.PasswordEncoderBean;
import com.hamitmizrak.business.dto.UserDto;
import com.hamitmizrak.business.dto.UsernameDto;
import com.hamitmizrak.business.services.IUserServices;
import com.hamitmizrak.data.entity.UserEntity;
import com.hamitmizrak.data.repository.IUserRepository;
import com.hamitmizrak.exception.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//lombok
@RequiredArgsConstructor
@Log4j2

@Service
@Transactional
//asıl işi yapan yer
public class UserServicesImpl implements IUserServices {

    //injection
    private final IUserRepository repository;
    private final ModelMapperBean modelMapperBean;
    private final PasswordEncoderBean passwordEncoderBean;

    //Model Mapper
    @Override
    public UserDto EntityToDto(UserEntity userEntity) {
        return modelMapperBean.modelMapperMethod().map(userEntity,UserDto.class);
    }

    @Override
    public UserEntity DtoToEntity(UserDto userDto) {
        return modelMapperBean.modelMapperMethod().map(userDto,UserEntity.class);
    }

    public UsernameDto EntityToUsernameAndIdDto(UserEntity userEntity) {
        return modelMapperBean.modelMapperMethod().map(userEntity, UsernameDto.class);
    }


    //CREATE
    @Override
    @PostMapping("/save/product")
    public UserDto createUser(UserDto userDto) {
        UserDto newUserDto=new UserDto();
        try {
            userDto.setPassword(passwordEncoderBean.passwordEncoderMethod().encode(userDto.getPassword()));
            UserEntity userEntity=DtoToEntity(userDto);
            UserEntity savedUser=repository.save(userEntity);
            newUserDto=EntityToDto(savedUser);
        }catch (NullPointerException e){
            e.printStackTrace();
            System.out.println("User details which are name,username and password must be entered.");
        }
        return newUserDto;
    }

    //LIST
    @Override
    @GetMapping("/list/product")
    public List<UserDto> getAllUser() {
       Iterable<UserEntity>  userEntityList= repository.findAll();
       //dto List
        List<UserDto> dtoList=new ArrayList<>();
        for (UserEntity temp:  userEntityList) {
            UserDto userDto=EntityToDto(temp);
            dtoList.add(userDto);
        }
        return dtoList;
    }

    @Override
    public UsernameDto getUserById(long id) {
        UserEntity userEntity= repository.findById(id).get();
        if(userEntity==null)
            throw new ResourceNotFoundException("There is no such user.");

        UsernameDto user=EntityToUsernameAndIdDto(userEntity);
        return user;
    }

    //FIND
    @Override
    public Optional<UserEntity> findUsername(String username) {
        return repository.findByUsername(username);
    }
}
