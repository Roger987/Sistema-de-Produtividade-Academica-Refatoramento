import java.util.ArrayList;
import java.util.Scanner;

public class Colaboradores{
	public String nome;
	public String tipo;
	public String email;
	public String tipoproducao;
	public int flag = 0;
	public ArrayList<Projetos> meusprojetos = new ArrayList<Projetos>();
	public ArrayList<Publicacoes> publicacoes = new ArrayList<Publicacoes>();
	public ArrayList<Colaboradores> orientandos = new ArrayList<Colaboradores>();
	public Colaboradores orientador;


	public void AddColaborador() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("\nDigite o nome do novo colaborador:\n");
		
		this.nome = scanner.nextLine();
		
		System.out.println("\nInforme o tipo do colaborador:\n"
				+ "(Tipos possíveis: Aluno de graduação, Aluno de mestrado, Aluno de doutorado, Professor e Pesquisador.)\n");
		
		this.tipo = scanner.nextLine();
		
		System.out.println("\nInforme o email do colaborador:\n");
		
		this.email = scanner.nextLine();
		
		System.out.println("\nColaborador adicionado com sucesso!\n");
		
	}
	
	public void OrdenarProjetos() {
		
		int i, j;
		Projetos aux;
		
		for(j = this.meusprojetos.size() - 1; j>= 0; j--) {
			for(i = 0; i < j; i++) {
				if(this.meusprojetos.get(i).anotermino < this.meusprojetos.get(i+1).anotermino) {
					aux = this.meusprojetos.get(i);
					this.meusprojetos.set(i, this.meusprojetos.get(i+1));
					this.meusprojetos.set(i+1, aux);
				}
			}
		}
		
		for(j = this.meusprojetos.size() - 1; j>= 0; j--) {
			for(i = 0; i < j; i++) {
				if(this.meusprojetos.get(i).anotermino == this.meusprojetos.get(i+1).anotermino && this.meusprojetos.get(i).mestermino < this.meusprojetos.get(i+1).mestermino) {
					aux = this.meusprojetos.get(i);
					this.meusprojetos.set(i, this.meusprojetos.get(i+1));
					this.meusprojetos.set(i+1, aux);
				}
			}
		}
		
		for(j = this.meusprojetos.size() - 1; j>= 0; j--) {
			for(i = 0; i < j; i++) {
				if(this.meusprojetos.get(i).anotermino == this.meusprojetos.get(i+1).anotermino && this.meusprojetos.get(i).mestermino == this.meusprojetos.get(i+1).mestermino && this.meusprojetos.get(i).datatermino < this.meusprojetos.get(i+1).datatermino) {
					aux = this.meusprojetos.get(i);
					this.meusprojetos.set(i, this.meusprojetos.get(i+1));
					this.meusprojetos.set(i+1, aux);
				}
			}
		}		
		
	}
	
	public void OrdenarPublicacoes() {
		
		int i, j;
		Publicacoes aux;
		
		for(j = this.publicacoes.size() - 1; j>= 0; j--) {
			for(i = 0; i < j; i++) {
				if(this.publicacoes.get(i).ano < this.publicacoes.get(i+1).ano) {
					aux = this.publicacoes.get(i);
					this.publicacoes.set(i, this.publicacoes.get(i+1));
					this.publicacoes.set(i+1, aux);
				}
			}
		}
	}
	
	
}