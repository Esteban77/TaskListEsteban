package negocio;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.json.JSONArray;
import org.json.JSONObject;

import dao.HibernateUtil;
import dao.TaskDaoImpl;
import entidade.Task;
import negocio.Acao;

public class ObterTask implements Acao{

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		
		response.setCharacterEncoding("UTF-8");  
        response.setContentType("application/json");  
        Session session = HibernateUtil.getSession();
        TaskDaoImpl taskDaoImpl = new TaskDaoImpl();
		
		List<Task> listTask = taskDaoImpl.listaTodos(session);
		session.close();
		if(!listTask.isEmpty()){
		JSONArray jsonArray = new JSONArray();
		for(Task task : listTask ){
			   JSONObject jsonObject = new JSONObject();  
               jsonObject.put("id", task.getIdTask());  
               jsonObject.put("titulo", task.getTitulo());  
               jsonArray.put(jsonObject);  
		}
		
		try {
			response.getWriter().write(jsonArray.toString());
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
