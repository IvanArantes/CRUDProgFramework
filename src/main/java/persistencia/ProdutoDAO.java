package persistencia;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.Produto;

public class ProdutoDAO implements Serializable {
	
	private static final long serialVersionUID = 1281895642801892176L;
	
	public static void inserir(Produto produto) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.save(produto);
		t.commit();
		sessao.close();
	}
	
	public static void alterar(Produto produto) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.update(produto);
		t.commit();
		sessao.close();
	
	}
	
	public static void excluir(Produto produto){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.delete(produto);
		t.commit();
		sessao.close();
	}
	
	public static List<Produto> listagem(String filtro){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta;
		if(filtro.trim().length() == 0){
			consulta = sessao.createQuery("from Produto order by produto_nome");
		} else {
			consulta = sessao.createQuery("from Produto where nomeProduto like :nomeProduto order by nomeProduto");
			consulta.setString("nomeProduto", "%" + filtro + "%");
		}
		List<Produto> lista = consulta.list();
		sessao.close();
		return lista;
	}
	
}
