package com.example.rest.servicios;

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
import com.example.rest.dao.PostModel;
import com.example.rest.dao.UserModel;

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
	
	//
	
	private EstadoModel daoEstado = new EstadoModel();
	private CifrasModel daoCifras = new CifrasModel();
	
	
	@GET
	@Path("/posts/{userId}")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response consultaPorId(@PathParam("userId") int id) {
		log.info("listarTodos rest ");
		return Response.ok(daoPost.consultaPostPorUserId(id)).build();
	}
	
	@GET
	@Path("/users")
	@Produces({ MediaType.APPLICATION_JSON })
	public Response listarTodos() {
		log.info("listarTodos rest ");
		return Response.ok(daoUser.listarTodos()).build();
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

	


	
	

}