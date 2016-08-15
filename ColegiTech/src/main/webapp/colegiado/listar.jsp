<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Colegiado</title>
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/font-awesome-4.6.3/css/font-awesome.min.css" rel="stylesheet">

<style type="text/css">

.table-hover tbody tr:hover td, .table-hover tbody tr:hover th {
	  background-color: beige;
	}
</style>
</head>
<body>

	<nav class="navbar navbar-default navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="/collegialis/processo/cadastrar.jsp">Cadastrar Processos</a>
				<a class="navbar-brand" href="/collegialis/processo/listar.jsp">Listar Processos</a>
				<a class="navbar-brand" href="/collegialis/colegiado/cadastrar.jsp">Cadastrar Colegiado</a>
				<a class="navbar-brand" href="/collegialis/colegiado/listar.jsp">Listar Colegiado</a>
				<a class="navbar-brand" href="/collegialis/reuniao/acompanhar.jsp">Acompanhar Reunião</a>
			</div>
		</div>
	</nav>

	<div class="container">
		<div class="main-page" style="margin-top: 70px">
			<h3><i class="fa fa-folder-open-o"></i> Colegiados cadastrados</h3>

			<!-- Mensagens de erro do formulario -->
			<c:if test="${not empty msgsErro}">
				<div style="color: red">
					<ul>
						<c:forEach var="msg" items="${msgsErro}">
							<li>${msg}</li>
						</c:forEach>
					</ul>
				</div>
			</c:if>
			
			<div style="margin-bottom:30px"></div>

			<table class="table table-bordered table-hover">
				<thead>
					<tr class="info">
						<th>Descrição</th>
						<th>Portaria</th>
						<th>Data início</th>
						<th>Data fim</th>
						<th>Curso</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="colegiado" items="${utilBean.colegiados}">
					<tr>
					<td>${colegiado.descricao}</td>
					<td>${colegiado.portaria}</td>
					<td><fmt:formatDate value="${colegiado.dataFim}" pattern="dd/MM/yyyy"/></td>
					<td><fmt:formatDate value="${colegiado.dataFim}" pattern="dd/MM/yyyy"/></td>
					<td>${colegiado.curso.nome}</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>