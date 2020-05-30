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

import om.example.rest.entidades.Nacionalidad;

public class NacionalidadModel {
	private static final Log log= LogFactory.getLog(NacionalidadModel.class);
	
	public List<Nacionalidad> listarNacionalidad() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<Nacionalidad> lista = new ArrayList<Nacionalidad>();
		try {
			String sql = "select * from nacionalidad";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			log.info(pstm);
			rs = pstm.executeQuery();
			Nacionalidad bean = null;
			while(rs.next()){
				bean = new Nacionalidad();
				bean.setIdNacionalidad(rs.getInt(1));
				bean.setNombreNacionalidad(rs.getString(2));
				
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
