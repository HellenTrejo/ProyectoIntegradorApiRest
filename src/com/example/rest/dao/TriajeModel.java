package com.example.rest.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.example.rest.util.ConectaDB;

import om.example.rest.entidades.Persona;
import om.example.rest.entidades.Pregunta;
import om.example.rest.entidades.Triaje;

public class TriajeModel {
	
private static final Log log= LogFactory.getLog(TriajeModel.class);
	
	public List<Triaje> listarTriaje() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<Triaje> lista = new ArrayList<Triaje>();
		try {
			String sql = "select t.idtriaje, p.idpregunta,p.descripcion, t.respuesta, e.idpersona, e.numDoc,e.numcel "
					+ "from pregunta p inner join triaje t on p.idpregunta = t.idpregunta "
					+ "inner join persona e on t.idpersona= e.idpersona ";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			log.info(pstm);
			rs = pstm.executeQuery();
			Triaje beanTriaje = null;
			Pregunta beanPregunta=null;
			Persona beanPersona=null;
			while(rs.next()){
				beanTriaje = new Triaje();
				beanPregunta= new Pregunta();
				beanPersona=new Persona();
				beanTriaje.setIdTriaje(rs.getInt(1));
				beanPregunta.setIdPregunta(rs.getInt(2));
				beanPregunta.setDescripcion(rs.getString(3));
				beanTriaje.setPregunta(beanPregunta);
				beanTriaje.setRespuesta(rs.getString(4));
				beanPersona.setIdPersona(rs.getInt(5));
				beanPersona.setNumDoc(rs.getString(6));
				beanPersona.setNumcel(rs.getString(7));
				beanTriaje.setPersona(beanPersona);
				lista.add(beanTriaje);
			}
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (rs != null)rs.close();
				if (pstm != null)pstm.close();
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return lista;
	}

	

}
