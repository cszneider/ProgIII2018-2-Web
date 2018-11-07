<%
	System.out.println( "End IP: " + request.getRemoteAddr() );

	String sNro = request.getParameter( "nro" );
	int nro = -1;
	long fatorial = -1;
	String msgErro = null;

	if( sNro != null ) {
		try {
			nro = Integer.parseInt( sNro );
			
			if( nro > 0 && nro < 17 ) {
				
				fatorial = 1;
				while( nro > 1 ) {
					fatorial *= nro--;
				}
			} else { 
				msgErro = "S� sei calcular o fatorial de n�meros entre 1 e 16";
			}
			
		} catch( Exception e ) {
			msgErro = String.format( "N�o consegui converter '%s' para numero", sNro );
		}
	}
%>
<html>
  <head>
    <title>C�lculo do Fatorial</title>
  </head>
  <body>
    <h2>C�lculo do Fatorial</h2>
    <hr />
    
    <form method="post">
    
    	N�mero:
    	<input type="text" name="nro" />
    	<br />
    	<input type="submit" value="Calcular" />
    </form>
    
    <% if( msgErro == null ) { %>
    
    	<h3>O fatorial de <%=sNro%> � <%=fatorial%></h3>
	<% } else { %>
		<span style="color: red;"><%=msgErro%></span>
	<% } %>    
  </body>
</html>






