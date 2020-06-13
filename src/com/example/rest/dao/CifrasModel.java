package com.example.rest.dao;

import java.sql.CallableStatement;
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
import om.example.rest.entidades.Departamento;



public class CifrasModel {
private static final Log log = LogFactory.getLog(CifrasModel.class);
	
	
	public List<Cifras> listarCifras() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<Cifras> lista = new ArrayList<Cifras>();
		try {
			String sql = "select c.idcifras, c.nuevos, c.totales, c.fallecidos, c.recuperados, c.fecha, d.iddepartamento, d.descripcion from cifras c inner join departamento d on c.iddepartamento =d.iddepartamento";
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
				Departamento obj = new Departamento();
				obj.setIdDepartamento(rs.getInt(7));
				obj.setDescripcion(rs.getString(8));
				bean.setDepartamento(obj);
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

	public List<Cifras> consultaCifrasPorFechaYDepa(String fecha, int idDepa) {
		Connection conn = null;
		CallableStatement pstm = null;
		ResultSet rs = null;
		
		List<Cifras> lista = new ArrayList<Cifras>();
		try {
			String sql = "call sp_consultaCifras(?,?)";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareCall(sql);
			pstm.setString(1, fecha);
			pstm.setInt(2, idDepa);
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
				
				Departamento obj = new Departamento();
				obj.setIdDepartamento(rs.getInt(7));
				obj.setDescripcion(rs.getString(8));
				bean.setDepartamento(obj);
				
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
	
	public int insertaCifras(Cifras obj) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "insert into cifras values(null,?,?,?,?,?,?)";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, obj.getNuevos());
			pstm.setInt(2, obj.getTotales());
			pstm.setInt(3, obj.getFallecidos());
			pstm.setInt(4, obj.getRecuperados());
			pstm.setString(5, obj.getFecha());
			pstm.setInt(6, obj.getIddepartamento());
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
	
	public int actualizaCifras(Cifras obj) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "update cifras set nuevos =?, totales =?, fallecidos =?, recuperados =?, fecha =?, iddepartamento=? where idcifras =? ";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, obj.getNuevos());
			pstm.setInt(2, obj.getTotales());
			pstm.setInt(3, obj.getFallecidos());
			pstm.setInt(4, obj.getRecuperados());
			pstm.setString(5, obj.getFecha());
			pstm.setInt(6, obj.getIddepartamento());
			pstm.setInt(7, obj.getIdCifras());
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
	
	public int eliminaCifras(Cifras obj) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "delete from cifras where idcifras =?";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, obj.getIdCifras());
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
