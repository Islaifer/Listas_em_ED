package model;

import model.entity.Aluno;

//Esta classe é o nó de nossa lista simplesmente encadeada.
//Aqui colocamos o dado que terá o nó e a referência para o próximo nó
public class NOS {
	//Dados privados para o encapsulamento
	private Aluno data;
	private NOS next;
	
	/*--------------Construtor--------------*/
	public NOS(Aluno data) {
		this.data = data;
		this.next = null;
	}

	/*-------------Métodos getters e setters--------------*/
	public Aluno getData() {
		return data;
	}

	public void setData(Aluno data) {
		this.data = data;
	}

	public NOS getNext() {
		return next;
	}

	public void setNext(NOS next) {
		this.next = next;
	}
}
