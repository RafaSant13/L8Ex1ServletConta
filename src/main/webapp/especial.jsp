<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Conta Especial</title>
</head>
<body>
	<jsp:include page="menu.jsp" />
	
	<br />
	<br />
	
	<div align="center">
		<form action="especial" method="post">
			<p class = "title"><b>Cadastro de Pessoas</b></p>
			<table>
				<tr>
					<td>
						<input type = "text" id="valorDeposito" 
						name="valorDeposito" placeholder="Valor do Depósito">
						<button id="deposito" value="Deposito" 
						name="btn">Depositar</button>
					</td>
					
				</tr>
				<tr>
					<td>
						<input type = "text" id="valorSaque" 
						name="valorSaque" placeholder="Valor do Saque">
						<button id="saque" value="Saque" 
						name="btn">Sacar</button>
					</td>
				</tr>
				<tr>
					<td>
						<button id="dados" value="Dados" 
						name="btn">Dados do Cliente</button>
					</td>
				</tr>
			</table>
		</form>
	</div>

	<br>
	<br>
	
	<c:if test="${not empty saida}">
		<div align="center">
			<h1><c:out value="${saida}"/></h1>
		</div>
	</c:if>
</body>
</html>