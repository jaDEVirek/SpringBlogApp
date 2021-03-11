package com.devirek.blogapp.repository;

import com.devirek.blogapp.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepositoryInterface extends JpaRepository<UserModel, Long> {

    Optional<UserModel> findByUserName(String userName);
}
