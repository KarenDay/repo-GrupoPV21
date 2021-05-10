package ar.edu.unju.fi.tp4.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;
/**
 * 
 * @author Karen Flores
 *
 */
@Component("unCliente")
public class Cliente {
	private String tipoDocumento;
	private int nroDocumento;
	private String nombreApellido;
	private String email;
	private String password;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	private int edad;
	private int codigoAreaTelefono;
	private int nrotelefono;
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private LocalDate fechaUltimaCompra;
	
	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	

	/**
	 * @param tipoDocumento
	 * @param nroDocumento
	 * @param nombreApellido
	 * @param email
	 * @param password
	 * @param fechaNacimiento
	 * @param codigoAreaTelefono
	 * @param nrotelefono
	 * @param fechaUltimaCompra
	 */
	public Cliente(String tipoDocumento, int nroDocumento, String nombreApellido, String email, String password,
			LocalDate fechaNacimiento, int codigoAreaTelefono, int nrotelefono, LocalDate fechaUltimaCompra) {
		super();
		this.tipoDocumento = tipoDocumento;
		this.nroDocumento = nroDocumento;
		this.nombreApellido = nombreApellido;
		this.email = email;
		this.password = password;
		this.fechaNacimiento = fechaNacimiento;
		this.codigoAreaTelefono = codigoAreaTelefono;
		this.nrotelefono = nrotelefono;
		this.fechaUltimaCompra = fechaUltimaCompra;
		
	}



	/**
	 * @return the tipoDocumento
	 */
	public String getTipoDocumento() {
		return tipoDocumento;
	}

	/**
	 * @param tipoDocumento the tipoDocumento to set
	 */
	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	/**
	 * @return the nroDocumento
	 */
	public int getNroDocumento() {
		return nroDocumento;
	}

	/**
	 * @param nroDocumento the nroDocumento to set
	 */
	public void setNroDocumento(int nroDocumento) {
		this.nroDocumento = nroDocumento;
	}

	/**
	 * @return the nombreApellido
	 */
	public String getNombreApellido() {
		return nombreApellido;
	}

	/**
	 * @param nombreApellido the nombreApellido to set
	 */
	public void setNombreApellido(String nombreApellido) {
		this.nombreApellido = nombreApellido;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the fechaNacimiento
	 */
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	/**
	 * @param fechaNacimiento the fechaNacimiento to set
	 */
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	/**
	 * @return the edad
	 */
	public int getEdad() {
		this.edad=calcularEdad();
		return edad;
	}

	/**
	 * 
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}

	/**
	 * @return the codigoAreaTelefono
	 */
	public int getCodigoAreaTelefono() {
		return codigoAreaTelefono;
	}

	/**
	 * @param codigoAreaTelefono the codigoAreaTelefono to set
	 */
	public void setCodigoAreaTelefono(int codigoAreaTelefono) {
		this.codigoAreaTelefono = codigoAreaTelefono;
	}

	/**
	 * @return the nrotelefono
	 */
	public int getNrotelefono() {
		return nrotelefono;
	}

	/**
	 * @param nrotelefono the nrotelefono to set
	 */
	public void setNrotelefono(int nrotelefono) {
		this.nrotelefono = nrotelefono;
	}

	/**
	 * @return the fechaUltimaCompra
	 */
	public LocalDate getFechaUltimaCompra() {
		return fechaUltimaCompra;
	}

	/**
	 * @param fechaUltimaCompra the fechaUltimaCompra to set
	 */
	public void setFechaUltimaCompra(LocalDate fechaUltimaCompra) {
		this.fechaUltimaCompra = fechaUltimaCompra;
	}
	
	public int calcularEdad() {
		LocalDate fechaActual= LocalDate.now();
		Period anios= Period.between(this.getFechaNacimiento(), fechaActual);
		return anios.getYears();
	}

	
	public String calcularFechaUltimaCompra() {
		LocalDate fechaActual=LocalDate.now();
		Period periodo= Period.between(this.getFechaUltimaCompra(), fechaActual);
		String tiempoTranscurrido= periodo.getYears()+" años "+periodo.getMonths()+" meses y "+periodo.getDays()+" dias";
		return tiempoTranscurrido;
	}
	
	public String calcularTiempoDesdeFechaNacimiento() {
		Calendar hoy = Calendar.getInstance();
		Calendar fechaNac= Calendar.getInstance();
		fechaNac.set(this.fechaNacimiento.getYear(), this.fechaNacimiento.getMonthValue()-1, this.fechaNacimiento.getDayOfMonth());

		long cantidadDias = (hoy.getTimeInMillis()-fechaNac.getTimeInMillis())/1000/60/60/24;
		return cantidadDias+" dias";
	}
	
	public String calcularTiempoHastaCumpleanios() {
		LocalDateTime fechaActual = LocalDateTime.now();
		LocalDateTime cumple;
		if (this.getFechaNacimiento().getMonthValue()< fechaActual.getMonthValue()) {
		 cumple = LocalDateTime.of(fechaActual.getYear()+1, this.getFechaNacimiento().getMonthValue(),this.getFechaNacimiento().getDayOfMonth(),0,0, 0);
			
		}else {
		 cumple = LocalDateTime.of(fechaActual.getYear(), this.getFechaNacimiento().getMonthValue(),this.getFechaNacimiento().getDayOfMonth(),0,0, 0);	
		}
		
		
		LocalDateTime base = LocalDateTime.from(fechaActual);
		
		long anios = base.until(cumple,ChronoUnit.YEARS);
		base= base.plusYears(anios);
		long meses= base.until(cumple,ChronoUnit.MONTHS);
		base= base.plusMonths(meses);
		long dias= base.until(cumple,ChronoUnit.DAYS);
		base= base.plusDays(dias);
		long horas = base.until(cumple, ChronoUnit.HOURS);
		base= base.plusHours(horas);
		long minutos = base.until(cumple, ChronoUnit.MINUTES);
		base= base.plusMinutes(minutos);
		long segundos = base.until(cumple, ChronoUnit.SECONDS);
		
		String tiempo=dias+" dias "+meses+" meses "+anios+" años "+horas+" horas "+minutos+" minutos y "+segundos+" segundos";
		return tiempo;
	}
	
	public String pasarNombreAMayuscula() {
		String nombreMayuscula= this.nombreApellido.toUpperCase();
		return nombreMayuscula;
	}
	
	public String obtenerNroTelefono() {
			String numeroTelefono=this.codigoAreaTelefono+"-"+this.nrotelefono;
		return numeroTelefono;
	}
	
	
	@Override
	public String toString() {
		return "Cliente [tipoDocumento=" + tipoDocumento + ", nroDocumento=" + nroDocumento + ", nombreApellido="
				+ nombreApellido + ", email=" + email + ", password=" + password + ", fechaNacimiento="
				+ fechaNacimiento + ", edad=" + edad + ", codigoAreaTelefono=" + codigoAreaTelefono + ", nrotelefono="
				+ nrotelefono + ", fechaUltimaCompra=" + fechaUltimaCompra + "]";
	}
	
	
	
}
