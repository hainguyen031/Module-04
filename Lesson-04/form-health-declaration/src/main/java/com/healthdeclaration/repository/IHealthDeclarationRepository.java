package com.healthdeclaration.repository;

import com.healthdeclaration.model.HealthDeclaration;

public interface IHealthDeclarationRepository {
    HealthDeclaration getHealthDeclaration();

    void save(HealthDeclaration healthDeclaration);

}
