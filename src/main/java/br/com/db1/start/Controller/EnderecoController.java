package br.com.db1.start.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.db1.start.Repository.EnderecoRepository;
import br.com.db1.start.Repository.PessoaRepository;
import br.com.db1.start.classes.Endereco;
import br.com.db1.start.classes.Pessoa;

@RestController
@RequestMapping("/endereco")
public class EnderecoController {

	@Autowired
	private EnderecoRepository repo;

	@PostMapping
	public ResponseEntity<Integer> save(@RequestBody Endereco novo) {
		repo.save(novo);
		return ResponseEntity.ok().body(novo.getId());
	}

	@GetMapping
	public ResponseEntity<List<Endereco>> getAll() {
		return ResponseEntity.ok().body(repo.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Endereco>> findOne(@PathVariable Integer id) {
		Optional<Endereco> endereco = repo.findById(id);
		return ResponseEntity.ok().body(endereco);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		repo.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Integer> update(@PathVariable Integer id, @RequestBody Endereco endereco) {
		repo.save(endereco);
		return ResponseEntity.ok().body(endereco.getId());
	}
}
