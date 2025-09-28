package br.com.lognetbr.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.lognetbr.entities.LigacaoUra;

@Repository
public interface LigacaoUraRepository extends JpaRepository<LigacaoUra, Long> {

}
