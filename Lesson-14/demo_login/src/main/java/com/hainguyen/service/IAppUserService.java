package com.hainguyen.service;

import com.hainguyen.dto.AppUserDto;
import com.hainguyen.model.AppUser;
import org.springframework.validation.BindingResult;

public interface IAppUserService {
    void registerNewUserAccount(AppUser appUser);
    void userNameExists(AppUserDto appUserDto, BindingResult bindingResult);
}
