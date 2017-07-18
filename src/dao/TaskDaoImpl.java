package dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import entidade.Task;


public class TaskDaoImpl extends BaseDaoImpl<Task, Long> implements TaskDao, Serializable{

	@Override
	public Task pesquisaPorId(Long id, Session session) throws HibernateException {
		Task task = (Task) session.get(Task.class, id);
		return task;
	}

	@Override
	public List<Task> listaTodos(Session session) throws HibernateException {
		Query consulta = session.createQuery("from Task");
		return consulta.list();
	}

	@Override
	public List<Task> pesquisaPorFiltro(String filtro, Session session) throws HibernateException {
		Query consulta = session.createQuery("from Task t where t.titulo like :titulo");
		consulta.setParameter("nome", "%" + filtro + "%");
		return consulta.list();
	}

}
