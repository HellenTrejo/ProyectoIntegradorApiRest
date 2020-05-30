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
import om.example.rest.entidades.Rol;

public class RolModel {
	private static final Log log= LogFactory.getLog(RolModel.class);
	
	public List<Rol> listaRol() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<Rol> lista = new ArrayList<Rol>();
		try {
			String sql = "select * from rol";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			log.info(pstm);
			rs = pstm.executeQuery();
			Rol bean = null;
			while(rs.next()){
				bean = new Rol();
				bean.setIdRol(rs.getInt(1));
				bean.setNombreRol(rs.getString(2));
				
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
