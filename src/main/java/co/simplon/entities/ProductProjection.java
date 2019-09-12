package co.simplon.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "P1", types = Product.class)
public interface ProductProjection {
    public double getPrice();
    //http://localhost:8080/products?projection=P1
    public String getDesignation();
}
