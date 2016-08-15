<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Colegiado</title>
<link href="${pageContext.request.contextPath}/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="${pageContext.request.contextPath}/font-awesome-4.6.3/css/font-awesome.min.css" rel="stylesheet">
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
			<h3><i class="fa fa-edit"></i> Cadastrar Colegiado</h3>

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

			<div class="panel panel-primary">
				<div class="panel-heading">Dados do colegiado</div>
				<div class="panel-body">

					<form action="${pageContext.request.contextPath}/controller.do" method="POST" class="form-horizontal">
						<input type="hidden" name="op" value="novcol">
						<div class="row">
							<div class="col-sm-6" class="form-group">
								<label for="descricao" class="control-label">Descrição:</label>
								<div>
									<input id="descricao" value="${colegiado.descricao}" name="descricao" type="text" class="form-control" placeholder="Texto simples para identificar o colegiado" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6" class="form-group">
								<label for="portaria" class="control-label">Portaria:</label>
								<div>
									<input id="portaria" value="${colegiado.portaria}" name="portaria" class="form-control" type="text" placeholder="Órgão do IFPB e data" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-3" class="form-group">
								<label for="dataini" class="control-label">Data início:</label>
								<fmt:formatDate var="dif" value="${colegiado.dataInicio}" pattern="dd/MM/yyyy"/>  
								<input id="dataini" value="${dif}" name="dataini" class="form-control" type="date" placeholder="dd/mm/aaaa" />
							</div>
							<div class="col-sm-3" class="form-group">
								<label for="datafim" class="control-label">Data fim:</label> 
								<fmt:formatDate var="dff" value="${colegiado.dataFim}" pattern="dd/MM/yyyy"/>
								<input id="datafim" value="${dff}" name="datafim" class="form-control" type="date" placeholder="dd/mm/aaaa" />
							</div>
						</div>

						<div class="row">
							<div class="col-sm-6" class="form-group">
									<label for="curso">Curso:</label> 
									<select class="form-control" id="curso" name="curso">
									<c:forEach var="curso" items="${utilBean.cursos}">
										<c:if test="${curso.id eq colegiado.curso.id}">
											<option value="${curso.id}" label="${curso.nome}" selected>${curso.nome}</option>
										</c:if>
										<c:if test="${curso.id ne colegiado.curso.id}">
											<option value="${curso.id}" label="${curso.nome}">${curso.nome}</option>
										</c:if>
										
									</c:forEach>
									</select>
							</div>
						</div>

						<div class="row">
							<div class="col-sm-2" class="form-group">
								<br /> <input type="submit" class="btn btn-primary" value="Criar">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
	
	<c:set var="endofconversation" value="true" scope="request"/>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>