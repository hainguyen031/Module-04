package com.hainguyen.service;

import com.hainguyen.model.AppRole;
import com.hainguyen.repository.IAppRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppRoleService implements IAppRoleService {
    @Autowired
    private IAppRoleRepository iAppRoleRepository;

    @Override
    public AppRole findById(Long id) {
    return this.iAppRoleRepository.findById(id).orElse(null);
    }
}
