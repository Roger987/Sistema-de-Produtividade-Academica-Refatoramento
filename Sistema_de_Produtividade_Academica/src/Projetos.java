import java.util.ArrayList;
import java.util.Scanner;

public class Projetos{
	public String titulo = null;
	public int datainicio;
	public int mesinicio;
	public int anoinicio = 0;
	public int datatermino ;
	public int mestermino;
	public int anotermino = 0;
	public float valorfinanciado = 0;
	public String agenciafinanciadora = null;
	public String objetivo = null;
	public String descricao = null;
	public String status = "Em elaboração";
	public ArrayList<Colaboradores> participantes = new ArrayList<Colaboradores>();
	public ArrayList<Publicacoes> publicacoes = new ArrayList<Publicacoes>();
	
	public void CriarNovoProjeto(Laboratorio lab) {

		Scanner scanner = new Scanner(System.in);
		
		boolean flag = false;
		
		System.out.println("\nVocê deve alocar ao menos um professor ao novo projeto. Informe o nome do professor:\n");
		
		String professor = scanner.nextLine();
		
		int i;
		
		for(i = 0; i < lab.colaboradores.size(); i++) {
			
			if(professor.equals(lab.colaboradores.get(i).nome) && "Professor".equals(lab.colaboradores.get(i).tipo)) {
				
				this.participantes.add(lab.colaboradores.get(i));
				lab.colaboradores.get(i).meusprojetos.add(this);
				
				System.out.println("\nInforme o título do novo projeto:\n");
				
				this.titulo = scanner.nextLine();
				
				System.out.println("\nInforme o objetivo do projeto:\n");
				
				this.objetivo = scanner.nextLine();
				
				System.out.println("\nDê uma descrição ao projeto:\n");
				
				this.descricao = scanner.nextLine();
				
				System.out.println("\nInforme a agência financiadora:\n");
				
				this.agenciafinanciadora = scanner.nextLine();
				
				System.out.println("\nInforme a data de início do projeto, dia, mês e ano, cada um separado por uma quebra de linha:\n");
				
				this.datainicio = scanner.nextInt();
				scanner.nextLine();
				
				this.mesinicio = scanner.nextInt();
				scanner.nextLine();
				
				this.anoinicio = scanner.nextInt();
				scanner.nextLine();
				
				System.out.println("\nInforme a data de término do projeto, dia, mês e ano, cada um separado por uma quebra de linha:\n");
				
				this.datatermino = scanner.nextInt();
				scanner.nextLine();
				
				this.mestermino = scanner.nextInt();
				scanner.nextLine();
				
				this.anotermino = scanner.nextInt();
				scanner.nextLine();
				
				System.out.println("\nInforme o valor financiado:\n");
				
				this.valorfinanciado = scanner.nextFloat();
				scanner.nextLine();
				
				
				System.out.println("\nNovo projeto criado com sucesso!\n");
				
			}
		}
		
		if(!flag) {
			
			System.out.println("\nProfessor não encontrado! Tente novamente!\n");
	
		}
		
	}
	
	public void AlocarColaborador(ArrayList<Colaboradores> colaboradores) {
		
		Scanner scanner = new Scanner(System.in);
		
		if(this.status.equals("Em elaboração")) {
			
			System.out.println("\nInforme o nome do colaborador que deseja alocar ao projeto " + this.titulo +":");
			
			String nomecolaborador = scanner.nextLine();
			
			int i, flag = 0;
			
			for(i = 0; i < colaboradores.size(); i++) {
				if(nomecolaborador.equals(colaboradores.get(i).nome)) {
					if(colaboradores.get(i).flag < 3) {
						colaboradores.get(i).meusprojetos.add(this);
						this.participantes.add(colaboradores.get(i));
						colaboradores.get(i).flag++;
						System.out.println("\nSucesso!");
						flag++;
					}
				}
			}
			
			if(flag == 0) {
				System.out.println("\nOps! Não encontrado!");
			}
		}
		
		else {
			System.out.println("\nO projeto não está em elaboração!");
		}
		
	}
	
	public void AlterarStatus() {
		
		System.out.println("\nInforme o novo status do projeto:");
		
		Scanner scanner = new Scanner(System.in);
		
		String novostatus = scanner.nextLine();
		
		if(novostatus.equals("Em andamento") && this.titulo != null && this.agenciafinanciadora != null && this.anoinicio != 0 && this.anotermino != 0 && this.objetivo != null && this.participantes.size() > 0) {
			
			this.status = novostatus;
			
			System.out.println("\nStatus alterado para 'Em andamento'com sucesso!");
		}
		
		else if(novostatus.equals("Concluido") && this.status.equals("Em andamento") && this.publicacoes.size() > 0) {
				
			this.status = novostatus;
			
			System.out.println("\nStatus alterado para 'Concluido'com sucesso!");

		}
		
		else {
			System.out.println("\nErro! Tente novamente!");
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