package com.ehsan.jwtScaffolder.endpoint;


import com.ehsan.jwtScaffolder.domain.Restaurant;
import com.ehsan.jwtScaffolder.model.PageInfoParams;
import com.ehsan.jwtScaffolder.model.RestaurantRequest;
import com.ehsan.jwtScaffolder.model.RestaurantResponse;
import com.ehsan.jwtScaffolder.security.AuthEntryPointJwt;
import com.ehsan.jwtScaffolder.service.RestaurantService;
import com.ehsan.jwtScaffolder.service.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class RestaurantController {
    private static final Logger logger = LoggerFactory.getLogger(RestaurantController.class);
    @Autowired
    RestaurantService restaurantService;

    @PostMapping("/restaurant")
    @PreAuthorize("hasRole('OWNER')")
    public RestaurantResponse createRestaurant(@RequestBody RestaurantRequest request){
        UserDetailsImpl user = (UserDetailsImpl)SecurityContextHolder.getContext().getAuthentication()
                .getPrincipal();
        return restaurantService.createRestaurant(request,user.getId());
    }
    @GetMapping("/restaurant/all")
    public ResponseEntity<Page<Restaurant>> getAllRestaurant(@RequestParam Map<String, String> searchParam){
        Page<Restaurant> restList = null;
        PageInfoParams params = prepareSearchParams(searchParam);
        restList = restaurantService.getAllRestaurant(params);
        return ResponseEntity.ok(restList);
    }
    PageInfoParams prepareSearchParams(Map<String,String> searchParam){
        PageInfoParams responseParam = PageInfoParams.builder()
                .pageNumber(searchParam.get("page")!= null ?  Integer.valueOf(searchParam.get("page")) : 0  )
                .pageSize(searchParam.get("pageSize")!= null ?  Integer.valueOf(searchParam.get("pageSize")) : 100  )
                .build();
        logger.info("searchParams {}", searchParam);
        return  responseParam;
    }

}
