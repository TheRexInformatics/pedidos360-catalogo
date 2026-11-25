package com.example.pedidos360_catalog;

import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/v1/catalogo")
public class CatalogoController {

    // Inicia vacío: sin productos por defecto
    private final List<String> productos = new CopyOnWriteArrayList<>();

    @GetMapping
    public List<String> obtenerCatalogo() {
        return productos;
    }

    @PostMapping
    public Map<String, Object> crearProductoCatalogo(@RequestBody Map<String, Object> body) {
        String nombre = String.valueOf(body.getOrDefault("nombre", "")).trim();

        if (!nombre.isEmpty() && !productos.contains(nombre)) {
            productos.add(nombre);
        }

        return Map.of(
            "mensaje", "Producto agregado al catálogo",
            "producto", nombre,
            "catalogo", productos
        );
    }
}
