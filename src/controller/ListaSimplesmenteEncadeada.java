package controller;

import model.NOS;
import model.entity.Aluno;

//Esta classe é nossa lista simplesmente encadeada (apenas uma referência por nó)
//Aqui colocaremos as operações de nossa lista simplesmente encadeada
public class ListaSimplesmenteEncadeada {
	//Aqui temos a referência do nó inicial da lista encadeada
	private NOS start;
	
	/*-----------------Construtor-----------------*/
	public ListaSimplesmenteEncadeada() {
		this.start = null;
	}
	
	/*-----------------Métodos principais-----------------*/
	public void adicionarInicio(Aluno data) {
		NOS n = new NOS(data);
		n.setNext(this.start);
		this.start = n;
		/*
		 * Neste métodonós criamos um novo nó com o dado recebido, colocamos como o próximo nó
		 * a referência atual do primeiro nó e por fim dizemos que o novo nó inicial é o nó 
		 * que criamos
		 * 
		 * */
	}
	
	//Metodo disponivel na fila e pilha
	public void adicionarFinal(Aluno data) {
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
	
	public void adicionarMeio(Aluno data, int pos) {
		if(pos==1) {
			adicionarInicio(data);
		}else if(pos==size()+1) {
			adicionarFinal(data);
		}else if(pos<=size() && pos>0) {
			NOS n = new NOS(data);
			NOS aux = posicao(pos-2);
			NOS aux2 = aux.getNext();
			n.setNext(aux2);
			aux.setNext(n);
		}else {
			System.err.println("Posição inválida");
		}
		/*
		 * Neste métodos, validamos se a posição existe, se existir e for a primeira, ele 
		 * adiciona no inicio, se for ao fim, ele adiciona ao fim, se for realmente no meio
		 * da lista, nós criamos o novo nó, pegamos o nó da posição escolhida e de uma posição 
		 * anterior, o nó novo é setado o endereçamento do nó da posição escolhida e no nó da
		 * posição anterior é setado o endereço do novo nó
		 * 
		 * */
	}
	
	//Metodo para fila
	public void removerInicio() {
		if(this.start == null) {
			System.err.println("Lista vazia");
		}else {
			this.start = this.start.getNext();
		}
		/*
		 * Neste método verificamos se a lista está vazia, caso não, ele diz que o primeiro nó
		 * é o segundo, sumindo a referência do primeiro nó
		 * 
		 * */
	}
	
	//Metodo para pilha
	public void removerFinal() {
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
	
	public void removerMeio(int pos) {
		if(this.start == null) {
			System.err.println("Lista vazia :/");
		}else if(pos==1) {
			removerInicio();
		}else if(pos==size()) {
			removerFinal();
		}else if(pos<=size() && pos>0) {
			NOS aux = posicao(pos-2);
			NOS aux2 = aux.getNext().getNext();
			aux.setNext(aux2);
		}else {
			System.out.println("Posição inválida :/");
		}
		/*
		 * Primeiro é verificado se a lista está vazia e se a posição é valida, também se
		 * verifica se a posição é a primeira ou a ultima (chamando os métodos respectivos
		 * em caso verdadeiro), caso contrário, ele pega a posição anterior a escolida e a 
		 * posterior, depois é settado a referência do próximo endereço do nó anterior a 
		 * posição como a do nó posterior a posição, sumindo com o nó da posição escolhida
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
	
	public void ordenar() {
		quickSort(0, size()-1);
		/*
		 * Este método ordena a lista por meio do método quick sort
		 * 
		 * */
	}
	
	/*------------------Métodos auxiliares-------------------*/
	
	private void quickSort(int start, int end) {
		if(start<end) {
			int pivo= partition(start, end);
			quickSort(start, pivo-1);
			quickSort(pivo+1, end);
		}
		/*
		 * Neste método é feita a divisão da lista recursivamente
		 * 
		 * */
	}
	
	private int partition(int start, int end) {
		int i = start;
		for(int j=start; j<end; j++) {
			if(posicao(j).getData().getMedia()>=posicao(end).getData().getMedia()) {
				trocar(i++, j);
			}
		}
		trocar(i, end);
		return i;
		/*
		 * Este método é feita a ordenação pelo pivo e a escolha do novo pivo (a direita)
		 * 
		 * */
	}
	
	private void trocar(int i, int j) {
		NOS auxi = posicao(i);
		Aluno alunoi = auxi.getData();
		NOS auxj = posicao(j);
		Aluno alunoj = auxj.getData();
		auxi.setData(alunoj);
		auxj.setData(alunoi);
		/*
		 * Este método é feita a troca dos valores dos nós quando é chamado
		 * 
		 * */
	}
	
	private NOS posicao(int x) {
		NOS aux = this.start;
		for(int i=0; i<x; i++) {
			aux = aux.getNext();
		}
		return aux;
		/*
		 * Este método percorre a lista até a posição escolhida e retorna a posição
		 * 
		 * */
	}
	
	private int size() {
		int x = 0;
		NOS aux = this.start;
		while(aux!=null) {
			aux = aux.getNext();
			x++;
		}
		return x;
		/*
		 * Este método é percorrido o vetor e contado o número de nós, retornando o tamanho
		 * da lista
		 * 
		 * */
	}
}
