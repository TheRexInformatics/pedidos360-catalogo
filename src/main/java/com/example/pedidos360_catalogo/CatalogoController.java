package com.example.pedidos360_catalogo;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/catalogo")
public class CatalogoController {

    private final List<String> productos = new ArrayList<>(Arrays.asList(
        "Hamburguesa Triple", 
        "Papas Supremas", 
        "Bebida Grande", 
        "Pizza Familiar",
        "Pastel de Chocolate"
    ));

    @GetMapping
    public List<String> obtenerProductos() {
        return productos;
    }

    @PostMapping
    public String agregarProducto(@RequestBody String nuevoProducto) {
        productos.add(nuevoProducto);
        return "Producto añadido al catálogo";
    }

    @PutMapping("/{id}")
    public String modificarProducto(@PathVariable int id, @RequestBody String productoModificado) {
        if (id >= 0 && id < productos.size()) {
            productos.set(id, productoModificado);
            return "Producto actualizado";
        }
        return "Error: Producto no encontrado";
    }

    @DeleteMapping("/{id}")
    public String eliminarProducto(@PathVariable int id) {
        if (id >= 0 && id < productos.size()) {
            productos.remove(id);
            return "Producto eliminado del catálogo";
        }
        return "Error: Producto no encontrado";
    }
}