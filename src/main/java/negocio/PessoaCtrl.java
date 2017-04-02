package negocio;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import beans.Pessoa;
import beans.Telefone;
import persistencia.PessoaDAO;
import persistencia.TelefoneDAO;

@ManagedBean
@SessionScoped
public class PessoaCtrl implements Serializable {
	

	private static final long serialVersionUID = -7308527937715982746L;
	private Pessoa pessoa;

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}
	
	public List<Pessoa> listar(Pessoa p){
		return PessoaDAO.listagem(p.getNomePessoa());
	}
	
	public String actionGravar(){
		if(pessoa.getIdPessoa() == 0){
			PessoaDAO.inserir(pessoa);
			return actionInserir();
		}
		else {
			PessoaDAO.alterar(pessoa);
			return "listar";
		}
	}
	
	public String actionInserir(){
		pessoa = new Pessoa();
		return "form_pessoa";
	}
	
	public String actionExcluir(Pessoa p){
		PessoaDAO.excluir(p);
		return "listar";
	}
	
	public String actionAlterar(Pessoa p){
		pessoa = p;
		return "form_pessoa";
	}
	
	public String actionInserirTelefone(){
		Telefone tel = new Telefone();
		tel.setPessoa(pessoa);
		pessoa.getTelefones().add(tel);
		return "form_pessoa";
	}
	
	public String actionExcluirTelefone(Telefone tel){
		TelefoneDAO.excluir(tel);
		return "form_pessoa";
	}
}
