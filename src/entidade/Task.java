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
	private Long id;	
	
	@Temporal(TemporalType.DATE)
	private Date data;
	
	private String titulo;
	private String descricao;	
	private boolean status;
	
	public Task() {
		super();
	}	

	public Task(Long id, Date data, String descricao, boolean status) {
		super();
		this.id = id;
		this.data = data;
		this.descricao = descricao;
		this.status = status;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", data=" + data + ", descricao=" + descricao + ", status=" + status + "]";
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	
	
	
}
