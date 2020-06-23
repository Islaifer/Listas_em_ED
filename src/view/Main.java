package view;

import javax.swing.JOptionPane;

import controller.ListaDuplamenteEncadeada;
import controller.ListaSimplesmenteEncadeada;

//Nesta classe, iremos fazer apenas um menuzinho para testarmos nossas listas
public class Main {
	public static void main(String[] args) {
		ListaSimplesmenteEncadeada listaS = new ListaSimplesmenteEncadeada();
		ListaDuplamenteEncadeada listaD = new ListaDuplamenteEncadeada();
		int opc = 0;
		while(opc!=9) {
			MenuListaSimplesmenteEncadeada menuS = new MenuListaSimplesmenteEncadeada();
			MenuListaDuplamenteEncadeada menuD = new MenuListaDuplamenteEncadeada();
			opc = Integer.parseInt(JOptionPane.showInputDialog("Menu:\n"
					+ "1-Lista simplesmente encadeada\n"
					+ "2-Lista duplamente encadeada\n"
					+ "9-Sair\n"
					+ "Escolha uma opção:"));
			switch(opc) {
				case 1: listaS = menuS.menu(listaS);
					break;
				case 2: listaD = menuD.menu(listaD);
					break;
				case 9: System.out.println("Saindo...");
					break;
				default: System.err.println("Valor inválido");
			}
		}
		System.exit(0);
	}
}
