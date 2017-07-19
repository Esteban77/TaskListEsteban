package negocio;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.json.JSONObject;

import dao.HibernateUtil;
import dao.TaskDaoImpl;
import entidade.Task;

public class AlterarTask implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Session session = HibernateUtil.getSession();
		Long idTask = Long.valueOf(request.getParameter("idTask"));

		TaskDaoImpl taskDaoImpl = new TaskDaoImpl();
		Task taskReturn = taskDaoImpl.pesquisaPorId(idTask, session);
		session.close();
		if(taskReturn!=null){
			 JSONObject jsonObject = new JSONObject();  
             jsonObject.put("id", taskReturn.getIdTask());  
             jsonObject.put("titulo", taskReturn.getTitulo());  
             jsonObject.put("descricao", taskReturn.getDescricao()); 
             jsonObject.put("date", taskReturn.getDataTask());
             jsonObject.put("status", taskReturn.isStatusTask());           
             try {
     			response.getWriter().write(jsonObject.toString());
     		} catch (IOException e) {
     			// TODO Auto-generated catch block
     			e.printStackTrace();
     		}
			
			return "true";
		}else{
			return "false";
		}
	
	}

}
