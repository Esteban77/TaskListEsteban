package negocio;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;

import dao.HibernateUtil;
import dao.TaskDaoImpl;
import entidade.Task;

public class RemoverTask implements Acao {

	@Override
	public String executar(HttpServletRequest request, HttpServletResponse response)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Session session = HibernateUtil.getSession();
		Long idTask = Long.valueOf(request.getParameter("idTask"));

		TaskDaoImpl taskDaoImpl = new TaskDaoImpl();
		Task taskReturn = taskDaoImpl.pesquisaPorId(idTask, session);
		taskDaoImpl.excluir(taskReturn, session);
		Task taskReturn2 = taskDaoImpl.pesquisaPorId(idTask, session);
		session.close();
		if (taskReturn2 == null) {
			try {
				response.getWriter().write("true");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return "true";
		} else {
			try {
				response.getWriter().write("false");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return "false";
		}
	}

}
