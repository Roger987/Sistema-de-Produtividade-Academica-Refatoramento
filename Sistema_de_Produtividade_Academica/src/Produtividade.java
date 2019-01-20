import java.util.Scanner;

public class Produtividade{
	
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		int choice = -1;
		
		System.out.println("\nBem-vind@! Digite o nome do laboratório:\n");
		
		String nomelab = scanner.nextLine();
		
		Laboratorio lab = new Laboratorio();
		
		lab.nome = nomelab;
		
		System.out.println("\nInforme a operação desejada:\n"
				+ " 1 - Adicionar um novo colaborador\n"
				+ " 2 - Criar novo projeto\n"
				+ " 3 - Alocar um colaborador a um projeto\n"
				+ " 4 - Alterar o status de um projeto\n"
				+ " 5 - Adicionar publicação\n"
				+ " 6 - Adicionar orientação\n"
				+ " 7 - Consulta por colaborador\n"
				+ " 8 - Consulta por projeto\n"
				+ " 9 - Gerar relatório de produção acadêmica do laboratório\n"
				+ " 0 - Sair\n");
		
		while(choice != 0) {
			
			try {
				
				choice = scanner.nextInt();
				scanner.nextLine();
				
				switch(choice){
				
				case 1:
					
					Colaboradores colaborador = new Colaboradores();
					
					colaborador.AddColaborador();
					
					lab.colaboradores.add(colaborador);
					
					break;
					
				case 2:
					
					Projetos projeto = new Projetos();
					
					projeto.CriarNovoProjeto(lab);
					
					lab.projetos.add(projeto);
					
					break;
					
				case 3:
					
					System.out.println("\nInfome o projeto ao qual deseja alocar um colaborador:\n");
					
					String proj = scanner.nextLine();
					
					int i;
					
					for(i = 0; i < lab.projetos.size(); i++) {
						if(proj.equals(lab.projetos.get(i).titulo)) {
							lab.projetos.get(i).AlocarColaborador(lab.colaboradores);
						}
					}
					
					break;
					
				case 4:
					
					System.out.println("\nInfome o projeto cujo status deseja alterar:\n");
					
					String alterar = scanner.nextLine();
					
					for(i = 0; i < lab.projetos.size(); i++) {
						if(alterar.equals(lab.projetos.get(i).titulo)) {
							lab.projetos.get(i).AlterarStatus();
						}
					}
					
					break;
					
				case 5:
					
					Publicacoes publicacao = new Publicacoes();
					
					publicacao.AddPublicacao(lab);
					
					lab.totalpublicacoes++;
					
					break;
					
				case 6:
					
					System.out.println("\nInforme o nome do professor orientador:\n");
					
					String orientador = scanner.nextLine();
					
					int j; 
					
					String orientado;
					
					for(i = 0; i < lab.colaboradores.size(); i++) {
						if(orientador.equals(lab.colaboradores.get(i).nome)) {
							if(lab.colaboradores.get(i).tipo.equals("Professor")) {
								
								System.out.println("\nInforme o nome do aluno a ser orientado:\n");
								
								orientado = scanner.nextLine();
								
								for(j = 0; j < lab.colaboradores.size(); j++) {
									if(orientado.equals(lab.colaboradores.get(j).nome)) {
										lab.colaboradores.get(i).orientandos.add(lab.colaboradores.get(j));
										lab.colaboradores.get(j).orientador = lab.colaboradores.get(i);
									}
								}
							}
						}
					}
					
					lab.totalorientacoes++;
					
					break;
					
				case 7:
					
					System.out.println("\nInforme o nome do colaborador:\n");
					
					String search = scanner.nextLine();
					
					lab.BuscarColaborador(search);
					
					break;
					
				case 8:
					
					System.out.println("\nInforme o título do projeto:\n");
					
					search = scanner.nextLine();
					
					lab.BuscarProjeto(search);
					
					break;
					
				case 9:
					int elaboracao = 0, andamento = 0, concluido = 0;
					
					System.out.println("\nRELATÓRIO DE PRODUÇÃO ACADÊMICA:\n");
					
					System.out.println("Número de colaboradores: " + lab.colaboradores.size());
					for(i = 0; i < lab.projetos.size(); i++) {
						if(lab.projetos.get(i).status.equals("Em elaboração")) {
							elaboracao++;
						}
					}
					System.out.println("Numero de projetos em elaboração: " + elaboracao);
					for(i = 0; i < lab.projetos.size(); i++) {
						if(lab.projetos.get(i).status.equals("Em andamento")) {
							andamento++;
						}
					}
					System.out.println("Número de projetos em andamento: " + andamento);
					for(i = 0; i < lab.projetos.size(); i++) {
						if(lab.projetos.get(i).status.equals("Concluido")) {
							concluido++;
						}
					}
					System.out.println("Número de projetos concluídos: " + concluido);
					System.out.println("Número total de projetos: " + lab.projetos.size());
					System.out.println("Número total de orientações: " + lab.totalorientacoes + "\nNúmero total de publicações: "
							+ lab.totalpublicacoes + "\nNúmero total de produção acadêmica: " + (lab.totalorientacoes+lab.totalpublicacoes));
				}
				
					
				
				System.out.println("\nInforme a operação desejada:\n"
						+ " 1 - Adicionar um novo colaborador\n"
						+ " 2 - Criar novo projeto\n"
						+ " 3 - Alocar um colaborador a um projeto\n"
						+ " 4 - Alterar o status de um projeto\n"
						+ " 5 - Adicionar publicação\n"
						+ " 6 - Adicionar orientação\n"
						+ " 7 - Consulta por colaborador\n"
						+ " 8 - Consulta por projeto\n"
						+ " 9 - Gerar relatório de produção acadêmica do laboratório\n"
						+ " 0 - Sair\n");
				
			}
			
			catch(Exception e) {
				scanner.nextLine();
				System.out.println("\nOps! Parece que aconteceu um erro! Tente novamente!\n");
				System.out.println("\nInforme a operação desejada:\n"
						+ " 1 - Adicionar um novo colaborador\n"
						+ " 2 - Criar novo projeto\n"
						+ " 3 - Alocar um colaborador a um projeto\n"
						+ " 4 - Alterar o status de um projeto\n"
						+ " 5 - Adicionar publicação\n"
						+ " 6 - Adicionar orientação\n"
						+ " 7 - Consulta por colaborador\n"
						+ " 8 - Consulta por projeto\n"
						+ " 9 - Gerar relatório de produção acadêmica do laboratório\n"
						+ " 0 - Sair\n");
			}
			
		}
		
		
		scanner.close();
	}
	
	
}