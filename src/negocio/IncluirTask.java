package negocio;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.json.JSONObject;

import dao.HibernateUtil;
import dao.TaskDaoImpl;
import entidade.Task;

public class IncluirTask implements Acao {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {

		Session session = HibernateUtil.getSession();
		Task task = new Task();
		TaskDaoImpl taskDaoImpl = new TaskDaoImpl();
		task.setId(null);
		task.setDescricao(request.getParameter("descricao"));
		task.setTitulo(request.getParameter("titulo"));
		String data = request.getParameter("data");
		Date date = new Date();
		date.getDate();
		task.setData(date);		
		task.setStatus(true);
		
		taskDaoImpl.salvarOuAlterar(task, session);
		session.close();
		
		Task taskReturn = taskDaoImpl.pesquisaPorId(task.getId(), session);
		
		if(taskReturn!=null){
			JSONObject objeto = new JSONObject();
			objeto.put("id", taskReturn.getId());
			objeto.put("titulo", taskReturn.getTitulo());
			try {
				response.setCharacterEncoding("UTF-8");  
		        response.setContentType("application/json");   
				response.getWriter().write(objeto.toString());
			}catch(IOException e) {
				e.printStackTrace();
			} 		
			return "true";
		}else{
			return "false";		
		}		
	}
}
