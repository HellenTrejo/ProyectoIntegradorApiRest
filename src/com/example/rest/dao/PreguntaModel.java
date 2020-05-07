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

import om.example.rest.entidades.Pregunta;

public class PreguntaModel {
	
	private static final Log log= LogFactory.getLog(PreguntaModel.class);
	
	public List<Pregunta> listarPreguntas() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<Pregunta> lista = new ArrayList<Pregunta>();
		try {
			String sql = "select * from pregunta";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			log.info(pstm);
			rs = pstm.executeQuery();
			Pregunta bean = null;
			while(rs.next()){
				bean = new Pregunta();
				bean.setIdPregunta(rs.getInt(1));
				bean.setDescripcion(rs.getString(2));
				
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

	

}



