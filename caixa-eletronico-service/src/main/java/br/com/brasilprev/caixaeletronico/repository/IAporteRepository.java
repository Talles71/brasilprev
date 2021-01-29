package br.com.brasilprev.caixaeletronico.repository;

import br.com.brasilprev.caixaeletronico.model.Aporte;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAporteRepository extends JpaRepository<Aporte, String> {
}
