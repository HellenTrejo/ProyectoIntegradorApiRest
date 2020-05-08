package om.example.rest.entidades;

public class Triaje {
	private int idTriaje;
	private String  respuesta;

	private Pregunta pregunta;
	private Persona persona;

	
	public Triaje(int idTriaje, String respuesta, Pregunta pregunta, Persona persona) {
		super();
		this.idTriaje = idTriaje;
		this.respuesta = respuesta;
		this.pregunta = pregunta;
		this.persona = persona;
	}
	public Triaje() {
		super();
	}
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
		return pregunta;
	}
	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}
	public Persona getPersona() {
		return persona;
	}
	public void setPersona(Persona persona) {
		this.persona = persona;
	}
	
	

}
