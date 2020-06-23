package model;

import model.entity.Aluno;

//Esta classe � o nosso n� da lista duplamente encadeada
//Nele vamos colocar o dado do n� e as refer�ncias do n� anterior e do n� posterior
public class NOD {
	
	//Dados private para o encapsulamento
	private Aluno data;
	private NOD next;
	private NOD previous;
	
	/*-------------Construtor--------------*/
	public NOD(Aluno data) {
		this.data = data;
		this.next = null;
		this.previous = null;
	}

	/*-----------------Metodos getters e setters--------------*/
	public Aluno getData() {
		return data;
	}

	public void setData(Aluno data) {
		this.data = data;
	}

	public NOD getNext() {
		return next;
	}

	public void setNext(NOD next) {
		this.next = next;
	}

	public NOD getPrevious() {
		return previous;
	}

	public void setPrevious(NOD previous) {
		this.previous = previous;
	}
}
