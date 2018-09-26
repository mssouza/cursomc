package br.com.local.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.local.cursomc.domain.Pedido;
import br.com.local.cursomc.repositories.PedidoRepository;
import br.com.local.cursomc.services.exceptions.ObjectNotFoundException;
@Service
public class PedidoService {
	@Autowired
	private PedidoRepository pedidoRepository;
		
		public Pedido find(Integer id) {
			Optional<Pedido> obj = pedidoRepository.findById(id);
			return obj.orElseThrow(() -> new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
		}
}
