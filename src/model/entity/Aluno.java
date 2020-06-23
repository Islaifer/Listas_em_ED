package model.entity;

//Esta classe � o nosso objeto Aluno, que ter� as informa��es dos alunos (nome e m�dia)
//O intuito � somente recolher o nome e a m�dia final dos alunos
//Como n�o teremos edi��o nestes exemplos, apenas usaremos os m�todos get
public class Aluno {
	//Os dados s�o private para o encapsulamento
	private String nome;
	private double media;
	
	/*----------------Construtor-----------------*/
	public Aluno(String nome, double media) {
		this.nome = nome;
		this.media = media;
	}

	/*---------------M�todos getters e setters-------------*/
	public String getNome() {
		return nome;
	}

	public double getMedia() {
		return media;
	}
}
