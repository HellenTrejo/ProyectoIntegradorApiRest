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

import om.example.rest.entidades.Estado;
import om.example.rest.entidades.Nacionalidad;
import om.example.rest.entidades.Persona;
import om.example.rest.entidades.Rol;
import om.example.rest.entidades.TipoDocumento;

public class PersonaModel {

	private static final Log log = LogFactory.getLog(PersonaModel.class);
	
	
	public List<Persona> listarPersona() {
		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<Persona> lista = new ArrayList<Persona>();
		try {
			String sql = "SELECT p.idpersona,p.numDoc,p.numCel,t.idtipo_documento, t.descripcion,n.idnacionalidad,n.nombreNacionalidad, r.idRol, r.nombreRol, e.idestado, e.descripcion  FROM persona p inner join tipo_documento t on p.idtipoDocumento = t.idtipo_documento inner join nacionalidad n  on p.idnacionalidad =n.idnacionalidad inner join rol r on p.idrol = r.idRol inner join estado e";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			log.info(pstm);
			rs = pstm.executeQuery();
			Persona bean = null;
			while(rs.next()){
				bean = new Persona();
				bean.setIdPersona(rs.getInt(1));
				bean.setNumDoc(rs.getString(2));
				bean.setNumcel(rs.getString(3));
				
				TipoDocumento obj = new TipoDocumento();
				obj.setIdTipoDocumento(rs.getInt(4));
				obj.setDescripcion(rs.getString(5));
				bean.setTipoDocumento(obj);
				
				Nacionalidad obj2=new Nacionalidad();
				obj2.setIdNacionalidad(rs.getInt(6));
				obj2.setNombreNacionalidad(rs.getString(7));
				bean.setNacionalidad(obj2);
				
				Rol obj3=new Rol();
				obj3.setIdRol(rs.getInt(8));
				obj3.setNombreRol(rs.getString(9));
				bean.setRol(obj3);
				
				Estado obj4=new Estado();
				obj4.setIdEstado(rs.getInt(10));
				obj4.setDescripcion(rs.getString(11));
				bean.setEstado(obj4);
				
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

	
	
	
	public int insertaPersona(Persona obj) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "insert into persona values(null,?,?,?,?,?,?)";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getNumDoc());
			pstm.setString(2, obj.getNumcel());
			pstm.setInt(3, obj.getTipoDocumento().getIdTipoDocumento());
			pstm.setInt(4, obj.getNacionalidad().getIdNacionalidad());
			pstm.setInt(5, obj.getRol().getIdRol());
			pstm.setInt(6, obj.getEstado().getIdEstado());
			
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

	
	public int actualizaPersona(Persona obj) {
		Connection conn = null;
		PreparedStatement pstm = null;
		int salida = -1;
		try {
			String sql = "update persona set numDoc =?, numCel =?, idtipoDocumento =?, idnacionalidad =?, idrol =?, idestado =? where idpersona =? ";
			conn = new ConectaDB().getAcceso();
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, obj.getNumDoc());
			pstm.setString(2, obj.getNumcel());
			pstm.setInt(3, obj.getTipoDocumento().getIdTipoDocumento());
			pstm.setInt(4, obj.getNacionalidad().getIdNacionalidad());
			pstm.setInt(5, obj.getRol().getIdRol());
			pstm.setInt(6, obj.getEstado().getIdEstado());
			pstm.setInt(7, obj.getIdPersona());
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
