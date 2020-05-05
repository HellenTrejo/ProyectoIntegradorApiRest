package om.example.rest.entidades;

public class Triaje {
	private int idTriaje;
	private String  respuesta;
	private Pregunta idPregunta;
	private Persona idPersona;
	public int getIdTriaje() {
		return idTriaje;
	}
	public void setIdTriaje(int idTriaje) {
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
