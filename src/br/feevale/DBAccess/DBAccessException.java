package br.feevale.DBAccess;

import java.sql.SQLException;

public class DBAccessException extends SQLException {
	
	public DBAccessException( String msgErro ) {
		super( msgErro );
	}

	public DBAccessException( SQLException erro ) {
		super( erro );
	}
	
	public DBAccessException( Exception erro ) {
		super( erro );
	}
	
}