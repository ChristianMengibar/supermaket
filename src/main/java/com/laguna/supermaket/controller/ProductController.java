package com.laguna.supermaket.controller;

import com.laguna.supermaket.persistence.entity.Product;
import com.laguna.supermaket.service.ProductService;
import com.laguna.supermaket.service.dto.ProductInDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
//Camino hacia el controlador
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all") //Buscar todos los productos
    public List<Product> findAll() {
        return this.productService.findAll();
    }

    @GetMapping("/{id}")//Buscar un producto
    public ResponseEntity<Product> findProductById(@PathVariable Long id) {
        Optional<Product> product = productService.findProductById(id);

        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/create") //Crear elementos
    public Product createProduct(@RequestBody ProductInDto productInDTO) {
        return this.productService.createProduct(productInDTO);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable Long id,
                                                @RequestBody ProductInDto productInDTO) {
        try {
            productInDTO.setId(id);
            this.productService.updateProduct(productInDTO);
            return ResponseEntity.ok("Producto actualizado");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al actualizar el producto: " + e.getMessage());
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteProduct(@RequestBody ProductInDto productInDTO) {
        //Utilizamos el try catch para ver si hay algun problema al eliminar el producto que nos
        //muestre el mensaje de si se ha eliminado o si no se ha eliminado por algun error.
        try {
            this.productService.deleteProduct(productInDTO);
            return ResponseEntity.ok("Product borrado");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("ERROR al borrar el producto: " + e.getMessage());
        }
    }

    @PutMapping("/stockOneDown/{id}")
    public ResponseEntity<String> stockOneDownProduct(@PathVariable Long id) {
        try {
            productService.stockModify(id, -1);
            return ResponseEntity.ok("Stock cambiado correctamente.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al cambiar el stock " + e.getMessage());
        }
    }

    @PutMapping("/stockModify/{difference}/{id}")
    public ResponseEntity<String> stockModify(@PathVariable Long id,
                                              @PathVariable double difference) {
        try {
            productService.stockModify(id, difference);
            return ResponseEntity.ok("Stock cambiado correctamente.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error al cambiar el stock " + e.getMessage());
        }
    }
}
