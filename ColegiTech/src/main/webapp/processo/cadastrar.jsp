<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cadastro de Processo</title>
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
			<h3><i class="fa fa-edit"></i> Cadastrar Processo</h3>

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
				<div class="panel-heading">Dados do Processo</div>
				<div class="panel-body">

					<form action="${pageContext.request.contextPath}/controller.do" method="POST" class="form-horizontal">
						<input type="hidden" name="op" value="novpro">
						<div class="row">
							<div class="col-sm-6" class="form-group">
								<label for="processo" class="control-label">Número:</label>
								<div>
									<input id="numero" value="${processo.numero}" name="numero" class="form-control" type="text" placeholder="Informe o nº" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6" class="form-group">
								<label for="matricula" class="control-label">Matricula:</label>
								<div>
									<input id="matricula" value="${aluno.matricula}" name="matricula" class="form-control" type="text" placeholder="Informe sua matricula" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6" class="form-group">
									<label for="processo">Assunto:</label> 
									<select class="form-control" id="assunto" name="assunto">
									<c:forEach var="assunto" items="${utilBean.assuntos}">
										<c:if test="${assunto.id eq processo.assunto.id}">
											<option value="${assunto.id}" label="${assunto.descricao}" selected>${assunto.descricao}</option>
										</c:if>
										<c:if test="${assunto.id ne processo.assunto.id}">
											<option value="${assunto.id}" label="${assunto.descricao}">${assunto.descricao}</option>
										</c:if>
										
									</c:forEach>
									</select>
							</div>
						</div>
						<div class="row">
							<div class="col-sm-6" class="form-group">
									<label for="processo">Relator:</label> 
									<select class="form-control" id="relator" name="relator">
									<c:forEach var="membro" items="${utilBean.getMembrosColegiado(1)}">
										<c:if test="${membro.professor.id eq processo.relator.id}">
											<option value="${membro.professor.id}" label="${membro.professor.nome}" selected>${membro.professor.nome}</option>
										</c:if>
										<c:if test="${membro.professor.id ne processo.relator.id}">
											<option value="${membro.professor.id}" label="${membro.professor.nome}">${membro.professor.nome}</option>
										</c:if>
										
									</c:forEach>
									</select>
							</div>
						</div>
						<label for="processo">Relato do Aluno:</label><br>
							<div><textarea id="descricaoAlu" name="descricaoAlu" placeholder="Informe o relato do aluno aqui" cols=76 rows=10></textarea>
							</div>
						<div class="row">
							<div class="col-sm-2" class="form-group">
								<br /> <input type="submit" class="btn btn-primary" value="Cadastrar">
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