package com.andre.bookstore.services;

import com.andre.bookstore.domain.Categoria;
import com.andre.bookstore.dtos.CategoriaDTO;
import com.andre.bookstore.repositories.CategoriaRepository;
import com.andre.bookstore.services.exceptions.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria findById(Integer id) {
        Optional<Categoria> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
    }

    public List<Categoria> findAll() {
        return repository.findAll();
    }

    public Categoria create(Categoria obj) {
        obj.setId(null);
        return repository.save(obj);
    }

    public Categoria update(Integer id, CategoriaDTO objDto) {
        Categoria obj = findById(id);
        obj.setNome(objDto.getNome());
        obj.setDesc(objDto.getDescricao());
        return repository.save(obj);
    }
}