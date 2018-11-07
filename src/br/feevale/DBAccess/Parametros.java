package br.feevale.DBAccess;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class Parametros {

	private Properties parametros;
	
	// 3) Criar uma variável estática do tipo do objeto singleton
	//    em questão para fazer o apontamento ao objeto único criado.
	private static Parametros referencia;
	
	// 1) Criar um construtor private
	private Parametros() {
		carregaParametros();
	}

	// 2) Criar um método publico estático que devolve
	//    uma instância do objeto singleton em questão
	public static Parametros getInstance() {
		
		if( referencia == null ) {
			referencia = new Parametros();
		}
		
		return referencia;
	}
	
	
	public void inicializaComValoresDefault() throws IOException {
		
		parametros = new Properties();
		
		parametros.setProperty( "driverJdbc", "org.postgresql.Driver" );
		parametros.setProperty( "urlBanco", "jdbc:postgresq://localhost:5432/PgIII" );
		parametros.setProperty( "nomeUsuario", "postgres" );
		parametros.setProperty( "senha", "masterkey" );
		
		parametros.setProperty( "cnpj", "00111222000133" );
		parametros.setProperty( "razaoSocial", "Schneider & CO incorporadora Ltda" );
		
		FileOutputStream arquivo = new FileOutputStream( "/Users/carlos/projetos/Feevale/workspace/InterfacesSwing/Parametros.xml" );
		
		try {
			parametros.storeToXML( arquivo, "Arquivo de Parametros do Sistema" );
		} finally {
			arquivo.close();
		}
	}

	private void carregaParametros() {

		try {
			FileInputStream arquivo = new FileInputStream( "/Users/carlos/projetos/Feevale/workspace/InterfacesSwing/Parametros.xml" );
			
			parametros = new Properties();
			parametros.loadFromXML( arquivo );
		} catch (IOException e) {
			System.out.println( "Problemas ao carregar o arquivo de parâmetros" );
		}
	}

	public String getParametro( String chave ) {
		return parametros.getProperty( chave );
	}
}










