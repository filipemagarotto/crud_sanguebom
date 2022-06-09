package br.com.projeto_sanguebom.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.projeto_sanguebom.model.Doador;

public class doadorDAO {

	Connection con = Conexao.conectar();
	
	public void cadastrar(Doador doador) {
		
		if(doador != null && doador.getId() != 0) {

			String sql = "UPDATE doador SET nome = ?, cpf = ?, email = ?, uf = ?, data_nascimento = ?, telefone = ?, "
					+ "cidade = ?, tipo_sanguineo = ?, data_ultima_modificacao = ?, data_criacao = ? WHERE Id = ?";
			
			try {
				PreparedStatement preparador = con.prepareStatement(sql);
				
				preparador.setString(1, doador.getNome());
				preparador.setString(2, doador.getCpf());
				preparador.setString(3, doador.getEmail());
				preparador.setString(4, doador.getUf());
				preparador.setString(5, doador.getDataNascimento());
				preparador.setString(6, doador.getTelefone());
				preparador.setString(7, doador.getCidade());
				preparador.setString(8, doador.getTipo_sanguineo());
				preparador.setString(9, doador.getDataUltimaModificacao());
				preparador.setString(10, doador.getDataCriacao());
				preparador.setInt(11, doador.getId());
				
				preparador.execute();
				
				System.out.println(doador.getNome()+" Inserido com sucesso.");
				preparador.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("O erro foi: " + e);
			}
		} else {
			
			String sql = "INSERT INTO doador(nome, cpf, email, uf, data_nascimento, telefone, cidade, tipo_sanguineo, data_ultima_modificacao, data_criacao) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			try {
				PreparedStatement preparador = con.prepareStatement(sql);
				
				preparador.setString(1, doador.getNome());
				preparador.setString(2, doador.getCpf());
				preparador.setString(3, doador.getEmail());
				preparador.setString(4, doador.getUf());
				preparador.setString(5, doador.getDataNascimento());
				preparador.setString(6, doador.getTelefone());
				preparador.setString(7, doador.getCidade());
				preparador.setString(8, doador.getTipo_sanguineo());
				preparador.setString(9, doador.getDataUltimaModificacao());
				preparador.setString(10, doador.getDataCriacao());
				
				preparador.execute();
				
				System.out.println(doador.getNome()+" Inserido com sucesso.");
				preparador.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("O erro foi: " + e);
			}
		}
		
	}
	
	public List<Doador> buscarDoadores(String cpf) {
		System.out.println("cpf: " + cpf);
		if(cpf == null || cpf.equals("")) {
			String sql = "SELECT * FROM doador";
			
			PreparedStatement preparador;
			List<Doador> listaDoadores = new ArrayList<Doador>();
			
			try {
				preparador = con.prepareStatement(sql);
				ResultSet resultado = preparador.executeQuery();
				
				while(resultado.next()) {
					Doador doador = new Doador();
					doador.setId(resultado.getInt("id"));
					doador.setNome(resultado.getString("nome"));
					doador.setCpf(resultado.getString("cpf"));
					doador.setEmail(resultado.getString("email"));
					doador.setUf(resultado.getString("uf"));
					doador.setDataNascimento(resultado.getString("data_nascimento"));
					doador.setTelefone(resultado.getString("telefone"));
					doador.setCidade(resultado.getString("cidade"));
					doador.setTipo_sanguineo(resultado.getString("tipo_sanguineo"));
					doador.setDataUltimaModificacao(resultado.getString("data_ultima_modificacao"));
					doador.setDataCriacao(resultado.getString("data_criacao"));
					
					listaDoadores.add(doador);
				}
				preparador.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return listaDoadores;
		} else {
			String sql = "SELECT * FROM doador WHERE cpf = ?";
			
			PreparedStatement preparador;
			List<Doador> listaDoadores = new ArrayList<Doador>();
			
			try {
				preparador = con.prepareStatement(sql);
				preparador.setString(1, cpf);
				ResultSet resultado = preparador.executeQuery();
				
				while(resultado.next()) {
					Doador doador = new Doador();
					doador.setId(resultado.getInt("id"));
					doador.setNome(resultado.getString("nome"));
					doador.setCpf(resultado.getString("cpf"));
					doador.setEmail(resultado.getString("email"));
					doador.setUf(resultado.getString("uf"));
					doador.setDataNascimento(resultado.getString("data_nascimento"));
					doador.setTelefone(resultado.getString("telefone"));
					doador.setCidade(resultado.getString("cidade"));
					doador.setTipo_sanguineo(resultado.getString("tipo_sanguineo"));
					doador.setDataUltimaModificacao(resultado.getString("data_ultima_modificacao"));
					doador.setDataCriacao(resultado.getString("data_criacao"));
					
					listaDoadores.add(doador);
				}
				preparador.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			return listaDoadores;
		}
		
	}
	
	public void deletarDoador(Doador doador) {
		String sql = "DELETE FROM doador WHERE Id = ?";
		
		try {
			PreparedStatement preparador = con.prepareStatement(sql);
			
			preparador.setInt(1, doador.getId());
			preparador.execute();
			
			System.out.println(doador.getNome()+" Deletado com sucesso");
			preparador.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("O erro foi: " + e);
		}
	}
	
	public Doador buscarPorId(int id) {
		String sql = "SELECT * FROM doador WHERE id = ?";
		
		PreparedStatement preparador;
		Doador doador = new Doador();
		
		try {
			preparador = con.prepareStatement(sql);
			preparador.setInt(1, id);
			ResultSet resultado = preparador.executeQuery();
			
			while(resultado.next()) {
				doador.setId(resultado.getInt("id"));
				doador.setNome(resultado.getString("nome"));
				doador.setCpf(resultado.getString("cpf"));
				doador.setEmail(resultado.getString("email"));
				doador.setUf(resultado.getString("uf"));
				doador.setDataNascimento(resultado.getString("data_nascimento"));
				doador.setTelefone(resultado.getString("telefone"));
				doador.setCidade(resultado.getString("cidade"));
				doador.setTipo_sanguineo(resultado.getString("tipo_sanguineo"));
				doador.setDataUltimaModificacao(resultado.getString("data_ultima_modificacao"));
				doador.setDataCriacao(resultado.getString("data_criacao"));
			}
			preparador.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return doador;
	}
}
	
