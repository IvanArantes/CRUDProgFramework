package negocio;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import beans.Produto;
import persistencia.ProdutoDAO;

@ManagedBean
@SessionScoped
public class ProdutoCtrl implements Serializable {
	

	private static final long serialVersionUID = -7308527937715982746L;
	private Produto produto;

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}
	
	public List<Produto> listar(Produto p){
		return ProdutoDAO.listagem(p.getNomeProduto());
	}
	
	public String actionGravar(){
		if(produto.getIdProduto() == 0){
			ProdutoDAO.inserir(produto);
			return actionInserir();
		}
		else {
			ProdutoDAO.alterar(produto);
			return "listar";
		}
	}
	
	public String actionInserir(){
		produto = new Produto();
		return "form_produto";
	}
	
	public String actionExcluir(Produto p){
		ProdutoDAO.excluir(p);
		return "listar";
	}
	
	public String actionAlterar(Produto p){
		produto = p;
		return "form_produto";
	}
}
