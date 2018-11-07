<%@page import="br.feevale.db.UsuarioDAO"%>
<%@page import="br.feevale.db.Usuario"%>
<%

	String email = request.getParameter( "email" );
	String senha = request.getParameter( "senha" );
	String msgErro = null;
	
	String nomeUsuario = null;
	
	if( email != null && senha != null ) {
		
		Usuario usuario = UsuarioDAO.getUsuario( email );
		
		if( usuario != null ) {
			
			if( usuario.getDsSenha().equals( senha ) ) {
				
				response.sendRedirect( "./fatorial1.jsp" );

				session.setAttribute( "usuario", usuario );
				session.setMaxInactiveInterval( 120 );

				return;
			} else {
				msgErro = "usuário ou senha inválida";
			}
		} else {
			msgErro = "usuário ou senha inválida";
		}
	}
%>
<html>
  <head>
    <title>Sistema Prog III</title>
  </head>
  <body>
    <h1>Feevale Prog III</h1>
    <hr />
    
    <form method="post">
      EMail:  <input type="text" name="email" /><br />
      Senha: <input type="password" name="senha">
      
      <br /><br />
      <input type="submit" value="Login" />
      
      <% if( msgErro == null ) 
      		if( nomeUsuario != null ) {
      { %>
      
      	<h2> Bem vindo <%=nomeUsuario%></h2>
      <% } } else { %>	
      	<h2> <%=msgErro%></h2>
      <% } %>	
    </form>
  </body>
</html>