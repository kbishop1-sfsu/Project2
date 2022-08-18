package project2.reviewapp.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import project2.reviewapp.models.Location;
import project2.reviewapp.models.Restaurant;
import project2.reviewapp.models.RestaurantPage;
import project2.reviewapp.repos.RestaurantPageRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class RestaurantPageServiceTest {

    @Mock
    private RestaurantPageRepository restaurantPageRepo;
    @Mock
    private RestaurantPageService restaurantPageService;
    private RestaurantPage restaurantPage;

    @BeforeEach
    public void init(){
        restaurantPageRepo = Mockito.mock(RestaurantPageRepository.class);
        restaurantPageService = new RestaurantPageService(restaurantPageRepo);
        restaurantPage = RestaurantPage.builder()
                .id(1)
                .avgRating(3.5f)
                .restaurant(new Restaurant(1,
                        "jack's",
                        new Location(1,
                                "123 west way",
                                "blue town",
                                "California",
                                12345),
                        "food",
                        "www.food.com"))
                .build();
    }

    @Test
    public void getAllUsersList(){
        List<RestaurantPage> restaurantPageList = new ArrayList<>();
        restaurantPageList.add(restaurantPage);

        when(restaurantPageService.getAllRestPages()).thenReturn(restaurantPageList);
        List<RestaurantPage> restaurantPages = restaurantPageService.getAllRestPages();

        assertThat(restaurantPages).isNotNull();
        assertThat(restaurantPages.size()).isEqualTo(1);
    }

    @Test
    public void getUserById(){
        when(restaurantPageService.getRestPageById(1)).thenReturn(Optional.ofNullable(restaurantPage));
        Optional<RestaurantPage> restPageById = restaurantPageService.getRestPageById(1);

        assertThat(restPageById).isNotNull();
        assertThat(restPageById.get().getId()).isEqualTo(1);
    }
}