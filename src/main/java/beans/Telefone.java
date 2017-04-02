package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name= "fone")
public class Telefone {
	
	@Id
	@GeneratedValue
	@Column(name="fon_id")
	private int idTelefone;
	
	@Column(name="fon_numero")
	private String nrTelefone;
	
	@Column(name="fon_descricao")
	private String dsTelefone;
	
	@ManyToOne
	@JoinColumn(name = "pes_id")
	private Pessoa pessoa;

	public int getIdTelefone() {
		return idTelefone;
	}

	public void setIdTelefone(int idTelefone) {
		this.idTelefone = idTelefone;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public String getNrTelefone() {
		return nrTelefone;
	}

	public void setNrTelefone(String nrTelefone) {
		this.nrTelefone = nrTelefone;
	}

	public String getDsTelefone() {
		return dsTelefone;
	}

	public void setDsTelefone(String dsTelefone) {
		this.dsTelefone = dsTelefone;
	}
	
	
}
