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

import br.com.db1.start.Repository.CidadeRepository;
import br.com.db1.start.classes.Cidade;

@RestController
@RequestMapping("/cidade")
public class CidadeController {

	@Autowired
	private CidadeRepository repo;
	

	@PostMapping
	public ResponseEntity<Integer> save(@RequestBody Cidade nova) {
		repo.save(nova);
		return ResponseEntity.ok().body(nova.getId());
	}

	@GetMapping
	public ResponseEntity<List<Cidade>> getAll() {
		return ResponseEntity.ok().body(repo.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Cidade>> findOne(@PathVariable Integer id) {
		Optional<Cidade> cidade = repo.findById(id);
		return ResponseEntity.ok().body(cidade);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		repo.deleteById(id);
		return ResponseEntity.ok().build();
	}

	@PutMapping("/{id}")
	public ResponseEntity<Integer> update(@PathVariable Integer id, @RequestBody Cidade cidade) {
		repo.save(cidade);
		return ResponseEntity.ok().body(cidade.getId());
	}
}
