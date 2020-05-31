package com.example.rest.servicios;

import javax.ws.rs.Consumes;

import javax.ws.rs.DELETE;


import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


import com.example.rest.dao.CifrasModel;
import com.example.rest.dao.EstadoModel;

import com.example.rest.dao.NacionalidadModel;
import com.example.rest.dao.PersonaModel;



import com.example.rest.dao.RolModel;
import com.example.rest.dao.TipoDocumentoModel;



import om.example.rest.entidades.Cifras;


import om.example.rest.entidades.Persona;


import com.example.rest.dao.PreguntaModel;
import com.example.rest.dao.TriajeModel;


import om.example.rest.entidades.Triaje;


//GET,POST,PUT,DELETE métodos del protocolo HTTP
	// La tecnología rest utiliza estos cuatro métodos
	// GET--->se va realiza un select
	// POST--->se va realiza un registrar
	// PUT--->se va realiza un actualizar
	// DELETE--->se va realiza un eliminar

@Path("/servicios")
public class ServicioRest {
	private static final Log log = LogFactory.getLog(ServicioRest.class);
	
	
	private PreguntaModel daoPregunta= new PreguntaModel();
	private TriajeModel daoTriaje= new TriajeModel();
	
	
	private EstadoModel daoEstado = new EstadoModel();
	private CifrasModel daoCifras = new CifrasModel();

	private NacionalidadModel daoNacionalidad = new NacionalidadModel();
	private TipoDocumentoModel daoTipoDocu = new TipoDocumentoModel();
	private RolModel daoRol = new RolModel();
	private PersonaModel daoPersona = new PersonaModel();

	
	
	
	
	@GET
	@Path("/tipodoc")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listarTipoDocumento() {
		log.info("listartipodocumento rest ");
		return Response.ok(daoTipoDocu.listarTipoDocumento()).build();
	}
	
//

	@GET
	@Path("/estados")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listarEstados() {
		log.info("listarEstados rest ");
		return Response.ok(daoEstado.listarEstados()).build();
	}
	
	@GET
	@Path("/cifras")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listarCifras() {
		log.info("listarCifras rest ");
		return Response.ok(daoCifras.listarCifras()).build();
	}

	@GET
	@Path("/cifras/{fecha}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response consultaPorFecha(@PathParam("fecha") String fecha) {
		log.info("listarTodos rest ");
		return Response.ok(daoCifras.consultaCifrasPorFecha(fecha)).build();
	}

	

	@POST
	   @Path("/cifras/add")
	   @Consumes({MediaType.APPLICATION_JSON})
	   @Produces({MediaType.APPLICATION_JSON})
		public int registrarCifras(Cifras bean) {
		return daoCifras.insertaCifras(bean);
	}
	
	@PUT
	   @Path("/cifras")
	   @Consumes({MediaType.APPLICATION_JSON})
	   @Produces({MediaType.APPLICATION_JSON})
		public int actualizarCifras(Cifras bean) {
		return daoCifras.actualizaCifras(bean);
}

	@GET
	@Path("/preguntas")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listarPeguntas() {
		log.info("listarPreguntas rest ");
		return Response.ok(daoPregunta.listarPreguntas()).build();
	}
	
	@GET
	@Path("/triajes")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listarTriaje() {
		log.info("listarTriaje rest ");
		return Response.ok(daoTriaje.listarTriaje()).build();
	}
	
	@POST
	   @Path("/triaje/add")
	   @Consumes({MediaType.APPLICATION_JSON})
	   public Response saveTriaje(Triaje data){
		log.info("saveTriaje rest ");
		return Response.ok(daoTriaje.insertaTriaje(data)).build();
	   }

	@PUT
	   @Path("/triaje{id}")
	   @Consumes({MediaType.APPLICATION_JSON})
	   @Produces({MediaType.APPLICATION_JSON})
	   public Response updateTriaje(@PathParam("id") int id, Triaje data){
		log.info("updateTriaje rest ");
		return Response.ok(daoTriaje.actualizaTriaje(data)).build();
  
	   }

	@GET
		@Path("/nacionalidad")
		@Produces({ MediaType.APPLICATION_JSON })
		public Response listarNacionalidad() {
			log.info("listarNacionalidad rest ");
			return Response.ok(daoNacionalidad.listarNacionalidad()).build();
		}
	
	@GET
	@Path("/rol")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listarRol() {
		log.info("listarRol rest ");
		return Response.ok(daoRol.listaRol()).build();
	}

	@GET
	@Path("/persona")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listarPersona() {
		log.info("listarPersona rest ");
		return Response.ok(daoPersona.listarPersona()).build();
	}
	
	@POST
	   @Path("/persona")
	   @Consumes({MediaType.APPLICATION_JSON})
	   @Produces({MediaType.APPLICATION_JSON})
		public int registrarPersona(Persona bean) {
		return daoPersona.insertaPersona(bean);
	}
	
	@PUT
	   @Path("/persona")
	   @Consumes({MediaType.APPLICATION_JSON})
	   @Produces({MediaType.APPLICATION_JSON})
		public int actualizarPersona(Persona bean) {
		return daoPersona.actualizaPersona(bean);

	}

	@DELETE
	   @Path("/cifrasD{id}")
	   @Produces({MediaType.APPLICATION_JSON})
	   public Response removeCifras(@PathParam("id") int id, Cifras data){
		log.info("removeCifras rest ");
		return Response.ok(daoCifras.eliminaCifras(data)).build();
	   }

	
	

}