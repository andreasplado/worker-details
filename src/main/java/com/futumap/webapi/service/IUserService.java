package com.futumap.webapi.service;

import com.futumap.webapi.dao.entity.UserEntity;

import java.util.List;
import java.util.Optional;

public interface IUserService {

    List<UserEntity> findAll();
    Optional<UserEntity> findByUsernameAndPass(String username, String password);
    boolean existsByGoogleAccountId(String googleAccountId);
    UserEntity save(UserEntity userEntity);
    UserEntity update(UserEntity userEntity);
    void delete(Integer id);
    Optional<UserEntity> findById(Integer id);
    boolean exists(Integer id);
}
