package controller;

import model.NOS;
import model.entity.Aluno;

//Esta classe � nossa pilha simplesmente encadeada (apenas uma refer�ncia por n�)
//Aqui colocaremos as opera��es de nossa pilha simplesmente encadeada
public class PilhaSimplesmenteEncadeada {
	//Aqui temos a refer�ncia do n� inicial da pilha encadeada
	private NOS start;
	
	/*-----------------Construtor-----------------*/
	public PilhaSimplesmenteEncadeada() {
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
	
	
	//Metodo para pilha
	public void remover() {
		if(this.start == null) {
			System.err.println("Lista vazia");
		}else if(this.start.getNext()==null){
			this.start = null;
		}else {
			NOS aux = this.start;
			while(aux.getNext().getNext()!=null) {
				aux = aux.getNext();
			}
			aux.setNext(null);
		}
		/*
		 * Primeiro � verificado se a lista est� vazia, caso n�o ele acha o pen�ltimo n� e
		 * setta o endere�o do pr�ximo a ela como nulo, sumindo a refer�ncia do �ltimo (caso
		 * a lista tenha apenas um elemento, ele setta a refer�ncia do primeiro como nulo)
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

