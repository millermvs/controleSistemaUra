package br.com.lognetbr.repositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.lognetbr.entities.LigacaoUra;

@Repository
public interface LigacaoUraRepository extends JpaRepository<LigacaoUra, Long> {
	@Query("""
			SELECT lu FROM LigacaoUra lu
			WHERE lu.datageracao BETWEEN :pdataInicio AND :pdataFim
			ORDER BY lu.datageracao ASC
			""")
	List<LigacaoUra> findByDate(@Param("pdataInicio") LocalDate dataInicio, @Param("pdataFim") LocalDate dataFim);
}
