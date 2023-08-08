package com.hainguyen.service;

import com.hainguyen.model.AppRole;
import com.hainguyen.model.AppUser;
import com.hainguyen.model.UserRole;
import com.hainguyen.repository.IUserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRoleService implements IUserRoleService {
    @Autowired
    private IUserRoleRepository iUserRoleRepository;

    @Override
    public void setUserRoleForNewUser(UserRole userRole, AppRole appRole, AppUser appUser) {
        userRole.setAppUser(appUser);
        userRole.setAppRole(appRole);
        this.iUserRoleRepository.save(userRole);
    }
}
