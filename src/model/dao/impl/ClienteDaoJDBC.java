package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.ClienteDao;
import model.entities.Cliente;
import model.entities.Endereco;

public class ClienteDaoJDBC implements ClienteDao {

		
	private Connection conn;
	
	public ClienteDaoJDBC(Connection conn){
		this.conn = conn;
	}
	
	
	
	
	@Override
	public void insert(Cliente obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Cliente obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Cliente findById(int id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st =  conn.prepareStatement(				
			"SELECT cliente.*, endereco.rua as EndRua "
			+"FROM cliente INNER JOIN endereco "
			+"ON cliente.id_cliente = endereco.id_cliente "
			+"WHERE cliente.id_cliente = ?");
			
			
			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
				Endereco end = new Endereco();
				end.setId(rs.getInt("id_cliente"));
				end.setRua(rs.getString("EndRua"));
				
				Cliente cli = new Cliente();
				cli.setId(rs.getInt("id_cliente"));
				cli.setNome(rs.getString("nome"));
				cli.setSobrenome(rs.getString("sobrenome"));
				cli.setEndereco(end);
				return cli;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}			
	}

	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
