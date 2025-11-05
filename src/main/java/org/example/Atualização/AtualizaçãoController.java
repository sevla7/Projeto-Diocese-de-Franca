package org.example.Atualização;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/atualizacoes")
public class AtualizaçãoController {

    private final IAtualizacao repository;

    public AtualizacaoController(IAtualizacao repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Atualizacao> listar() {
        return repository.findAll();
    }

    @PostMapping
    public Atualizacao cadastrar(@RequestBody Atualizacao atualizacao) {
        return repository.save(atualizacao);
    }

    @PutMapping("/{id}")
    public Atualizacao atualizar(@PathVariable Integer id, @RequestBody Atualizacao novaAtualizacao) {
        return repository.findById(id)
                .map(a -> {
                    a.setDescricao(novaAtualizacao.getDescricao());
                    a.setDataFechamento(novaAtualizacao.getDataFechamento());
                    return repository.save(a);
                })
                .orElseThrow(() -> new RuntimeException("Atualização não encontrada"));
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
