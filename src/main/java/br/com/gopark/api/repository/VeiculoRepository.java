package br.com.gopark.api.repository;

import br.com.gopark.entity.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface VeiculoRepository extends JpaRepository<Veiculo, Integer> {

    List<Veiculo> findAll();

    Optional<Veiculo> findById(Integer id);

    void deleteById(Integer id);

}
