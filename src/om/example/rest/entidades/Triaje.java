package om.example.rest.entidades;

public class Triaje {
	private int idTriaje;
	private String  respuesta;

	private Pregunta pregunta;
	private Persona persona;
	
	private int idpregunta;
	private int idpersona;
	
	
	
	public int getIdpregunta() {
		return idpregunta;
	}
	public void setIdpregunta(int idpregunta) {
		this.idpregunta = idpregunta;
	}
	public int getIdpersona() {
		return idpersona;
	}
	public void setIdpersona(int idpersona) {
		this.idpersona = idpersona;
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
