package program;

import java.text.ParseException;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.ProdutoDao;
import model.entities.Produto;

public class Main {

	public static void main(String[] args) throws ParseException {

		ProdutoDao p = DaoFactory.createProdutoDao();
		List<Produto> pro = p.findAll();
		
		for(Produto x : pro) {
			System.out.println(x);
		}
		
	}

}
