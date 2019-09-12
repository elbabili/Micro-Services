package co.simplon.dao;

import co.simplon.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;
@CrossOrigin("*")       // autorisation est donnée à une partie front end d'un autre nom de domaine d'accéder à votre api, tous les domaines ici
@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product,Long> {
    @RestResource(path = "/byDesignation")
    public List<Product> findByDesignationContains(@Param("mc") String des);
    //http://localhost:8080/products/search/byDesignation?mc=hp
    @RestResource(path = "/byDesignationPage")
    public Page<Product> findByDesignationContains(@Param("mc") String des, Pageable pageable);
    //http://localhost:8080/products/search/byDesignationPage?mc=hp&page=0&size=2
}
