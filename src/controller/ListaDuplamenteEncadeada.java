package controller;

import model.NOD;
import model.entity.Aluno;

//Esta classe � a nossa lista duplamente encadeada (duas refer�ncias, do n� anterior e do posterior)
//Aqui colocaremos todos os m�todos de nossa lista duplamente encadeada
public class ListaDuplamenteEncadeada {
	//Aqui temos a refer�ncia do n� inicial
	private NOD start;
	
	/*---------------------Construtor---------------------*/
	public ListaDuplamenteEncadeada() {
		this.start = null;
	}
	
	/*---------------------M�todos principais---------------------*/
	public void adicionarInicio(Aluno data) {
		NOD n = new NOD(data);
		n.setNext(this.start);
		if(this.start!=null) {
			this.start.setPrevious(n);
		}
		this.start = n;
		/*
		 * Este m�todo � criado um novo n�, seta a refer�ncia do pr�ximo a ele como a do
		 * n� inicial atual, se o n� inicial atual n�o for nulo, ele setta a refer�ncia
		 * anterior no novo n�, ap�s isso, ele coloca a refer�ncia do primeiro n� no novo n�
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
		 * Primeiro � criado um novo n�, se a lista estiver vazia, ele � o primeiro n�, se n�o
		 * ele procura o �ltimo n�, coloca a refer�ncia do pr�ximo como o novo n� e no novo n�
		 * coloca a refer�ncia do anterior como o antigo ultimo n�
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
			System.err.println("Posi��o inv�lida");
		}
		/*
		 * Primeiro � verificado se a posi��o existe, se existir e for a primeira ou a �ltima
		 * ele chama os respectivos m�todos, se n�o ele cria um novo n�, procura a posi��o, 
		 * pega a posi��o anterior e na anterior linka o pr�ximo no novo n�, na posi��o escolhida
		 * setta a refer�ncia do n� anterior no novo n� e no novo n� coloca as refer�ncias 
		 * respectivas
		 * 
		 * */
	}
	
	public void removerInicio() {
		if(this.start == null) {
			System.err.println("A lista est� vazia");
		}else {
			this.start = this.start.getNext();
			if(this.start!=null) {
				this.start.setPrevious(null);
			}
		}
		/*
		 * Neste m�todo � feita a verifica��o se a lista est� vazia, caso n�o ele diz que o primeiro
		 * n� � o segundo n�, e caso n�o seja nulo, ele setta a posi��o anterior a ele como nula,
		 * sumindo com as refer�ncias ao antigo primeiro n�
		 * 
		 * */
	}
	
	public void removerFinal() {
		if(this.start==null) {
			System.err.println("A lista est� vazia");
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
		 * Neste m�todo � feita a valida��o se a lista est� vazia, caso n�o ele procura o
		 * ultimo n�, pega o anterior e caso o anterior n�o seja nulo ele setta a refer�ncia ao
		 * pr�ximo como nulas, sumindo com as refer�ncias do �ltimo n�.
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
			System.out.println("Posi��o inv�lida :/");
		}
		/*
		 * Primeiro � feita a verifica��o se a lista est� vazia, depois se a posi��o � v�lida,
		 * depois se a posi��o � a �ltima ou a primeira chamando seus respectivos m�todos, caso
		 * todos falsos ele procura a posi��o, pega o anterior e o posterior, e por fim setta o
		 * pr�ximo do anterior como o posterior e o anterior do posterior como o anterior
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
		NOD auxi = posicao(i);
		Aluno alunoi = auxi.getData();
		NOD auxj = posicao(j);
		Aluno alunoj = auxj.getData();
		auxi.setData(alunoj);
		auxj.setData(alunoi);
		/*
		 * Este m�todo � feita a troca dos valores dos n�s quando � chamado
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
		 * Este m�todo percorre a lista at� a posi��o escolhida e retorna a posi��o
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
		 * Este m�todo � percorrido o vetor e contado o n�mero de n�s, retornando o tamanho
		 * da lista
		 * 
		 * */
	}
}
