package br.univel;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class BancoPostgre {

	private Connection con;

	public BancoPostgre() {
		conectar();
		 
		List<Pessoa> lista = buscarTodos();
		

		desconectar();
	}

	public void conectar() {
		String url = "jdbc:postgresql://localhost:5432/Trabalho";
		String user = "postgres";
		String pass = "1234";
		try {
			con = DriverManager.getConnection(url, user, pass);
		} catch (SQLException ex) {
			Logger.getLogger(BancoPostgre.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void desconectar() {
		if (con != null) {
			try {
				con.close();
			} catch (SQLException ex) {
				Logger.getLogger(BancoPostgre.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

	}

	public void inserir(Pessoa pessoa) {
		String sql = "insert into pessoa (id, nome) values (?, ?)";

		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, pessoa.getId());
			ps.setString(2, pessoa.getNome());
			ps.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(BancoPostgre.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public void atualizar(String nome, int id) {

		String sql = "update pessoa set nome = 'Sol' where id = 11";

		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.setString(2, nome);
			ps.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(BancoPostgre.class.getName()).log(Level.SEVERE, null, ex);
		}

	}

	public void apagar(int id) {

		String sql = "delete from pessoa id = 10";

		PreparedStatement ps;
		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();

		} catch (SQLException ex) {
			Logger.getLogger(BancoPostgre.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	public List<Pessoa> buscarTodos() {
		List<Pessoa> lista = new ArrayList<>();
		String sql = "select * from pessoa";
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
			Logger.getLogger(BancoPostgre.class.getName()).log(Level.SEVERE, null, ex);
		}
		return lista;
	}

	public Pessoa buscarUm(int id) {
		String sql = "select *from pessoa where id = 3";

		PreparedStatement ps;

		try {
			ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(BancoPostgre.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;

	}

	public static void main(String[] args) {
		new BancoPostgre();
	}
}

