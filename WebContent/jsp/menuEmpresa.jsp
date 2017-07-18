<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous">
<link rel="stylesheet" href="/SistemaAvaliacao/css/estilos.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="Chart.min.js"></script>
<script src="../js/ajax.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Menu Empresa</title>
</head>

<nav class="navbar navbar-inverse  navbar-fixed-top">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">Sap</a>
			</div>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/SistemaAvaliacao/LogOut" data-toggle="modal">Sair <span
						class="glyphicon glyphicon-log-out"></span></a></li>
			</ul>
		</div>
	</nav>	
	
<body id="corpo" style="margin-top:50px">
			<div id="minhasTask" class="tab-pane fade container">
				<h3>Tarefas</h3>
				<p>Escreva a tarefa a realizar</p>
						
						<form class="form-horizontal" id="formularioPergunta">
							<div class="form-group">
									<label for="task" class="col-sm-2 control-label">Task</label>
									<div class="col-sm-8">
										<input class="form-control" type="text" name="task"
										id="task" placeholder="Digite o nome da tarefa a realizar">
									</div>
								<button type="button" class="btn btn-success" value="salvar" id="salvarTask">Salvar</button>
							</div>
							<hr>
							<br><br>
					<div class="row">
							<table class="table table-bordered" id="tabelaTask">
								<thead>
									<th>ID</th>
									<th>Titulo da Tarefa</th>
									<th> </th>									
								</thead>
								<tbody> 

 								</tbody> 
							</table>
					</div>
						</form>	
			</div>
		</div>

			<!-- Modal Confirma Excluir-->
			  <div class="modal fade" id="modalExcluir" role="dialog">
			    <div class="modal-dialog modal-sm">
			      <div class="modal-content">
			        <div class="modal-header">
			          <button type="button" class="close" data-dismiss="modal">&times;</button>
			          
			        </div>
			        <div class="modal-body">
			          <p>Deseja excluir?</p>
			        </div>
			        <div class="modal-footer">
			          <button type="button" id="confirmaExcluir" class="btn btn-danger" data-dismiss="modal">Sim</button>
			          <button type="button" class="btn btn-default" data-dismiss="modal">Não</button>
			        </div>
			      </div>
			    </div>
			  </div>
			  
	</div>
</body>
</html>