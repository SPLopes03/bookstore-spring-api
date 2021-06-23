package com.andre.bookstore.services;

import com.andre.bookstore.domain.Categoria;
import com.andre.bookstore.domain.Livro;
import com.andre.bookstore.repositories.CategoriaRepository;
import com.andre.bookstore.repositories.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class DBService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private LivroRepository livroRepository;

    public void instanciaDados() {
        Categoria cat1 = new Categoria(null, "Informatica", "livros de TI");
        Categoria cat2 = new Categoria(null, "Ficção Cientifica", "livros de ficção");
        Categoria cat3 = new Categoria(null, "Biografia", "livros de biografia");
        Categoria cat4 = new Categoria(null, "Literatura", "livros de literatura");
        Livro l1 = new Livro(null, "Clean code", "Robert Martin", "Lorem ipsum", cat1);
        Livro l2 = new Livro(null, "Godzilla", "Alguem ai", "Lorem ipsum", cat2);
        Livro l3 = new Livro(null, "Stephen Hawking biografics", "Stephen Hawking", "Lorem ipsum", cat3);
        Livro l4 = new Livro(null, "The Witcher", "Andrzej Sapkowski", "Lorem ipsum", cat2);

        cat1.getLivros().addAll(Arrays.asList(l1));
        cat2.getLivros().addAll(Arrays.asList(l2, l4));
        cat3.getLivros().addAll(Arrays.asList(l3));

        this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
        this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4));
    }
}
