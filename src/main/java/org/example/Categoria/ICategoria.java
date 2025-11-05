package org.example.Categoria;

import org.example.Desenvolvedor.DesenvolvedorModel;
import org.springframework.dao.UncategorizedDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoria extends JpaRepository<CategoriaModel, Integer> { }
