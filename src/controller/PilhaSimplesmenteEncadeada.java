package controller;

import model.NOS;
import model.entity.Aluno;

//Esta classe é nossa pilha simplesmente encadeada (apenas uma referência por nó)
//Aqui colocaremos as operações de nossa pilha simplesmente encadeada
public class PilhaSimplesmenteEncadeada {
	//Aqui temos a referência do nó inicial da pilha encadeada
	private NOS start;
	
	/*-----------------Construtor-----------------*/
	public PilhaSimplesmenteEncadeada() {
		this.start = null;
	}
	
	/*-----------------Métodos principais-----------------*/
	
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
		 * Neste método, criamos um nó novo, se a lista estiver vazia, ele será o primeiro,
		 * caso negativo, ele percorre a lista até o último nó e seta a referência do próximo
		 * nó deste último nó como o nó que criamos
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
		 * Primeiro é verificado se a lista está vazia, caso não ele acha o penúltimo nó e
		 * setta o endereço do próximo a ela como nulo, sumindo a referência do último (caso
		 * a lista tenha apenas um elemento, ele setta a referência do primeiro como nulo)
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
				buffer.append("Nome: " + aux.getData().getNome() + " |Média: " + 
						aux.getData().getMedia() + "\n");
				aux = aux.getNext();
			}
			mostra = buffer.toString();
		}
		return mostra;
		/*
		 * Neste método, verificado se a lista está vazia, retornando que a lista está vazia
		 * em caso verdadeiro, em caso falso, é iniciado o percurso da lista toda, concatenando
		 * no StringBuffer e depois passando o valor do StringBuffer para a variável mostra e a
		 * retornando
		 * 
		 * */
	}
	
}

