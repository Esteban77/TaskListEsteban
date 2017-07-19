package negocio;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
		String idTask = request.getParameter("id");
		Long id = null;
		if(idTask !=null && !idTask.isEmpty()){
			id = (long) Integer.parseInt(idTask);
		}
		task.setIdTask(id);
		task.setDescricao(request.getParameter("descricao"));
		task.setTitulo(request.getParameter("titulo"));
		String data = request.getParameter("dataInicio");
		String status = request.getParameter("status");
		if(status.equalsIgnoreCase("realizada")){
			task.setStatusTask(true);
		}else{
			task.setStatusTask(false);
		}
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		Calendar calendar = Calendar.getInstance();
		try {
			calendar.setTime(sdf.parse(data));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		Date date = new Date();
		
		date.getDate();
		Calendar calendar2 = calendar.getInstance();
		calendar2.setTime(date);

		long difference = (calendar2.getTimeInMillis() - calendar.getTimeInMillis());
		
		date.setTime(date.getTime()-difference);
		task.setDataTask(date);		
		
		
		taskDaoImpl.salvarOuAlterar(task, session);	
		Task taskReturn = taskDaoImpl.pesquisaPorId(task.getIdTask(), session);
		session.close();
		
		if(taskReturn!=null){
			JSONObject objeto = new JSONObject();
			objeto.put("id", taskReturn.getIdTask());
			objeto.put("titulo", taskReturn.getTitulo());			
			objeto.put("status", status);
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
