package program;

import java.text.ParseException;

import model.dao.ClienteDao;
import model.dao.DaoFactory;
import model.entities.Cliente;

public class Main {

	public static void main(String[] args) throws ParseException {

		ClienteDao c = DaoFactory.createClienteDao();
		Cliente c1 = c.findById(1);
		
		System.out.println(c1);
	
	}

}
