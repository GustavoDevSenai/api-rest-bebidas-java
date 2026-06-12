package com.haus.api_rest_cerveja.service;

import com.haus.api_rest_cerveja.model.Beer;
import com.haus.api_rest_cerveja.repository.BeerRepository;
import org.springframework.stereotype.Service;


@Service
public class BeerService {

    private final BeerRepository repository;

    public BeerService(BeerRepository repository) {
        this.repository = repository;
    }

    public Beer salvar(Beer beer){
        if(beer.getQuantidade() < 0) {
            throw new RuntimeException(("Quantidade invalida"));

        }
        return repository.save(beer);
    }


}
