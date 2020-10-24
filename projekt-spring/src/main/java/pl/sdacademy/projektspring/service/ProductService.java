package pl.sdacademy.projektspring.service;

import org.springframework.stereotype.Service;
import pl.sdacademy.projektspring.model.Product;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final Map< Integer, Product> data = new HashMap<>();

    public ProductService() {
        data.put(1,new Product("Marchewka bio z wolnego wybiegu",9.99));
        data.put(2,new Product("Kapusta kiszona",5.50));
        data.put(3,new Product("Czosnek",3.78));
        data.put(4,new Product("Jablka",5.99));
        data.put(5,new Product("Cebula",0.99));
    }

    public Product findById (Integer id){

        return data.get(id);

    }
    public List<Product> findByName (String name){
        return this.data.entrySet()
                .stream()
                .filter(entrySetElement -> entrySetElement.getValue().getName().toLowerCase().contains(name.toLowerCase()))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }
}

