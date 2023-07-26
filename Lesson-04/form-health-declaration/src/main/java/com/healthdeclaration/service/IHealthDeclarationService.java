package com.healthdeclaration.service;

import com.healthdeclaration.model.HealthDeclaration;

public interface IHealthDeclarationService {
    HealthDeclaration getHealthDeclaration();

    void save(HealthDeclaration healthDeclaration);
}
