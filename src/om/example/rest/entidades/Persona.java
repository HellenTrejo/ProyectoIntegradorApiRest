package om.example.rest.entidades;

public class Persona {
	private int idPersona;
	private String numDoc,numcel;

	private TipoDocumento tipoDocumento;
	private Nacionalidad nacionalidad;
	private Rol rol;
	private Estado estado;
	
	private int idtipoDocumento;
	private int idnacionalidad;
	private int idrol;
	private int idestado;
	
	

	public int getIdtipoDocumento() {
		return idtipoDocumento;
	}
	public void setIdtipoDocumento(int idtipoDocumento) {
		this.idtipoDocumento = idtipoDocumento;
	}
	public int getIdnacionalidad() {
		return idnacionalidad;
	}
	public void setIdnacionalidad(int idnacionalidad) {
		this.idnacionalidad = idnacionalidad;
	}
	public int getIdrol() {
		return idrol;
	}
	public void setIdrol(int idrol) {
		this.idrol = idrol;
	}
	public int getIdestado() {
		return idestado;
	}
	public void setIdestado(int idestado) {
		this.idestado = idestado;
	}
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
	public TipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(TipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	public Nacionalidad getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(Nacionalidad nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public Rol getRol() {
		return rol;
	}
	public void setRol(Rol rol) {
		this.rol = rol;
	}
	public Estado getEstado() {
		return estado;
	}
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	

}
