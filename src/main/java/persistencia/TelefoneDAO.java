package persistencia;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.Telefone;

public class TelefoneDAO implements Serializable {
	
	private static final long serialVersionUID = 1281895642801892176L;
	
	public static void inserir(Telefone telefone) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.save(telefone);
		t.commit();
		sessao.close();
	}
	
	public static void alterar(Telefone telefone) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.update(telefone);
		t.commit();
		sessao.close();
	
	}
	
	public static void excluir(Telefone telefone){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.delete(telefone);
		t.commit();
		sessao.close();
	}
	
	public static List<Telefone> listagem(String filtro){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta;
		if(filtro.trim().length() == 0){
			consulta = sessao.createQuery("from Telefone order by idPessoa");
		} else {
			consulta = sessao.createQuery("from Telefone where nrTelefone like :nrTelefone order by nrTelefone");
			consulta.setString("nrTelefone", "%" + filtro + "%");
		}
		List<Telefone> lista = consulta.list();
		sessao.close();
		return lista;
	}
	
}
