package com.haus.api_rest_cerveja.controller;


import ch.qos.logback.core.model.Model;
import com.haus.api_rest_cerveja.model.Beer;
import com.haus.api_rest_cerveja.service.BeerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/beers")
public class BeerController {

    private final BeerService service;


    public BeerController(BeerService service) {
        this.service = service;
    }

    @PostMapping
    public Beer cadastrar(@RequestBody Beer beer){
        return service.salvar(beer);
    }


    @GetMapping("/")
    public String home(Model model) {

        List<String> cervejas = List.of(
                "Pilsen",
                "IPA",
                "Weiss",
                "Stout"
        );

        model.addText("cervejas");

        return "index";
    }
}
