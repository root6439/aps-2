package program;

import java.text.ParseException;

import javax.swing.JFrame;

import view.TelaPrincipal;

public class Main {

	public static void main(String[] args) throws ParseException {

		TelaPrincipal tg = new TelaPrincipal();
		tg.setVisible(true);
		tg.setResizable(false);
        tg.setSize(912, 476);
        tg.setLocation(227,126);
		tg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
