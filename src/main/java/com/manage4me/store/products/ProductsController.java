package com.manage4me.store.products;

import com.manage4me.store.entities.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductsController {

    private final ProductsService productsService;

    @GetMapping("/products")
    public ResponseEntity<List<Product>> products() {
        return ResponseEntity.ok().body(productsService.findAll());
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product> product(@PathVariable Long id) {
        return ResponseEntity.ok().body(productsService.findById(id));
    }

    @GetMapping("/product/delete/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        productsService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/product")
    public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
        return ResponseEntity.ok().body(productsService.save(product));
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id,
                                                 @RequestBody Product product) {
        return ResponseEntity.ok().body(productsService.update(id, product));
    }



}
