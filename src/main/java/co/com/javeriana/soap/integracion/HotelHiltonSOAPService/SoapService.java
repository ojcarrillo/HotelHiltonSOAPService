package co.com.javeriana.soap.integracion.HotelHiltonSOAPService;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;

import org.apache.camel.Exchange;
import org.apache.commons.lang3.StringUtils;
import org.example.demo.CancelarReserva;
import org.example.demo.CancelarReservaResponse;
import org.example.demo.ObtenerReserva;
import org.example.demo.ObtenerReservaResponse;
import org.example.demo.RealizarReserva;
import org.example.demo.RealizarReservaResponse;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.javeriana.soap.integracion.ftp.FTPInvoker;
import co.com.javeriana.soap.integracion.util.Utils;


@Component
public class SoapService {

	public void cancelarReserva(final Exchange exchange) throws InterruptedException {
		CancelarReserva datos = exchange.getIn().getBody(CancelarReserva.class);
		String filename = "cancelar_" + (new Date()).getTime();
		boolean success = false;
		CancelarReservaResponse response = new CancelarReservaResponse();
		success = FTPInvoker.uploadFile(FTPInvoker.createFile(filename, ".txt", datos.getIdReserva()),
				filename + ".txt");
		if (!success) {
			response.setEstado("ERROR");
			response.setMotivoEstado("NO FUE POSIBLE CONECTARSE AL FTP DE HOTEL HILTON");
			response.setFechaRespuesta(Utils.getFechaEvento());
			response.setCodigoEstado("0");
		} else {
			Thread.sleep(6000);
			String rsta = FTPInvoker.getStringFromFile(FTPInvoker.downloadFile("rta_" + filename + ".txt", filename + ".txt"));
			if (rsta!=null) {
				response.setEstado("ANULADO");
				response.setMotivoEstado(rsta.substring(16, rsta.length()));
				response.setFechaRespuesta(Utils.getFechaEvento());
				response.setCodigoEstado("2");
			}else {
				response.setEstado("ERROR");
				response.setMotivoEstado("NO SE ENCONTRO RESERVA");
				response.setFechaRespuesta(Utils.getFechaEvento());
				response.setCodigoEstado("1");
			}
		}
		exchange.getOut().setBody(response);
	}

	public void obtenerReserva(final Exchange exchange) throws InterruptedException, ParseException {
		ObtenerReserva datos = exchange.getIn().getBody(ObtenerReserva.class);
		String filename = "query_reservas_" + (new Date()).getTime();
		boolean success = false;
		ObtenerReservaResponse response = new ObtenerReservaResponse();
		success = FTPInvoker.uploadFile(FTPInvoker.createFile(filename, ".txt", datos.getIdReserva()),
				filename + ".txt");
		if (!success) {
			response.setEstado("ERROR");
			response.setMotivoEstado("NO FUE POSIBLE CONECTARSE AL FTP DE HOTEL HILTON");
			response.setFechaRespuesta(Utils.getFechaEvento());
			response.setCodigoEstado("0");
		} else {
			Thread.sleep(6000);
			String rsta = FTPInvoker.getStringFromFile(FTPInvoker.downloadFile("rta_" + filename + ".txt", filename + ".txt"));
			if (rsta!=null) {
				response.setIdReserva(rsta.substring(0, 9).trim());
				response.setIdHabitacion(rsta.substring(9, 18).trim());
				response.setFechaIngreso(Utils.getFechaEvento(Utils.parseStringDate(rsta.substring(18, 30), "ddMMyyyyHHmm")));
				response.setFechaSalida(Utils.getFechaEvento(Utils.parseStringDate(rsta.substring(18, 30), "ddMMyyyyHHmm"))); 
//				response.setCiudad((rsta.substring(30, 51).trim());
//				response.setCiudadDestino(rsta.substring(51, 72).trim());
//				response.setPuestos(rsta.substring(72, rsta.length()).trim());
				response.setEstado("COMPLETO");
				response.setMotivoEstado("RESERVA PENDIENTE DE CONFIRMAR");
				response.setFechaRespuesta(Utils.getFechaEvento());
				response.setCodigoEstado("2");
			}else {
				response.setEstado("ERROR");
				response.setMotivoEstado("NO SE ENCONTRO RESERVA");
				response.setFechaRespuesta(Utils.getFechaEvento());
				response.setCodigoEstado("1");
			}
		}
		exchange.getOut().setBody(response);
	}

	public void realizarReserva(final Exchange exchange) throws ParseException, InterruptedException {
		RealizarReserva datos = exchange.getIn().getBody(RealizarReserva.class);
		String filename = "reservar_" + (new Date()).getTime();
		boolean success = false;
		RealizarReservaResponse response = new RealizarReservaResponse();
		StringBuilder datosReserva = new StringBuilder();
		datosReserva.append(Utils.parseDateString(datos.getFechaIngreso().toGregorianCalendar().getTime(), "ddMMyyyyHH00"));
		datosReserva.append(Utils.parseDateString(datos.getFechaSalida().toGregorianCalendar().getTime(), "ddMMyyyyHH00"));
		datosReserva.append(StringUtils.rightPad(datos.getCiudad(), 21," "));
		datosReserva.append(StringUtils.rightPad(datos.getHotel(), 31," "));
		datosReserva.append(datos.getHabitacion());
		success = FTPInvoker.uploadFile(FTPInvoker.createFile(filename, ".txt", datosReserva.toString()), filename + ".txt");
		if (!success) {
			response.setEstado("ERROR");
			response.setMotivoEstado("NO FUE POSIBLE CONECTARSE AL FTP DE HOTEL HILTON");
			response.setFechaRespuesta(Utils.getFechaEvento());
			response.setCodigoEstado("0");
		} else {
			Thread.sleep(6000);
			String rsta = FTPInvoker.getStringFromFile(FTPInvoker.downloadFile("rta_" + filename + ".txt", filename + ".txt"));
			if (rsta!=null) {
				response.setIdReserva(rsta.substring(0, 9).trim());
				response.setIdHabitacion(rsta.substring(9, 18).trim());
				response.setFechaIngreso(Utils.getFechaEvento(Utils.parseStringDate(rsta.substring(18, 30), "ddMMyyyyHHmm")));
				response.setFechaSalida(Utils.getFechaEvento(Utils.parseStringDate(rsta.substring(30, 42), "ddMMyyyyHHmm")));
				response.setCiudad(rsta.substring(42, 63).trim());
				response.setHotel(rsta.substring(63, 94).trim());
				response.setHabitacion(rsta.substring(94, rsta.length()).trim());
				response.setEstado("COMPLETO");
				response.setMotivoEstado("RESERVA PENDIENTE DE CONFIRMAR");
				response.setFechaRespuesta(Utils.getFechaEvento());
				response.setCodigoEstado("2");
			}else {
				response.setEstado("ERROR");
				response.setMotivoEstado("NO SE ENCONTRO RESERVA");
				response.setFechaRespuesta(Utils.getFechaEvento());
				response.setCodigoEstado("1");
			}
		}
		exchange.getOut().setBody(response);
	}
}
