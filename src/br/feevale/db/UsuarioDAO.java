package br.feevale.db;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.feevale.DBAccess.Conexao;
import br.feevale.DBAccess.DBAccessException;

public class UsuarioDAO {
	
	public static Usuario getUsuario( String dsEmail ) throws DBAccessException {
		
		String cmd = "select * from usuarios where dsEmail = ?";
		
		Conexao cnx = new Conexao();
		
		try {
			
			PreparedStatement ps = cnx.prepareStatement( cmd );
			try {
				ps.setString( 1, dsEmail );
				
				ResultSet rs = ps.executeQuery();
				
				if( rs.next() ) {
					
					Usuario usu = new Usuario();
					usu.setIdUsuario( rs.getInt( "idUsuario" ) );
					usu.setDsNome( rs.getString( "dsNome" ) );
					usu.setDsEmail( rs.getString( "dsEmail" ) );
					usu.setDsSenha( rs.getString( "dsSenha" ) );
					
					return usu;
				} else {
					return null;
				}
				
			} catch (SQLException e) {
				throw new DBAccessException( e );
			}
		} finally {
			cnx.close();
		}
	}
	
	
	
}





