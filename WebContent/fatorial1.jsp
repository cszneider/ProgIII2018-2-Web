<%@page import="br.feevale.db.Usuario"%>
<%@page import="br.feevale.utils.Fatorial"%>
<%
	Usuario usuario = (Usuario) session.getAttribute( "usuario" );

	if( usuario == null ) {
		response.sendRedirect( "./index.jsp" );
		return;
	}

	System.out.println( "End IP: " + request.getRemoteAddr() );

	String sNro = request.getParameter( "nro" );
	String msgErro = null;
	Fatorial fatorial = null;

	if( sNro != null ) {
		try {
			int nro = Integer.parseInt( sNro );
			fatorial = new Fatorial( nro );
			msgErro = fatorial.getMsgErro();
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
    <h4>Bem vindo <%=usuario.getDsNome()%></h4>
    <hr />
    
    <form method="post">
    
    	N�mero:
    	<input type="text" name="nro" />
    	<br />
    	<input type="submit" value="Calcular" />
    </form>
    
    <% if( msgErro == null && fatorial != null ) { %>
    
    	<h3>O fatorial de <%=sNro%> � <%=fatorial%></h3>
	<% } else { %>
		<span style="color: red;"><%=msgErro%></span>
	<% } %>    
  </body>
</html>






