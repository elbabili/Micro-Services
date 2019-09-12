package co.simplon;

import co.simplon.dao.ProductRepository;
import co.simplon.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductRestService {
    @Autowired
    private ProductRepository productRepository;

    //récupère liste des produits
    @GetMapping(value = "/listProducts")
    public List<Product> listProducts(){
        return productRepository.findAll();
    }

    //récupère un produit à partir de son id  -> http://localhost:8080/listProducts/1
    @GetMapping(value = "/listProducts/{id}")
    public Product listProducts(@PathVariable(name="id") Long id){
        return productRepository.findById(id).get();
    }

    //met à jour un produit à partir de son id
    @PutMapping(value = "/listProducts/{id}")
    public Product update(@PathVariable(name="id") Long id,@RequestBody Product p){     //récupère au format json le produit
        p.setId(id);
        return productRepository.save(p);
    }

    //enregistre un produit
    @PostMapping(value = "/listProducts")
    public Product save(@RequestBody Product p){    //@RequestBody -> récupère au format json le produit
        return productRepository.save(p);
    }

    //supprime un produit
    @DeleteMapping(value = "/listProducts/{id}")
    public void delete(@PathVariable(name="id") Long id){
        productRepository.deleteById(id);
    }
}