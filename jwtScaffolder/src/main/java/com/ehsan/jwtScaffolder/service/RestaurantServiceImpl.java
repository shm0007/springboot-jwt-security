package com.ehsan.jwtScaffolder.service;

import com.ehsan.jwtScaffolder.Repository.RestautantRepository;
import com.ehsan.jwtScaffolder.domain.Restaurant;
import com.ehsan.jwtScaffolder.model.PageInfoParams;
import com.ehsan.jwtScaffolder.model.RestaurantRequest;
import com.ehsan.jwtScaffolder.model.RestaurantResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements  RestaurantService{

    @Autowired
    RestautantRepository restautantRepository;

    @Override
    public RestaurantResponse createRestaurant(RestaurantRequest request,long userId) {
        Restaurant rest = Restaurant.builder()
                .name(request.getName())
                .location(request.getLocation())
                .userId(userId)
                .build();
        restautantRepository.save(rest);
        return new RestaurantResponse();
    }

    @Override
    public Page<Restaurant> getAllRestaurant(PageInfoParams pageParams) {
        Pageable pageble  = PageRequest.of(  pageParams.getPageNumber(),
                pageParams.getPageSize()
                );

        return restautantRepository.findAll(pageble);

    }
}
