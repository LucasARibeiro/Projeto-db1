package br.com.db1.start.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.db1.start.classes.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {
	
	

}
