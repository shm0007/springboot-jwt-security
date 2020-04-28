package com.ehsan.jwtScaffolder.service;

import com.ehsan.jwtScaffolder.domain.Restaurant;
import com.ehsan.jwtScaffolder.model.PageInfoParams;
import com.ehsan.jwtScaffolder.model.RestaurantRequest;
import com.ehsan.jwtScaffolder.model.RestaurantResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RestaurantService {
    RestaurantResponse createRestaurant(RestaurantRequest request,long user_id);
    Page<Restaurant> getAllRestaurant(PageInfoParams pageInfoParams);
}
