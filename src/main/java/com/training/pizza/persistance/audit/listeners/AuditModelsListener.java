package com.training.pizza.persistance.audit.listeners;

import jakarta.persistence.PostLoad;
import jakarta.persistence.PostPersist;
import jakarta.persistence.PostUpdate;
import jakarta.persistence.PreRemove;

public class AuditModelsListener {
    // These methods will work only with query methods, if we will use annotation @Query this audit won't work

    @PostPersist
    @PostUpdate
    public void onPostPersist(Object model) {
        System.out.println("==== POST Persist / Update ====");
        System.out.println("Model created/updated: " + model.getClass());
    }

    @PreRemove
    public void onPreRemove(Object model) {
        System.out.println("==== Pre Remove ====");
        System.out.println("Model will be delete: " + model.getClass());
    }

    // This annotation work with all queries except native queries
    @PostLoad
    public void onLoad(Object model){
        System.out.println("==== Post Load ====");
        System.out.println("Model consulted: " + model.getClass());
    }

}
