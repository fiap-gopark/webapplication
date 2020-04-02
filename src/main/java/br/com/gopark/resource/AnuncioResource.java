package br.com.gopark.resource;

import br.com.gopark.dao.AnuncioDAO;
import br.com.gopark.entity.Anuncio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("anuncio-rest")
public class AnuncioResource {

    @Autowired
    private AnuncioDAO anuncioDAO;

    //TODO Mostrar informações como endereço e id do usuário
    @GetMapping
    public List<Anuncio> listar() {

        return anuncioDAO.getAll();

    }


    @GetMapping("/{id}")
    public Anuncio listarPorId(@PathVariable Integer id) {

        return anuncioDAO.select(id);

    }


    //TODO ARRUMAR
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional
    @PostMapping
    public void cadastrar(@RequestBody Anuncio anuncio) {

        anuncioDAO.insert(anuncio);

    }


    //TODO ARRUMAR
    @Transactional
    @PutMapping("/{id}")
    public void editar(@RequestBody Anuncio anuncio, @PathVariable Integer id) {

        anuncio.setId(id);
        anuncioDAO.update(anuncio);

    }


    @Transactional
    @DeleteMapping("/{id}")
    public void remover(@PathVariable Integer id) {

        try {

            anuncioDAO.delete(id);

        } catch (Exception e) {

            log.error("Erro ao deletar anúncio com id: " + id, e);

        }

    }


    @GetMapping("/cidade/{cidade}")
    public List<Anuncio> pesquisarByCidade(@PathVariable String cidade) {

        return anuncioDAO.getByCidade(cidade);

    }


}
