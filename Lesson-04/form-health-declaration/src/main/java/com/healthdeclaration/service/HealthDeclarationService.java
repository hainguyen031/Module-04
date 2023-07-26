package com.healthdeclaration.service;

import com.healthdeclaration.model.HealthDeclaration;
import com.healthdeclaration.repository.IHealthDeclarationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HealthDeclarationService implements IHealthDeclarationService{
    @Autowired
    private IHealthDeclarationRepository iHealthDeclarationRepository;

    @Override
    public HealthDeclaration getHealthDeclaration() {
        return this.iHealthDeclarationRepository.getHealthDeclaration();
    }

    @Override
    public void save(HealthDeclaration healthDeclaration) {
        this.iHealthDeclarationRepository.save(healthDeclaration);
    }
}
