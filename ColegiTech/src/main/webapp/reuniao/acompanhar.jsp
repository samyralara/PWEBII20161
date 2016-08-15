<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Acompanhamento de Reunião</title>
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
			<h3><i class="fa fa-edit"></i>Reunião em andamento</h3>

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

			<div class="panel panel-primary">
				<div class="panel-heading">Dados da Reunião</div>
				<div class="panel-body">

					<form action="${pageContext.request.contextPath}/controller.do" method="POST" class="form-horizontal">
						<input type="hidden" name="op" value="reuniatual">
						<div class="row">
							<div class="col-sm-6" class="form-group">
								<label for="pauta" class="control-label">Pauta:</label>
								<div>
									<ul id="propauta" id="propauta">
										<c:forEach var="propauta" items="${utilBean.getProcessosReuniao(3)}">
										 	<li><a href="/mostraproreuni.jsp">${propauta.numero}</a></li>
										</c:forEach>
									</ul>
								</div>
								<div>
								<label>Processo em apreciação:</label><br>
								<c:forEach var="processoNu" items="${utilBean.getProcessoNumero(10)}">
									<label>Numero:</label> <input type="text" name="pronum" id="pronum" value=${processoNu.numero} disabled/><br>
									<label>Requisitante:</label> <input type="text" id="pronum2" name="pronum2" value=${processoNu.requisitante.nome} disabled/> <br>
									<label>Assunto: </label><input type="text" name="assunto" id="assunto" value=${processoNu.assunto.descricao} disabled/><br>
									<label>Relator: </label><input type="text" name="relator" id="relator" value=${processoNu.relator.professor.nome} disabled/><br>
									<br>
									<label>Membros do colegiado - Votação:</label>									
								</c:forEach>
								<br>
						<div class="row">
							<div class="col-sm-6" class="form-group">
								<c:forEach var="membros" items="${utilBean.getMembrosColegiado(1)}">
									<input type="text" id="votoMembro" value=${membros.professor.nome}/>
									<select class="form-control" id="votoMembro" name="votoMembro">
										<option value="Com o relator" id="comorelator" selected>Com o relator</option>
										<option value="Divergente" id="divergente">Divergente</option>
										<option value="Ausente" id="ausente">Ausente</option>						
									</select>
								</c:forEach>
									
							</div>
						</div>
								</div>
								<label>DECISÃO:</label>
								<select name="decisao">
									<option id="deferido" name="deferido" selected>Deferido</option>
									<option id="indeferido" name="indeferido">Indeferido</option>
								</select>
								<br>
								<button>Concluir</button>
							</div>
						</div>
			</div>
		</div>
	</div>
	
	<c:set var="endofconversation" value="true" scope="request"/>

	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>