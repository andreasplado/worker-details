package com.futumap.webapi.service;

import com.futumap.webapi.dao.entity.UserEntity;
import com.futumap.webapi.respository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository repository;
    @Override
    public List<UserEntity> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<UserEntity> findByUsernameAndPass(String username, String password) {
        repository.findUsernameByCredentials(username, password);
        return Optional.empty();
    }

    @Override
    public boolean existsByGoogleAccountId(String googleAccountId) {
        if(repository.findByGoogleAccountId(googleAccountId).isPresent()){
            return true;
        }
        return false;
    }

    @Override
    public Optional<UserEntity> findByGoogleAccountId(String googleAccountId) {
        return repository.findByGoogleAccountId(googleAccountId);
    }

    @Override
    public UserEntity save(UserEntity userEntity) {
        return repository.save(userEntity);
    }

    @Override
    public UserEntity update(UserEntity userEntity) {
        if(repository.existsById(userEntity.getId())){
            repository.save(userEntity);
        }
        return userEntity;
    }

    @Override
    public void delete(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<UserEntity> findById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public boolean exists(Integer id) {
        return repository.existsById(id);
    }
}
