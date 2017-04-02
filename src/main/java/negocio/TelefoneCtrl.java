package negocio;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import beans.Telefone;
import persistencia.TelefoneDAO;

@ManagedBean
@SessionScoped
public class TelefoneCtrl implements Serializable {
	

	private static final long serialVersionUID = -7308527937715982746L;
	private Telefone telefone;

	public Telefone getTelefone() {
		return telefone;
	}

	public void setTelefone(Telefone telefone) {
		this.telefone = telefone;
	}
	

	
	public String actionGravar(){
		if(telefone.getIdTelefone() == 0){
			TelefoneDAO.inserir(telefone);
			return actionInserir();
		}
		else {
			TelefoneDAO.alterar(telefone);
			return "listar";
		}
	}
	
	public String actionInserir(){
		telefone = new Telefone();
		return "form_telefone";
	}
	
	public String actionExcluir(Telefone p){
		TelefoneDAO.excluir(p);
		return "listar";
	}
	
	public String actionAlterar(Telefone p){
		telefone = p;
		return "form_telefone";
	}
}
