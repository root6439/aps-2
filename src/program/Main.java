package program;

import java.text.ParseException;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SetorDao;
import model.entities.Setor;

public class Main {

	public static void main(String[] args) throws ParseException {

		SetorDao setor = DaoFactory.createSetorDao();
		
		List<Setor> setores = setor.findAll();
		
		
		for(Setor x : setores) {
			System.out.println(x);
		}
		
	}

}
