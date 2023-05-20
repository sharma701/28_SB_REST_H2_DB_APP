package in.gauravit.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.gauravit.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
