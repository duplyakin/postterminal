package com.example.kanzeparovrr.postterminalcardapplicationmir.hl;


import com.example.kanzeparovrr.postterminalcardapplicationmir.hl.storage.AbstractHlConstEntityRepository;
import com.example.kanzeparovrr.postterminalcardapplicationmir.hl.storage.HLEntity;

import entities.Entity;

public class EntityRepository extends AbstractHlConstEntityRepository<Entity> {
    public EntityRepository(HLProvider hlProvider, Class<Entity> entityClass) {
        super(hlProvider, entityClass);
    }

    @Override
    public Entity get(Long id) {
        return null;
    }
}
