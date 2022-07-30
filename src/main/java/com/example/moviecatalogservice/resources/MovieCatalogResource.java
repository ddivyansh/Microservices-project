package com.example.moviecatalogservice.resources;

import com.example.moviecatalogservice.models.CatalogItem;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatlog(@PathVariable String userId){
        return Collections.singletonList(new CatalogItem("Jujutsu Kaisen", "Anime movie about curses", 5));
    }
}
