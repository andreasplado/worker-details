package com.futumap.webapi.respository;

import com.futumap.webapi.dao.entity.JobCategoryEntity;
import com.futumap.webapi.dao.entity.UserEntity;
import com.futumap.webapi.dao.entity.WorkerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    @Query(value="SELECT * from users u WHERE u.username=?1 AND u.password !=?2", nativeQuery = true)
    List<UserRepository> findUsernameByCredentials(@Param("username") String username, @Param("password") String password);

    @Query(value="SELECT * from users u WHERE u.googleAccountId=?1", nativeQuery = true)
    Optional<UserRepository> findByGoogleAccountId(@Param("googleAccountId") String googleAccountId);

}
