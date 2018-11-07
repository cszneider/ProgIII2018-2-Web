package br.feevale.DBAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

// classes Wrapper
public class Conexao {
	
	private Connection cnx;
	private boolean livre;
	
	public Conexao() throws DBAccessException {

		this.livre = true;
		Parametros prm = Parametros.getInstance();
		
		String driverJDBC = prm.getParametro( "driverJdbc" );
		String urlBanco = prm.getParametro( "urlBanco" );
		String nomeUsuario = prm.getParametro( "nomeUsuario" );
		String senha = prm.getParametro( "senha" );

		try {
			
			Class.forName( driverJDBC );
			System.out.println( "Driver importado!" );
			
			cnx = DriverManager.getConnection( 
					urlBanco, 
					nomeUsuario, 
					senha );
			
			System.out.println( "Conexão estabelecida!" );
		} catch( ClassNotFoundException e ) {
			throw new DBAccessException( e );
		} catch( SQLException e ) {
			throw new DBAccessException( e );
		}
		
	}
	
	public Statement createStatement() throws DBAccessException {
		
		try {
			return cnx.createStatement();
		} catch ( SQLException e )  {
			throw new DBAccessException( e );
		}
	}
	
	public PreparedStatement prepareStatement( String cmd ) throws DBAccessException {
		
		try {
			return cnx.prepareStatement( cmd );
		} catch ( SQLException e )  {
			throw new DBAccessException( e );
		}
	}
	
	public Connection getConnection() {
		return cnx;
	}
	
	public void reserva() throws DBAccessException {
		
		if( livre ) {
			livre = false;
		} else {
			throw new DBAccessException( "Esta conexão já está em uso" );
		}
	}
	
	public void libera() {
		livre = true;
	}
	
	public boolean isLivre() {
		return livre;
	}
	
	public void close() throws DBAccessException {
		try {
			cnx.close();
		} catch (SQLException e) {
			throw new DBAccessException( e );
		}
	}
}




