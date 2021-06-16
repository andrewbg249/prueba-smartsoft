package com.smartsoft.pruebasmartsoft.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.smartsoft.pruebasmartsoft.models.Client;
import com.smartsoft.pruebasmartsoft.repository.ClientRepository;

@RestController
@RequestMapping("/api")
public class ClientController {

	@Autowired
	private ClientRepository clientRepository;

	@GetMapping("/client")
	public ResponseEntity<List<Client>> getAllClients(@RequestParam(required = false) String id) {
		try {
			List<Client> clients = new ArrayList<Client>();

			if (id == null)
				clientRepository.findAll().forEach(clients::add);

			if (clients.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(clients, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/client/{id}")
	public ResponseEntity<Client> getClientById(@PathVariable("id") String id) {
		Optional<Client> clientData = clientRepository.findById(id);

		if (clientData.isPresent()) {
			return new ResponseEntity<>(clientData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/add-client")
	public ResponseEntity<Client> createClient(@RequestBody Client client) {
		try {
			Client _client = clientRepository.save(new Client(client.getFirst_name(), client.getLast_name(),
					client.getAddress(), client.getDate_birth(), client.getPhone(), client.getEmail()));
			return new ResponseEntity<>(_client, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
