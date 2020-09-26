package controller;

import model.NOS;
import model.entity.Aluno;

//Esta classe � nossa lista simplesmente encadeada (apenas uma refer�ncia por n�)
//Aqui colocaremos as opera��es de nossa lista simplesmente encadeada
public class ListaSimplesmenteEncadeada {
	//Aqui temos a refer�ncia do n� inicial da lista encadeada
	private NOS start;
	
	/*-----------------Construtor-----------------*/
	public ListaSimplesmenteEncadeada() {
		this.start = null;
	}
	
	/*-----------------M�todos principais-----------------*/
	public void adicionarInicio(Aluno data) {
		NOS n = new NOS(data);
		n.setNext(this.start);
		this.start = n;
		/*
		 * Neste m�todon�s criamos um novo n� com o dado recebido, colocamos como o pr�ximo n�
		 * a refer�ncia atual do primeiro n� e por fim dizemos que o novo n� inicial � o n� 
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
		 * Neste m�todo, criamos um n� novo, se a lista estiver vazia, ele ser� o primeiro,
		 * caso negativo, ele percorre a lista at� o �ltimo n� e seta a refer�ncia do pr�ximo
		 * n� deste �ltimo n� como o n� que criamos
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
			System.err.println("Posi��o inv�lida");
		}
		/*
		 * Neste m�todos, validamos se a posi��o existe, se existir e for a primeira, ele 
		 * adiciona no inicio, se for ao fim, ele adiciona ao fim, se for realmente no meio
		 * da lista, n�s criamos o novo n�, pegamos o n� da posi��o escolhida e de uma posi��o 
		 * anterior, o n� novo � setado o endere�amento do n� da posi��o escolhida e no n� da
		 * posi��o anterior � setado o endere�o do novo n�
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
		 * Neste m�todo verificamos se a lista est� vazia, caso n�o, ele diz que o primeiro n�
		 * � o segundo, sumindo a refer�ncia do primeiro n�
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
		 * Primeiro � verificado se a lista est� vazia, caso n�o ele acha o pen�ltimo n� e
		 * setta o endere�o do pr�ximo a ela como nulo, sumindo a refer�ncia do �ltimo (caso
		 * a lista tenha apenas um elemento, ele setta a refer�ncia do primeiro como nulo)
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
			System.out.println("Posi��o inv�lida :/");
		}
		/*
		 * Primeiro � verificado se a lista est� vazia e se a posi��o � valida, tamb�m se
		 * verifica se a posi��o � a primeira ou a ultima (chamando os m�todos respectivos
		 * em caso verdadeiro), caso contr�rio, ele pega a posi��o anterior a escolida e a 
		 * posterior, depois � settado a refer�ncia do pr�ximo endere�o do n� anterior a 
		 * posi��o como a do n� posterior a posi��o, sumindo com o n� da posi��o escolhida
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
	
	public void ordenar() {
		quickSort(0, size()-1);
		/*
		 * Este m�todo ordena a lista por meio do m�todo quick sort
		 * 
		 * */
	}
	
	/*------------------M�todos auxiliares-------------------*/
	
	private void quickSort(int start, int end) {
		if(start<end) {
			int pivo= partition(start, end);
			quickSort(start, pivo-1);
			quickSort(pivo+1, end);
		}
		/*
		 * Neste m�todo � feita a divis�o da lista recursivamente
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
		 * Este m�todo � feita a ordena��o pelo pivo e a escolha do novo pivo (a direita)
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
		 * Este m�todo � feita a troca dos valores dos n�s quando � chamado
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
		 * Este m�todo percorre a lista at� a posi��o escolhida e retorna a posi��o
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
		 * Este m�todo � percorrido o vetor e contado o n�mero de n�s, retornando o tamanho
		 * da lista
		 * 
		 * */
	}
}
