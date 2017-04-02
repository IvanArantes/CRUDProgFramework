package beans;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name= "pessoa")
public class Pessoa {

	@Id
	@GeneratedValue
	@Column (name = "pes_id")
	private int idPessoa;
	
	@Column (name = "pes_nome")
	private String nomePessoa;
	
	@Column (name = "pes_cpf")
	private String cpfPessoa;
	
	@Column (name = "pes_rg")
	private String rgPessoa;
	
	@Column (name = "pes_data_nasc")
	private Date dtNascPessoa;
	
	@Column (name = "pes_rua")
	private String rua;
	
	@Column (name = "pes_bairro")
	private String bairro;
	
	@Column (name = "pes_cidade")
	private String cidade;
	
	@Column (name = "pes_uf")
	private String uf;
	
	@Column (name = "pes_cep")
	private int cep;
	
	@Column (name = "pes_email")
	private String email;
	
	@Column (name = "pes_senha")
	private  String senha;
	
	@Column (name = "pes_tipo")
	private String tipo;
	
	@OneToMany(mappedBy="pessoa", cascade=CascadeType.ALL, fetch=FetchType.LAZY)
    @JoinColumn(name="fon_id")
	private List<Telefone> telefones;

	public int getIdPessoa() {
		return idPessoa;
	}

	public void setIdPessoa(int idPessoa) {
		this.idPessoa = idPessoa;
	}

	public String getNomePessoa() {
		return nomePessoa;
	}

	public void setNomePessoa(String nomePessoa) {
		this.nomePessoa = nomePessoa;
	}

	public String getCpfPessoa() {
		return cpfPessoa;
	}

	public void setCpfPessoa(String cpfPessoa) {
		this.cpfPessoa = cpfPessoa;
	}

	public String getRgPessoa() {
		return rgPessoa;
	}

	public void setRgPessoa(String rgPessoa) {
		this.rgPessoa = rgPessoa;
	}

	public Date getDtNascPessoa() {
		return dtNascPessoa;
	}

	public void setDtNascPessoa(Date dtNascPessoa) {
		this.dtNascPessoa = dtNascPessoa;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Telefone> getTelefones() {
		return telefones;
	}

	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}

}
