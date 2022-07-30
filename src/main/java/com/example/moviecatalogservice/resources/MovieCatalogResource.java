package com.example.moviecatalogservice.resources;

import com.example.moviecatalogservice.models.CatalogItem;
import com.example.moviecatalogservice.models.Movie;
import com.example.moviecatalogservice.models.Rating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
    @Autowired
    private RestTemplate restTemplate; //allows us to connect to a URL.

    @Autowired
    private WebClient.Builder webClientBuilder;//Same as rest template but reactive.

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatlog(@PathVariable String userId) {
        //URL to get info : http://localhost:8082/movies/a015

        //Rated movies watched by userId
        List<Rating> ratings = Arrays.asList(
                new Rating(5, "A0001"),
                new Rating(6, "A0002")
        );

        //Now we have to transform the above list into a list of CatalogItem
        return ratings.stream().map(
                        rating -> {
//                            Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
                            Movie movie = webClientBuilder.build()
                                    .get()
                                    .uri("http://localhost:8082/movies/" + rating.getMovieId())
                                    .retrieve()
                                    .bodyToMono(Movie.class)
                                    .block();

                            return new CatalogItem(movie.getName(), "Desc", rating.getRatedValue());

                        }
                )
                .collect(Collectors.toList());

    }
}
