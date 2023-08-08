package com.hainguyen.service;

import com.hainguyen.model.AppRole;
import com.hainguyen.model.AppUser;
import com.hainguyen.model.UserRole;

public interface IUserRoleService {
    void setUserRoleForNewUser(UserRole userRole, AppRole appRole, AppUser appUser);
}
