package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public void insert(Cliente cli) {
		PreparedStatement st = null;
		try {
			st = conn.prepareStatement(
					"INSERT INTO cliente "
					+ "(nome,sobrenome)"
					+ "VALUES"
					+ "(?,?)");
			
			st.setString(1, cli.getNome());
			st.setString(2, cli.getSobrenome());
			st.setInt(3, cli.getEndereco().getId());
			
			int rowsAffected = st.executeUpdate(null);
			
			if (rowsAffected > 0) {
				ResultSet rs = st.getGeneratedKeys();
				if (rs.next()) {
					int id = rs.getInt(1);
					cli.setId(id);
				}
				DB.closeResultSet(rs);
			}
		else { throw new DbException("Unexpected error");
			}
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			
		}
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
				Endereco end = instantiateEndereco(rs);
				Cliente cli = instantiateCliente(rs, end);
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
	public List<Cliente> findByEndereco(Endereco endereco) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st =  conn.prepareStatement(				
					"SELECT cliente.*, endereco.rua as EndRua "
					+ "FROM cliente INNER JOIN endereco "
					+ "ON cliente.id_cliente = endereco.id_cliente "
					+ "WHERE id_endereco = ? "
					+ "ORDER BY Nome;");
			
			
			st.setInt(1, endereco.getId());
			rs = st.executeQuery();
			
			List<Cliente> list = new ArrayList<>();
			Map<Integer, Endereco> map = new HashMap<>();
			 
 			while (rs.next()) {
 				Endereco end = map.get(rs.getInt("id_endereco"));
 				
 				if (end == null) { 				
 				end = instantiateEndereco(rs);
				map.put(rs.getInt("id_endereco"), end);
 				}
				
				
				Cliente cli = instantiateCliente(rs, end);
				list.add(cli);
			}
			return list;
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
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st =  conn.prepareStatement(				
					"SELECT cliente.*, endereco.rua as EndRua "
					+ "FROM cliente INNER JOIN endereco "
					+ "ON cliente.id_cliente = endereco.id_cliente "
					+ "ORDER BY Nome;");
			
			
		
			rs = st.executeQuery();
			
			List<Cliente> list = new ArrayList<>();
			Map<Integer, Endereco> map = new HashMap<>();
			 
 			while (rs.next()) {
 				Endereco end = map.get(rs.getInt("id_endereco"));
 				
 				if (end == null) { 				
 				end = instantiateEndereco(rs);
				map.put(rs.getInt("id_endereco"), end);
 				}
				
				
				Cliente cli = instantiateCliente(rs, end);
				list.add(cli);
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
	
	
	private Cliente instantiateCliente(ResultSet rs, Endereco end) throws SQLException {
		Cliente cli = new Cliente();
		cli.setId(rs.getInt("id_cliente"));
		cli.setNome(rs.getString("nome"));
		cli.setSobrenome(rs.getString("sobrenome"));
		cli.setEndereco(end); 
		return cli;
	}



	private Endereco instantiateEndereco(ResultSet rs) throws SQLException {
		Endereco end = new Endereco();
		end.setId(rs.getInt("id_cliente"));
		end.setRua(rs.getString("EndRua"));
		
		return end;
	}


}
