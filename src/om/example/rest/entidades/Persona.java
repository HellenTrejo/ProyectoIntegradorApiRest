package om.example.rest.entidades;

public class Persona {
	private int idPersona;
	private String numDoc,numcel;
	private TipoDocumento idTipoDocumento;
	private Nacionalidad idNacionalidad;
	private Rol idRol;
	private Estado idEstado;
	public int getIdPersona() {
		return idPersona;
	}
	public void setIdPersona(int idPersona) {
		this.idPersona = idPersona;
	}
	public String getNumDoc() {
		return numDoc;
	}
	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}
	public String getNumcel() {
		return numcel;
	}
	public void setNumcel(String numcel) {
		this.numcel = numcel;
	}
	public TipoDocumento getIdTipoDocumento() {
		return idTipoDocumento;
	}
	public void setIdTipoDocumento(TipoDocumento idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}
	public Nacionalidad getIdNacionalidad() {
		return idNacionalidad;
	}
	public void setIdNacionalidad(Nacionalidad idNacionalidad) {
		this.idNacionalidad = idNacionalidad;
	}
	public Rol getIdRol() {
		return idRol;
	}
	public void setIdRol(Rol idRol) {
		this.idRol = idRol;
	}
	public Estado getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(Estado idEstado) {
		this.idEstado = idEstado;
	}
	
	
	

}
