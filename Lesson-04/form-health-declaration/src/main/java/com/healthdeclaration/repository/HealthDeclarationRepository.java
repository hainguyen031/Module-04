package com.healthdeclaration.repository;

import com.healthdeclaration.model.HealthDeclaration;
import org.springframework.stereotype.Repository;

@Repository
public class HealthDeclarationRepository implements IHealthDeclarationRepository{
    private HealthDeclaration healthDeclaration = new HealthDeclaration();

    @Override
    public HealthDeclaration getHealthDeclaration() {
        return this.healthDeclaration;
    }

    @Override
    public void save(HealthDeclaration healthDeclaration) {
        this.healthDeclaration = healthDeclaration;
    }
}
