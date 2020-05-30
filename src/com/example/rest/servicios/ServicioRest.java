package com.example.rest.servicios;

import javax.ws.rs.Consumes;
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

import com.example.rest.dao.NacionalidadModel;
import com.example.rest.dao.PersonaModel;
import com.example.rest.dao.PostModel;
import com.example.rest.dao.RolModel;
import com.example.rest.dao.TipoDocumentoModel;
import com.example.rest.dao.UserModel;

import om.example.rest.entidades.Persona;

//GET,POST,PUT,DELETE métodos del protocolo HTTP
	// La tecnología rest utiliza estos cuatro métodos
	// GET--->se va realiza un select
	// POST--->se va realiza un registrar
	// PUT--->se va realiza un actualizar
	// DELETE--->se va realiza un eliminar

@Path("/servicios")
public class ServicioRest {
	private static final Log log = LogFactory.getLog(ServicioRest.class);
	private PostModel daoPost = new PostModel();
	private UserModel daoUser = new UserModel();
	
	private NacionalidadModel daoNacionalidad = new NacionalidadModel();
	private TipoDocumentoModel daoTipoDocu = new TipoDocumentoModel();
	private RolModel daoRol = new RolModel();
	private PersonaModel daoPersona = new PersonaModel();
	
	
	@GET
	@Path("/posts/{userId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response consultaPorId(@PathParam("userId") int id) {
		log.info("listarTodos rest ");
		return Response.ok(daoPost.consultaPostPorUserId(id)).build();
	}
	
	@GET
	@Path("/tipodoc")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listarTipoDocumento() {
		log.info("listartipodocumento rest ");
		return Response.ok(daoTipoDocu.listarTipoDocumento()).build();
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
	   @Path("/persona/add")
	   @Consumes(MediaType.APPLICATION_JSON)
	   @Produces(MediaType.APPLICATION_JSON)
		public int registrarPersona(Persona bean) {
		return daoPersona.insertaPersona(bean);
	}
	
	@PUT
	   @Path("/persona")
	   @Consumes(MediaType.APPLICATION_JSON)
	   @Produces(MediaType.APPLICATION_JSON)
		public int actualizarPersona(Persona bean) {
		return daoPersona.actualizaPersona(bean);
	}



}