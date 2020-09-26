package controller;

import model.NOS;
import model.entity.Aluno;

//Esta classe � nossa lista simplesmente encadeada (apenas uma refer�ncia por n�)
//Aqui colocaremos as opera��es de nossa lista simplesmente encadeada
public class FilaSimplesmenteEncadeada {
	//Aqui temos a refer�ncia do n� inicial da lista encadeada
	private NOS start;
	
	/*-----------------Construtor-----------------*/
	public FilaSimplesmenteEncadeada() {
		this.start = null;
	}
	
	/*-----------------M�todos principais-----------------*/
	
	//Metodo disponivel na fila e pilha
	public void adicionar(Aluno data) {
		NOS n = new NOS(data);
		if(this.start == null) {
			this.start = n;
		}else {
			NOS aux = this.start;
			while(aux.getNext()!=null) {
				aux = aux.getNext();
			}
			aux.setNext(n);
		}
		/*
		 * Neste m�todo, criamos um n� novo, se a lista estiver vazia, ele ser� o primeiro,
		 * caso negativo, ele percorre a lista at� o �ltimo n� e seta a refer�ncia do pr�ximo
		 * n� deste �ltimo n� como o n� que criamos
		 * 
		 * */
	}
	
	//Metodo para fila
	public void remover() {
		if(this.start == null) {
			System.err.println("Lista vazia");
		}else {
			this.start = this.start.getNext();
		}
		/*
		 * Neste m�todo verificamos se a lista est� vazia, caso n�o, ele diz que o primeiro n�
		 * � o segundo, sumindo a refer�ncia do primeiro n�
		 * 
		 * */
	}
	
	public String mostrar() {
		String mostra;
		if(this.start == null) {
			mostra = "Lista vazia :/";
		}else {
			StringBuffer buffer = new StringBuffer("Lista de Alunos:\n");
			NOS aux = this.start;
			while(aux!=null) {
				buffer.append("Nome: " + aux.getData().getNome() + " |M�dia: " + 
						aux.getData().getMedia() + "\n");
				aux = aux.getNext();
			}
			mostra = buffer.toString();
		}
		return mostra;
		/*
		 * Neste m�todo, verificado se a lista est� vazia, retornando que a lista est� vazia
		 * em caso verdadeiro, em caso falso, � iniciado o percurso da lista toda, concatenando
		 * no StringBuffer e depois passando o valor do StringBuffer para a vari�vel mostra e a
		 * retornando
		 * 
		 * */
	}
}

