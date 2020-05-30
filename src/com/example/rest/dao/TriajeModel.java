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
			String sql = "select t.idtriaje, p.idpregunta, t.respuesta, e.idpersona from pregunta p inner join triaje t on p.idpregunta = t.idpregunta inner join persona e on t.idpersona= e.idpersona ";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			log.info(pstm);
			rs = pstm.executeQuery();
			Triaje bean = null;
			Pregunta pre=null;
			Persona per=null;
			while(rs.next()){
				bean = new Triaje();
				pre= new Pregunta();
				per=new Persona();
				bean.setIdTriaje(rs.getInt(1));
				
				pre.setIdPregunta(rs.getInt(2));
				bean.setPregunta(pre);
				
				bean.setRespuesta(rs.getString(3));
				
				per.setIdPersona(rs.getInt(4));
				
				bean.setPersona(per);
				
				lista.add(bean);
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

	


	public int insertaTriaje(Triaje bean) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "insert into triaje values(null,?,?,?)";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, bean.getRespuesta());
			pstm.setInt(2, bean.getPregunta().getIdPregunta());
			pstm.setInt(3, bean.getPersona().getIdPersona());
	
			
			log.info(pstm);
			
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (pstm != null)pstm.close();
			} catch (SQLException e1) {}
			try {
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return salida;
	}
	

	public int actualizaTriaje(Triaje obj) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "update triaje set respuesta =?, idpregunta =?, idpersona =? where idtriaje =? ";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getRespuesta());
			pstm.setInt(2, obj.getPregunta().getIdPregunta());
			pstm.setInt(3, obj.getPersona().getIdPersona());
			pstm.setInt(4, obj.getIdTriaje());
			log.info(pstm);
			
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (pstm != null)pstm.close();
			} catch (SQLException e1) {}
			try {
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return salida;
	}
	
	public int eliminaTriaje(Triaje obj) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "delete from triaje where idtriaje =?";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, obj.getIdTriaje());
			log.info(pstm);
			salida = pstm.executeUpdate();
		} catch (Exception e) {
			log.info(e);
		} finally {
			try {
				if (pstm != null)pstm.close();
			} catch (SQLException e1) {}
			try {
				if (conn != null)conn.close();
			} catch (SQLException e) {}
		}
		return salida;
	}


	

}
