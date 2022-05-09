package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import model.Reserva;
import model.ReservaPersona;
import service.ReservaService;

@RestController
public class ReservaController {

	@Autowired
	ReservaService service;

	@GetMapping(value = "Reservas", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Reserva> reservas() {
		return service.reservas();
	}

	@PostMapping(value = "Reserva", consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public boolean altaReserva(@RequestBody ReservaPersona r) {
		return service.altaReserva(r);
	}
}
