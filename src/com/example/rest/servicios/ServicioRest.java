package com.example.rest.servicios;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
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

import com.example.rest.dao.PostModel;
import com.example.rest.dao.PreguntaModel;
import com.example.rest.dao.TriajeModel;
import com.example.rest.dao.UserModel;

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
	private PostModel daoPost = new PostModel();
	private UserModel daoUser = new UserModel();
	private PreguntaModel daoPregunta= new PreguntaModel();
	private TriajeModel daoTriaje= new TriajeModel();
	
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
	   @Consumes(MediaType.APPLICATION_JSON)
	   public Response saveTriaje(Triaje data){
		log.info("saveTriaje rest ");
		return Response.ok(daoTriaje.insertaTriaje(data)).build();
	   }

	@PUT
	   @Path("/triaje{id}")
	   @Consumes(MediaType.APPLICATION_JSON)
	   @Produces(MediaType.APPLICATION_JSON)
	   public Response updateTriaje(@PathParam("id") int id, Triaje data){
		log.info("updateTriaje rest ");
		return Response.ok(daoTriaje.actualizaTriaje(data)).build();
  
	   }





}