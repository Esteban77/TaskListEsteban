$(document).ready(function() {   
	
		$('#salvarTarefa').click(function() { 	
			var id =  $('#id').val();
			var titulo = $('#titulo').val();
			var data = $('#dataInicio').val();
			var descricao= $('#descricao').val();
			var status = $("input[name='status']:checked").val();
			var par = $("#alterarTarefa").parent().parent();
			//Chama a URL do Servlet
			$.getJSON('/TaskListEsteban/FrontController?acao=IncluirTask',	{'titulo': titulo,'descricao': descricao, 'dataInicio': data, "status": status, "id":id}, 		
				//Funcao de callback
				function(responseTxt, statusTxt, xhr) { 
					if(statusTxt == "success"){
						var task = responseTxt;
						if(id!=""){
	//						par.remove();
							$('#tabelaTarefa').find('tr').each(function (indexTr, valueTr) {
					            $(this).find('td').each(function (indexTd, valueTd) {
					                if (indexTd == 0) {
					                    if ($(valueTd).html() == id) {
					                        $(valueTd).parent().remove();
					                    } 
					                 }
					            });
					        });
						}						
						$('#tabelaTarefa> tbody').append('<tr><td>'+task.id+'</td><td>'+task.titulo+'</td><td>'+task.status+'</td><td><button type="button" class="btn btn-danger" value= "'+task.id+'" id="removerTarefa" onclick="removeTarefa(this)">Remover</button> <button type="button" class="btn btn-info" value= "'+task.id+'" id="alterarTarefa" onclick="editarTarefa(this)">Alterar</button></td></tr>');
						$('#id').val("");
						$('#titulo').val("");
						$('#dataInicio').val("");
						$('#descricao').val("");
					}if(statusTxt == "error"){
//						alert("Error: " + xhr.status + ": " + xhr.statusText);
					}
				});

		});	
		

		$('#minhasTarefas').click(function() { 
			$.getJSON('/TaskListEsteban/FrontController?acao=ObterTask',	 		
					//Funcao de callback
					function(responseTxt, statusTxt, xhr) { 
						if(statusTxt == "success"){
							$('#tabelaTarefa > tbody').empty();
		                     $.each(responseTxt, function(key, value) {
		                    	 $('#tabelaTarefa > tbody').append('<tr><td>'+value.id+'</td><td>'+value.titulo+'</td><td>'+value.status+'</td><td><button type="button" class="btn btn-danger" value= "'+value.id+'" id="removerTarefa" onclick="removeTarefa(this)">Remover</button> <button type="button" class="btn btn-info" value= "'+value.id+'" id="alterarTarefa" onclick="editarTarefa(this)">Alterar</button></td></tr>');
		                    	});
	 					}if(statusTxt == "error"){
							alert("Error: " + xhr.status + ": " + xhr.statusText);
						}
					});		
			
		});
		
/*		$('#alterarTarefa').click(function() { 			
			var id = this.val();
			//Chama a URL do Servlet
			$.getJSON('/TaskListEsteban/FrontController?acao=IncluirTask',	{'idTask': id}, 		
				//Funcao de callback
				function(data, statusTxt, xhr) { 
				if(statusTxt == "success"){
					 $("#titulo").val(data.titulo);
					 $("#id").val(data.id);
					 $("#descricao").val(data.descricao);
					 $("#date").val(data.date);	
					 $("#status").val(data.status);	
				}if(statusTxt == "error"){
					alert("Error: " + xhr.status + ": " + xhr.statusText);
				}
				});

		});	*/
		
		
		$('#beneficioLista').click(function() { 					
			//Chama a URL do Servlet
			$.getJSON('/SistemaAvaliacao/FrontController?acao=ObterTiposDeBeneficio',	 		
				//Funcao de callback
				function(responseTxt, statusTxt, xhr) { 
					if(statusTxt == "success"){
						$('#beneficioLista').find('option:not(:first)').remove();
	                     $.each(responseTxt, function(key, value) {
	                    	    $('#beneficioLista').append($("<option/>", {
	                    	        value: value.id,
	                    	        text: value.nome
	                    	    }));
	                    	});
 					}if(statusTxt == "error"){
						alert("Error: " + xhr.status + ": " + xhr.statusText);
					}
				});

	});			

});
		

function removeTarefa(handler) {
	
	$("#modalExcluir").modal();
	
	$('#confirmaExcluir').one("click",function() { 	
	var idTask = $(handler).val();	
	var par = $(handler).parent().parent(); //tr
	//Chama a URL do Servlet
	$.getJSON('/TaskListEsteban/FrontController?acao=RemoverTask',	{'idTask': idTask}, 		
		//Funcao de callback			
		function(responseTxt, statusTxt, xhr) { 
			if(statusTxt == "success"){
				if(responseTxt==true){
					par.remove();
//					$this.closest('tr').remove();
				}
			}if(statusTxt == "error"){
//				alert("Error: " + xhr.status + ": " + xhr.statusText);
			}
			
		});
	});
}



function editarTarefa(handler) {
	
	var idTask = $(handler).val();	
	var par = $(handler).parent().parent(); //tr
	//Chama a URL do Servlet
	$.getJSON('/TaskListEsteban/FrontController?acao=AlterarTask',	{'idTask': idTask}, 		
		//Funcao de callback			
		function(data, statusTxt, xhr) { 
			if(statusTxt == "success"){
				if(statusTxt == "success"){
					 $("#titulo").val(data.titulo);
					 $("#id").val(data.id);
					 $("#descricao").val(data.descricao);
					 $("#dataInicio").val(data.date);	
					 $("#status").val();	
				}if(statusTxt == "error"){
					alert("Error: " + xhr.status + ": " + xhr.statusText);
				}	
			}
	});
}








