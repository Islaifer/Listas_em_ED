package controller;

import model.NOD;
import model.entity.Aluno;

//Esta classe é a nossa lista duplamente encadeada (duas referências, do nó anterior e do posterior)
//Aqui colocaremos todos os métodos de nossa lista duplamente encadeada
public class ListaDuplamenteEncadeada {
	//Aqui temos a referência do nó inicial
	private NOD start;
	
	/*---------------------Construtor---------------------*/
	public ListaDuplamenteEncadeada() {
		this.start = null;
	}
	
	/*---------------------Métodos principais---------------------*/
	public void adicionarInicio(Aluno data) {
		NOD n = new NOD(data);
		n.setNext(this.start);
		if(this.start!=null) {
			this.start.setPrevious(n);
		}
		this.start = n;
		/*
		 * Este método é criado um novo nó, seta a referência do próximo a ele como a do
		 * nó inicial atual, se o nó inicial atual não for nulo, ele setta a referência
		 * anterior no novo nó, após isso, ele coloca a referência do primeiro nó no novo nó
		 * 
		 * */
	}
	
	public void adicionarFinal(Aluno data) {
		NOD n = new NOD(data);
		if(this.start == null) {
			this.start = n;
		}else {
			NOD aux = this.start;
			while(aux.getNext()!=null) {
				aux = aux.getNext();
			}
			aux.setNext(n);
			n.setPrevious(aux);
		}
		/*
		 * Primeiro é criado um novo nó, se a lista estiver vazia, ele é o primeiro nó, se não
		 * ele procura o último nó, coloca a referência do próximo como o novo nó e no novo nó
		 * coloca a referência do anterior como o antigo ultimo nó
		 * 
		 * */
	}
	
	public void adicionarMeio(Aluno data, int pos) {
		if(pos==1) {
			adicionarInicio(data);
		}else if(pos==size()+1) {
			adicionarFinal(data);
		}else if(pos<=size() && pos>0) {
			NOD n = new NOD(data);
			NOD aux = posicao(pos-1);
			NOD aux2 = aux.getPrevious();
			aux2.setNext(n);
			aux.setPrevious(n);
			n.setNext(aux);
			n.setPrevious(aux2);
		}else {
			System.err.println("Posição inválida");
		}
		/*
		 * Primeiro é verificado se a posição existe, se existir e for a primeira ou a última
		 * ele chama os respectivos métodos, se não ele cria um novo nó, procura a posição, 
		 * pega a posição anterior e na anterior linka o próximo no novo nó, na posição escolhida
		 * setta a referência do nó anterior no novo nó e no novo nó coloca as referências 
		 * respectivas
		 * 
		 * */
	}
	
	public void removerInicio() {
		if(this.start == null) {
			System.err.println("A lista está vazia");
		}else {
			this.start = this.start.getNext();
			if(this.start!=null) {
				this.start.setPrevious(null);
			}
		}
		/*
		 * Neste método é feita a verificação se a lista está vazia, caso não ele diz que o primeiro
		 * nó é o segundo nó, e caso não seja nulo, ele setta a posição anterior a ele como nula,
		 * sumindo com as referências ao antigo primeiro nó
		 * 
		 * */
	}
	
	public void removerFinal() {
		if(this.start==null) {
			System.err.println("A lista está vazia");
		}else {
			NOD aux = this.start;
			while(aux.getNext()!=null) {
				aux = aux.getNext();
			}
			aux = aux.getPrevious();
			if(aux!=null) {
				aux.setNext(null);
			}
		}
		/*
		 * Neste método é feita a validação se a lista está vazia, caso não ele procura o
		 * ultimo nó, pega o anterior e caso o anterior não seja nulo ele setta a referência ao
		 * próximo como nulas, sumindo com as referências do último nó.
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
			NOD aux = posicao(pos-1);
			NOD aux2 = aux.getNext();
			aux = aux.getPrevious();
			aux.setNext(aux2);
			aux2.setPrevious(aux);
		}else {
			System.out.println("Posição inválida :/");
		}
		/*
		 * Primeiro é feita a verificação se a lista está vazia, depois se a posição é válida,
		 * depois se a posição é a última ou a primeira chamando seus respectivos métodos, caso
		 * todos falsos ele procura a posição, pega o anterior e o posterior, e por fim setta o
		 * próximo do anterior como o posterior e o anterior do posterior como o anterior
		 * 
		 * */
	}
	
	public String mostrar() {
		String mostra;
		if(this.start == null) {
			mostra = "Lista vazia :/";
		}else {
			StringBuffer buffer = new StringBuffer("Lista de Alunos:\n");
			NOD aux = this.start;
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
		NOD auxi = posicao(i);
		Aluno alunoi = auxi.getData();
		NOD auxj = posicao(j);
		Aluno alunoj = auxj.getData();
		auxi.setData(alunoj);
		auxj.setData(alunoi);
		/*
		 * Este método é feita a troca dos valores dos nós quando é chamado
		 * 
		 * */
	}
	
	private NOD posicao(int x) {
		NOD aux = this.start;
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
		NOD aux = this.start;
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
