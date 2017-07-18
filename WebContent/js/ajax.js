$(document).ready(function() {   
	
		$('#salvarTask').click(function() { 			
			var beneficio = $('#beneficio').val();			
			//Chama a URL do Servlet
			$.getJSON('/TaskListEsteban/FrontController?acao=IncluirTask',	{'task': task}, 		
				//Funcao de callback
				function(responseTxt, statusTxt, xhr) { 
					if(statusTxt == "success"){
						var beneficio = responseTxt;
						$('#tabelaTask > tbody').append('<tr><td>'+task.id+'</td><td>'+task.titulo+'</td><td><button type="button" class="btn btn-danger" value= "'+task.id+'" id="removerTask" onclick="removeTask(this)">Remover</button> <button class="btn btn-info" >Alterar</button></td></tr>');
						$('#task').val("");
					}if(statusTxt == "error"){
//						alert("Error: " + xhr.status + ": " + xhr.statusText);
					}
				});

		});	
		

		$('#corpo').on(function() { 
			$.getJSON('/TaskListEsteban/FrontController?acao=ObterTask',	 		
					//Funcao de callback
					function(responseTxt, statusTxt, xhr) { 
						if(statusTxt == "success"){
							$('#tabelaBeneficio > tbody').empty();
		                     $.each(responseTxt, function(key, value) {
		                    	 $('#tabelaTask > tbody').append('<tr><td>'+value.id+'</td><td>'+value.titulo+'</td><td><button type="button" class="btn btn-danger" value= "'+value.id+'" id="removerTask" onclick="removeTask(this)">Remover</button> <button class="btn btn-info" >Alterar</button></td></tr>');
		                    	});
	 					}if(statusTxt == "error"){
							alert("Error: " + xhr.status + ": " + xhr.statusText);
						}
					});		
			
		});
		

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


		
		$('#closeModal').click(function() { 			
			
			var table = $('#tabelaVerPergunta');

			table.find('tr').each(function(indice){
				var par = $(this).closest('tr'); //tr
				  par.remove();
				  
			});
			

		});
});	


function removeTask(handler) {
	
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

/*function removeFormulario(handler) {
	var idFormulario = $(handler).val();	
	var par = $(handler).parent().parent(); //tr
	//Chama a URL do Servlet
	$.getJSON('/SistemaAvaliacao/FrontController?acao=RemoverTipoDeFormulario',	{'idFormulario': idFormulario}, 		
		//Funcao de callback
		function(responseTxt, statusTxt, xhr) { 
			if(statusTxt == "success"){
				if(responseTxt==true){
					par.remove();
//					$this.closest('tr').remove();
				}
			}if(statusTxt == "error"){
				alert("Não é possível eliminar Formulário já respondido");
			}
			alert("Error: " + xhr.status + ": " + xhr.statusText);
		});
}*/








