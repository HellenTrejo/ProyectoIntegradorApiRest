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

import om.example.rest.entidades.Cifras;


public class CifrasModel {
private static final Log log = LogFactory.getLog(CifrasModel.class);
	
	
	public List<Cifras> listarCifras() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<Cifras> lista = new ArrayList<Cifras>();
		try {
			String sql = "select * from cifras";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			log.info(pstm);
			rs = pstm.executeQuery();
			Cifras bean = null;
			while(rs.next()){
				bean = new Cifras();
				bean.setIdCifras(rs.getInt(1));
				bean.setNuevos(rs.getInt(2));
				bean.setTotales(rs.getInt(3));
				bean.setFallecidos(rs.getInt(4));
				bean.setRecuperados(rs.getInt(5));
				bean.setFecha(rs.getString(6));
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

	public List<Cifras> consultaCifrasPorFecha(String fecha) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<Cifras> lista = new ArrayList<Cifras>();
		try {
			String sql = "select * from cifras where fecha = ?";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, fecha);
			log.info(pstm);
			rs = pstm.executeQuery();
			Cifras bean = null;
			while(rs.next()){
				bean = new Cifras();
				bean.setIdCifras(rs.getInt(1));
				bean.setNuevos(rs.getInt(2));
				bean.setTotales(rs.getInt(3));
				bean.setFallecidos(rs.getInt(4));
				bean.setRecuperados(rs.getInt(5));
				bean.setFecha(rs.getString(6));
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
