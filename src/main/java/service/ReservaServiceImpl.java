package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import dao.ReservasDao;
import model.Reserva;
import model.ReservaPersona;

@Service
public class ReservaServiceImpl implements ReservaService {

	ReservasDao dao;

	RestTemplate template;
	String urlVuelos = "http://localhost:9000/agencia";

	public ReservaServiceImpl(@Autowired ReservasDao dao, @Autowired RestTemplate template) {
		super();
		this.dao = dao;
		this.template = template;
	}

	@Override
	public boolean altaReserva(ReservaPersona r) {
		HttpEntity<String> request = new HttpEntity<String>("");
		ResponseEntity<String> response = template.exchange(
				urlVuelos + "/Vuelo/" + r.getVuelo() + "/" + r.getNPersonas(), HttpMethod.PUT, request, String.class);
		if (response.getBody().equals("true")) {
			dao.save(new Reserva(r.getIdreserva(), r.getNombre(), r.getDni(), r.getHotel(), r.getVuelo()));
			return true;
		}
		return false;
	}

	@Override
	public List<Reserva> reservas() {
		return dao.findAll();
	}

}
