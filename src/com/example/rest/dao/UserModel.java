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

import om.example.rest.entidades.User;

public class UserModel {

	private static final Log log = LogFactory.getLog(UserModel.class);
	
	
	public List<User> listarTodos() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<User> lista = new ArrayList<User>();
		try {
			String sql = "select * from user";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			log.info(pstm);
			rs = pstm.executeQuery();
			User bean = null;
			while(rs.next()){
				bean = new User();
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setPhone(rs.getString(4));
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

	
	public int insertaUser(User obj) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "insert into user values(null,?,?,?)";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getName());
			pstm.setString(2, obj.getEmail());
			pstm.setString(3, obj.getPhone());
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

	
	public int actualizaUser(User obj) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "update user set nombre =?, email =?, phone =? where userId =? ";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getName());
			pstm.setString(2, obj.getEmail());
			pstm.setString(3, obj.getPhone());
			pstm.setInt(4, obj.getId());
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

	
	public List<User> consultaUserPorId(int id) {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<User> lista = new ArrayList<User>();
		try {
			String sql = "select * from user where id = ?";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, id);
			log.info(pstm);
			rs = pstm.executeQuery();
			User bean = null;
			while(rs.next()){
				bean = new User();
				bean.setId(rs.getInt(1));
				bean.setName(rs.getString(2));
				bean.setEmail(rs.getString(3));
				bean.setPhone(rs.getString(4));
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
	
	public int eliminaUser(User obj) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "delete from user where userId =?";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, obj.getId());
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
