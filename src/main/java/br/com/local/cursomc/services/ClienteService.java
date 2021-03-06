package br.com.local.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.local.cursomc.domain.Cliente;
import br.com.local.cursomc.repositories.ClienteRepository;
import br.com.local.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
		
		public Cliente find(Integer id) {
			Optional<Cliente> obj = clienteRepository.findById(id);
			return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
		}
}
