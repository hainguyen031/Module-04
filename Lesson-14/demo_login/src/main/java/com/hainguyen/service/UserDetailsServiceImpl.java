package com.hainguyen.service;

import com.hainguyen.dto.AppUserDto;
import com.hainguyen.model.AppUser;
import com.hainguyen.model.UserRole;
import com.hainguyen.repository.IAppUserReopsitory;
import com.hainguyen.repository.IUserRoleRepository;
import com.hainguyen.util.EncrytedPasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService,IAppUserService {

    @Autowired
    private IAppUserReopsitory iAppUserReopsitory;
    @Autowired
    private IUserRoleRepository iUserRoleRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        AppUser appUser = this.iAppUserReopsitory.findByUserName(userName);
//        AppUser appUser = this.appUserDAO.findUserAccount(userName);

        if (appUser == null) {
            System.out.println("User not found! " + userName);
            throw new UsernameNotFoundException("User " + userName + " was not found in the database");
        }

        System.out.println("Found User: " + appUser);

        // [ROLE_USER, ROLE_ADMIN,..]
        List<UserRole> userRoles = this.iUserRoleRepository.findByAppUser(appUser);

        List<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
        if (userRoles != null) {
            for (UserRole userRole : userRoles) {
                // ROLE_USER, ROLE_ADMIN,..
                GrantedAuthority authority = new SimpleGrantedAuthority(userRole.getAppRole().getRoleName());
                grantList.add(authority);
            }
        }

        UserDetails userDetails = (UserDetails) new User(appUser.getUserName(), //
                appUser.getEncrytedPassword(), grantList);

        return userDetails;
    }

    @Override
    public void registerNewUserAccount(AppUser appUser) {
        String encrytePassword =EncrytedPasswordUtils.encrytePassword(appUser.getEncrytedPassword());
        appUser.setEncrytedPassword(encrytePassword);
        appUser.setEnabled(true);
        this.iAppUserReopsitory.save(appUser);
    }

    @Override
    public void userNameExists(AppUserDto appUserDto, BindingResult bindingResult) {
        if (!"".equals(appUserDto.getUserName())){
            if ( iAppUserReopsitory.findByUserName(appUserDto.getUserName()) != null){
                bindingResult.rejectValue("userName", "userName.exists");
            }
        }
    }
}