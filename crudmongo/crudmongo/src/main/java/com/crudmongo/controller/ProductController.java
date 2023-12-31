/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.crudmongo.controller;

import com.crudmongo.model.Producto;
import com.crudmongo.repository.IProductDAO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Abel Gomez
 */
@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.POST, RequestMethod.GET, RequestMethod.PUT,
    RequestMethod.DELETE})
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private IProductDAO repository;

    @PostMapping("/crearproducto")
    public Producto create(@Validated @RequestBody Producto p) {
        return repository.insert(p);
    }

    @GetMapping("/listarproductos")
    public List<Producto> readAll() {
        return repository.findAll();
    }

    @PutMapping("/editarproducto/{id}")
    public Producto update(@PathVariable String id, @Validated @RequestBody Producto p) {
        return repository.save(p);
    }

    @DeleteMapping("/eliminarproducto/{id}")
    public void delete(@PathVariable String id) {
        repository.deleteById(id);
    }

}
