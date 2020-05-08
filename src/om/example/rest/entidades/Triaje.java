package om.example.rest.entidades;

public class Triaje {
	private int idTriaje;
	private String  respuesta;
	private Pregunta Pregunta;
	private Persona Persona;
	
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
	public Pregunta getPregunta() {
		return Pregunta;
	}
	public void setPregunta(Pregunta idPregunta) {
		this.Pregunta = idPregunta;
	}
	public Persona getPersona() {
		return Persona;
	}
	public void setPersona(Persona idPersona) {
		this.Persona = idPersona;
	}
	
	

}
