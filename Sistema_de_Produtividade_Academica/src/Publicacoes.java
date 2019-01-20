import java.util.ArrayList;
import java.util.Scanner;

public class Publicacoes{
	public String titulo;
	public String conferencia;
	public String projeto;
	public int ano;
	public ArrayList<String> autores = new ArrayList<String>();
	
	public void AddPublicacao(Laboratorio lab) {
		
		System.out.println("\nInforme o título da publicação:");
		
		Scanner scanner = new Scanner(System.in);
		
		int i;
		
		String projetoassociado;
		
		this.titulo = scanner.nextLine();
		
		System.out.println("\nInforme o nome da conferência onde foi publicada:");
		
		this.conferencia = scanner.nextLine();
		
		System.out.println("\nEstá associada a algum projeto? Digite 1 caso sim, e 2 caso não.");
		
		int proj = scanner.nextInt();
		scanner.nextLine();
		
		if(proj == 1) {
			
			System.out.println("\nInforme o título do projeto asociado à publicação:");
			
			projetoassociado = scanner.nextLine();
			
			for(i = 0; i < lab.projetos.size(); i++) {
				if(projetoassociado.equals(lab.projetos.get(i).titulo) && lab.projetos.get(i).status.equals("Em andamento")) {
					this.projeto = projetoassociado;
					lab.projetos.get(i).publicacoes.add(this);
				}
				else if(projetoassociado.equals(lab.projetos.get(i).titulo) && !lab.projetos.get(i).status.equals("Em andamento")) {
					System.out.println("Erro! O projeto não está em andamento!");
				}
			}
			
		}
		
		System.out.println("\nInforme o ano de publicação:");
		
		this.ano = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("\nInforme o nome de todos os autores da publicação, quando terminar digite 'Finalizar' para finalizar a operação.");
		
		String autor = "inicializando";
		
		while(!autor.equals("Finalizar")) {
			
			autor = scanner.nextLine();
			
			if(!autor.equals("Finalizar")) {
				
				for(i = 0; i < lab.colaboradores.size(); i++) {
					if(autor.equals(lab.colaboradores.get(i).nome)) {
						this.autores.add(autor);
						lab.colaboradores.get(i).publicacoes.add(this);
					}
				}
				
			}
			
		}
	}
	
}