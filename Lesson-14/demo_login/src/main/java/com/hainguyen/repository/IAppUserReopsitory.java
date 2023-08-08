package com.hainguyen.repository;

import com.hainguyen.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppUserReopsitory extends JpaRepository<AppUser, Long> {
    AppUser findByUserName(String uerName);
}
