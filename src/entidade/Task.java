package entidade;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="tasklist")
public class Task implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long idTask;	
	
	@Temporal(TemporalType.DATE)
	private Date dataTask;
	
	private String titulo;
	private String descricao;	
	private boolean statusTask;
	
	public Task() {
		super();
	}	

	public Task(Long idTask, Date dataTask, String descricao, boolean status) {
		super();
		this.idTask = idTask;
		this.dataTask = dataTask;
		this.descricao = descricao;
		this.statusTask = statusTask;
	}



	public Long getIdTask() {
		return idTask;
	}

	public void setIdTask(Long idTask) {
		this.idTask = idTask;
	}

	public Date getDataTask() {
		return dataTask;
	}

	public void setDataTask(Date dataTask) {
		this.dataTask = dataTask;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isStatusTask() {
		return statusTask;
	}

	public void setStatusTask(boolean statusTask) {
		this.statusTask = statusTask;
	}

	@Override
	public String toString() {
		return "Task [idTask=" + idTask + ", dataTask=" + dataTask + ", descricao=" + descricao + ", statusTask=" + statusTask + "]";
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	
	
}
