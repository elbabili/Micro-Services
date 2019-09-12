package co.simplon;

import co.simplon.dao.ProductRepository;
import co.simplon.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private RepositoryRestConfiguration restConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override	public void run(String... args) throws Exception {
        restConfiguration.exposeIdsFor(Product.class);

		productRepository.save(new Product(null,"imprimate hp",100,10));
		productRepository.save(new Product(null,"ordinateur hp",500,3));
        productRepository.save(new Product(null,"smart phone hp",100,15));
		productRepository.save(new Product(null,"ordi nuovo",200,5));
		productRepository.save(new Product(null,"ordi macbook",2000,1));
		productRepository.save(new Product(null,"smartphone nuovo",150,1));

        productRepository.save(new Product(null,"imprimate hp",110,10));
        productRepository.save(new Product(null,"ordinateur hp",510,3));
        productRepository.save(new Product(null,"smart phone hp",110,15));
        productRepository.save(new Product(null,"ordi nuovo",210,5));
        productRepository.save(new Product(null,"ordi macbook",2100,1));
        productRepository.save(new Product(null,"smartphone nuovo",160,1));

		productRepository.findAll().forEach(p->{
			System.out.println(p.toString());
		});
	}
}