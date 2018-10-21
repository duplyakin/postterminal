package com.example.kanzeparovrr.postterminalcardapplicationmir.hl.storage;


import org.hyperledger.fabric.sdk.User;

public interface HLConstEntityRepository<T extends HLEntity> {
    T getFromHl(String hlEntityId, User user) /*throws EntityNotFoundException*/;
    T get(Long id);
    T addToHl(T entity, User user);
}
