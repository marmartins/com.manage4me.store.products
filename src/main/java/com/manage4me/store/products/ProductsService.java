package com.manage4me.store.products;

import com.manage4me.store.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsService {

    private final ProductsRepository productsRepository;

    public Product findById(Long id) {
        return productsRepository.findById(id).get();
    }

    public Product save(Product product) {
        return productsRepository.save(product);
    }

    public Product update(Long id, Product product) {
        Product productToUpdate = productsRepository.findById(id).get();
        productToUpdate.setName(product.getName());
        productToUpdate.setDescription(product.getDescription());
        productToUpdate.setPrice(product.getPrice());
        return productsRepository.save(productToUpdate);
    }

    public void deleteById(Long id) {
        productsRepository.deleteById(id);
    }

    public List<Product> findAll() {
        return productsRepository.findAll();
    }

}
