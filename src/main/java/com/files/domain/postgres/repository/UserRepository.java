package com.files.domain.postgres.repository;

import com.files.domain.postgres.entity.UserData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface UserRepository extends JpaRepository<UserData, Integer> {

    @Query("SELECT ud " +
            "FROM UserData ud")
    List<UserData> getDataForFile();

}
