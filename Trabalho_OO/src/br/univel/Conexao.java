package br.univel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

	private Connection con;

	public Conexao() {
		conectar();		

		List<Pessoa> lista = buscarTodos();
		
		desconectar();
	}

	public void conectar() {
		String url = "jdbc:postgresql://localhost:5432/TrabalhoJava";
		String user = "postgres";
		String pass = "1234";
		try {
			con = DriverManager.getConnection(url, user, pass);
		} catch (SQLException ex) {
			Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void desconectar() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException ex) {
				Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

	}

	public void inserir(Pessoa pessoa) {
		String sql = "insert into aluno (id, nome) values (?, ?)";

		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, pessoa.getId());
			ps.setString(2, pessoa.getNome());
			ps.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void atualizar(String nome, int id) {

		String sql = "update aluno set nome = 'Juliana' where id = 11";

		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, nome);
			ps.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public void apagar(int id) {

		String sql = "delete from aluno id = 10";

		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public List<Pessoa> buscarTodos() {
		List<Pessoa> lista = new ArrayList<>();
		String sql = "select * from aluno";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Pessoa a = new Pessoa();
				a.setId(rs.getInt(1));
				a.setNome(rs.getString(2));
				lista.add(a);
			}

		} catch (SQLException ex) {
			Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return lista;
	}

	public Pessoa buscarUm(int id) {
		String sql = "select *from aluno where id = 3";

		PreparedStatement ps;

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;

	}
	
	

	public static void main(String[] args) {
		new Conexao();
	}
}
