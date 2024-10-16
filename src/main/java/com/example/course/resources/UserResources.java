package com.example.course.resources;

import java.net.URI;
import java.util.List;

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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.course.entities.User;
import com.example.course.services.UserService;

@RestController // Define que esta classe é um controlador REST.
@RequestMapping(value = "/users") // Mapeia a URL base "/users" para esse controlador.
public class UserResources {

	@Autowired // Injecao de dependencia
	private UserService service;

	@GetMapping // Mapeia requisições GET para o método abaixo.
	public ResponseEntity<List<User>> findAll() {
		// Método que retorna um objeto User dentro de um ResponseEntity.
		List<User> list = service.findAll();
		return ResponseEntity.ok().body(list); // Retorna uma resposta 200 OK com o usuário no corpo.
	}

	@GetMapping(value = "/{id}") // Mapeia o novo caminho de url para o metodo
	public ResponseEntity<User> findById(@PathVariable Integer id) { // PathVariable para aceitar o parametro como url
		User obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<User> insert(@RequestBody User obj) { // Recebe o objeto "User" no corpo da requisição
		obj = service.insert(obj); // Chama o método de inserção no service, que salva o usuário
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/id") // Cria a URI para o novo recurso
				.buildAndExpand(obj.getId()).toUri(); // Expande o ID do usuário no path da URI
		return ResponseEntity.created(uri).body(obj); // Retorna o status "created" com a URI e o objeto salvo
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<User> delete(@PathVariable Integer id) { // Recebe o "id" do usuário pela URL
		service.delete(id); // Chama o método de deleção no service, que remove o usuário pelo ID
		return ResponseEntity.noContent().build(); // Retorna o status "no content" indicando sucesso sem conteúdo no
													// corpo
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<User> update(@PathVariable Integer id, @RequestBody User obj) { // Recebe o "id" pela URL e o objeto User pelo corpo da requisição
	    obj = service.update(id, obj); // Chama o método de atualização no service, passando o ID e o novo objeto
	    return ResponseEntity.ok().body(obj); // Retorna o status "ok" com o objeto atualizado no corpo da resposta
	}
}