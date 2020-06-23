package view;

import javax.swing.JOptionPane;

import controller.ListaDuplamenteEncadeada;
import model.entity.Aluno;

//Esta classe é o menu da lista duplamente encadeada
public class MenuListaDuplamenteEncadeada {
	private int opc;
	
	public MenuListaDuplamenteEncadeada() {
		this.opc = 0;
	}
	
	public ListaDuplamenteEncadeada menu(ListaDuplamenteEncadeada lista) {
		int pos;
		while(this.opc!=9) {
			this.opc = Integer.parseInt(JOptionPane.showInputDialog("Menu da lista duplamente"
					+ " encadeada:\n"
					+ "1-Adicionar Final\n"
					+ "2-Adicionar Inicio\n"
					+ "3-Adicionar Meio\n"
					+ "4-Remover Final\n"
					+ "5-Remover Inicio\n"
					+ "6-Remover Meio\n"
					+ "7-Mostrar Lista\n"
					+ "8-Ordenar Lista\n"
					+ "9-Sair\n"
					+ "Escolha uma opção:"));
			switch(opc) {
			case 1: lista.adicionarFinal(AddAluno());
				break;
			case 2: lista.adicionarInicio(AddAluno());
				break;
			case 3: pos = Integer.parseInt(JOptionPane.showInputDialog("Insira a posição desejada"));
					lista.adicionarMeio(AddAluno(), pos);
					break;
			case 4: lista.removerFinal();
					break;
			case 5: lista.removerInicio();
					break;
			case 6: pos = Integer.parseInt(JOptionPane.showInputDialog("Insira a posição desejada"));
					lista.removerMeio(pos);
					break;
			case 7: JOptionPane.showMessageDialog(null, lista.mostrar());
				break;
			case 8: lista.ordenar();
				break;
			case 9: System.out.println("Saindo...");
					break;
			default: System.err.println("Valor inválido!");
			}
		}
		return lista;
	}
	
	private Aluno AddAluno() {
		Aluno data;
		String nome = JOptionPane.showInputDialog("Insira o nome do aluno:");
		double media = Double.parseDouble(JOptionPane.showInputDialog("Insira a média do aluno:"));
		data = new Aluno(nome, media);
		return data;
	}
}
