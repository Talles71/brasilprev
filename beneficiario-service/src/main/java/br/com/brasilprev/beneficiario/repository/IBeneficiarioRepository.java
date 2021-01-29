package br.com.brasilprev.beneficiario.repository;

import br.com.brasilprev.beneficiario.model.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBeneficiarioRepository extends JpaRepository<Beneficiario, String> {
}
