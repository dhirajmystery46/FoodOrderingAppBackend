package com.upgrad.FoodOrderingApp.service.dao;

import com.upgrad.FoodOrderingApp.service.entity.RestaurantEntity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RestaurantDao  {

    @PersistenceContext
    private EntityManager entityManager;

    //Return restaurant list sorted based on customer rating
    public List<RestaurantEntity> getrestaurantsByRating() {
        try {
            return entityManager.createNamedQuery("allRestaurantsByRating", RestaurantEntity.class).getResultList();
        } catch(NoResultException nre) {
            return null;
        }
    }

    /*public List<RestaurantEntity> getRestaurantsByName(String restaurantName) {
        try {
            return entityManager.createNamedQuery("findByName", RestaurantEntity.class).setParameter("restaurantName","%" + restaurantName.toLowerCase() + "%" ).getResultList();
        } catch(NoResultException nre) {
            return null;
        }
    }*/

    /*public List<RestaurantCategoryEntity> getRestaurantByCategoryId(final Long categoryID) {
        try {
            return entityManager.createNamedQuery("restaurantsByCategoryId", RestaurantCategoryEntity.class).setParameter("id",categoryID).getResultList();
        } catch(NoResultException nre) {
            return null;
        }
    }*/

    //Return restaurant details by restaurant UUID
    public RestaurantEntity getRestaurantByUUID(String restaurantUUID) {
        try {
            return entityManager.createNamedQuery("restaurantByUUID", RestaurantEntity.class).setParameter("uuid",restaurantUUID.toLowerCase()).getSingleResult();
        } catch(NoResultException nre) {
            return null;
        }
    }

    //Update modifying restaurant details in DB
    public RestaurantEntity updateRestaurantEntity(RestaurantEntity updatedRestaurantEntity) {
        return  entityManager.merge(updatedRestaurantEntity);
    }

}
