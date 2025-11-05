package org.example.Fiel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FielController {
    @Autowired
    private IFiel dao;

    @GetMapping("/cadastro")
    public List<FielModel> listaFieis () {
        return (List<FielModel>) dao.findAll();
    }
}