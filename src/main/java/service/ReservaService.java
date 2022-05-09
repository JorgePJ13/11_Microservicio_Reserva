package service;

import java.util.List;

import model.Reserva;
import model.ReservaPersona;

public interface ReservaService {

	/**
	 * Metodo que da de alta una nueva reserva
	 * 
	 * @param r: datos de la reserva de la persona a añadir
	 * @return true si se ha añadido la reserva; false en caso contrario
	 */
	boolean altaReserva(ReservaPersona r);
	
	/**
	 * Metodo que devuelve una lista con todas las reservas realizadas
	 * 
	 * @return la lista de las reservas realizadas
	 */
	List<Reserva> reservas();
}
