package program;

import java.text.ParseException;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.VendaDao;
import model.entities.Venda;

public class Main {

	public static void main(String[] args) throws ParseException {

		VendaDao venda = DaoFactory.createVendaDao();
		List<Venda> v = venda.findAll();
		
		for(Venda x : v) {
			System.out.println(x);
		}
	}

}
