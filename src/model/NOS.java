package model;

import model.entity.Aluno;

//Esta classe � o n� de nossa lista simplesmente encadeada.
//Aqui colocamos o dado que ter� o n� e a refer�ncia para o pr�ximo n�
public class NOS {
	//Dados privados para o encapsulamento
	private Aluno data;
	private NOS next;
	
	/*--------------Construtor--------------*/
	public NOS(Aluno data) {
		this.data = data;
		this.next = null;
	}

	/*-------------M�todos getters e setters--------------*/
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
