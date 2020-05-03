package om.example.rest.entidades;

public class Triaje {
	private String idTriaje, respuesta;
	private Pregunta idPregunta;
	private Persona idPersona;
	public String getIdTriaje() {
		return idTriaje;
	}
	public void setIdTriaje(String idTriaje) {
		this.idTriaje = idTriaje;
	}
	public String getRespuesta() {
		return respuesta;
	}
	public void setRespuesta(String respuesta) {
		this.respuesta = respuesta;
	}
	public Pregunta getIdPregunta() {
		return idPregunta;
	}
	public void setIdPregunta(Pregunta idPregunta) {
		this.idPregunta = idPregunta;
	}
	public Persona getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(Persona idPersona) {
		this.idPersona = idPersona;
	}
	
	

}
