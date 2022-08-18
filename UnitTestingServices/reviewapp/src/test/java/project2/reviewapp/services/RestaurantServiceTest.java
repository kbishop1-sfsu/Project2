package project2.reviewapp.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import project2.reviewapp.models.Location;
import project2.reviewapp.models.Restaurant;
import project2.reviewapp.repos.RestaurantRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class RestaurantServiceTest {

    @Mock
    private RestaurantService restaurantService;
    @Mock
    private RestaurantRepository restaurantRepository;
    private Restaurant restaurant;

    @BeforeEach
    public void init(){
        restaurantRepository = Mockito.mock(RestaurantRepository.class);
        restaurantService = new RestaurantService(restaurantRepository);
        restaurant = Restaurant.builder()
                .id(1)
                .restaurantName("WingStop")
                .foodCategory("Wings")
                .website("www.wingstop.com")
                .location(new Location(1,
                        "123 west way",
                        "blue town",
                        "California",
                        12345))
                .build();
    }

    @Test
    public void getAllRestaurantsList(){
        List<Restaurant> restaurantList = new ArrayList<>();
        restaurantList.add(restaurant);

        when(restaurantService.getAllRestaurants()).thenReturn(restaurantList);
        List<Restaurant> restaurants = restaurantService.getAllRestaurants();

        assertThat(restaurants).isNotNull();
        assertThat(restaurants.size()).isEqualTo(1);
    }
    @Test
    public void getRestById(){
        when(restaurantService.getRestaurantById(1)).thenReturn(Optional.ofNullable(restaurant));
        Optional<Restaurant> restaurants = restaurantService.getRestaurantById(1);

        assertThat(restaurants).isNotNull();
        assertThat(restaurants.get().getId()).isEqualTo(1);
    }

}