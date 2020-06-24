package com.devirek.blogapp.repository;

import com.devirek.blogapp.model.PostModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPostRepositoryInterface extends JpaRepository<PostModel, Long> {
}
