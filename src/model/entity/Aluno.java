package model.entity;

//Esta classe é o nosso objeto Aluno, que terá as informações dos alunos (nome e média)
//O intuito é somente recolher o nome e a média final dos alunos
//Como não teremos edição nestes exemplos, apenas usaremos os métodos get
public class Aluno {
	//Os dados são private para o encapsulamento
	private String nome;
	private double media;
	
	/*----------------Construtor-----------------*/
	public Aluno(String nome, double media) {
		this.nome = nome;
		this.media = media;
	}

	/*---------------Métodos getters e setters-------------*/
	public String getNome() {
		return nome;
	}

	public double getMedia() {
		return media;
	}
}
