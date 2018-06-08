package br.com.db1.start.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.db1.start.classes.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Integer>{

}
