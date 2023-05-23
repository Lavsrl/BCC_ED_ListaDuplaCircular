package listaDuplamenteEncadeadaAtividade;

import java.util.Scanner;

public class Atividade3_4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ListaDuplaCircular lista1 = new ListaDuplaCircular();
		ListaDuplaCircular lista2 = new ListaDuplaCircular();

		System.out.println("Digite quantos valores deseja adicionar nas listas");
		int tamanho = sc.nextInt();
		for (int i = 0; i < tamanho; i++) {
			System.out.println("Digite os valores da lista 1: ");
			int valores = sc.nextInt();
			lista1.inserirADireita(valores);
		}

		for (int i = 0; i < tamanho; i++) {
			System.out.println("Digite os valores da lista 2: ");
			int valores = sc.nextInt();
			lista2.inserirADireita(valores);
		}

		while(true) {
			System.out.println("==============");
			lista1.imprimir();
			lista2.imprimir();
			System.out.println("Digite o processo que deseja fazer com esta lista: ");
			System.out.println("1 - Contar os numeros das listas");
			System.out.println("2 - Inserir um elemento à esquerda das listas");
			System.out.println("3 - Concatenar listas");
			System.out.println("4 - Intercalar duas listas");
			System.out.println("5 - Fazer cópia da lista");
			int opcoes = sc.nextInt();
		switch (opcoes) {
		case 1:
			System.out.println("Total de elementos da lista 1: " + lista1.tamanho());
			System.out.println("Total de elementos da lista 2: " + lista2.tamanho());
			break;
		case 2:
			System.out.println("Digite quantos valores deseja adicionar nas listas");
			tamanho = sc.nextInt();
			for (int i = 0; i < tamanho; i++) {
				System.out.println("Digite os valores da lista 1: ");
				int valores = sc.nextInt();
				lista1.inserirAEsquerda(valores);
			}

			for (int i = 0; i < tamanho; i++) {
				System.out.println("Digite os valores da lista 2: ");
				int valores = sc.nextInt();
				lista2.inserirAEsquerda(valores);
			}
			System.out.println("Valores adicionados com sucesso!");
			break;

		case 3:
			lista1.concatenar(lista2);
			System.out.println("Lista concatenada: ");
			lista1.imprimir();
			break;

		case 4:
			ListaDuplaCircular listaDIntercalada = new ListaDuplaCircular();
			listaDIntercalada.intercalar(lista1, lista2);

			System.out.println("Lista intercalada: ");
			listaDIntercalada.imprimir();
			break;

		case 5:
			ListaDuplaCircular lista1Copia = lista1.copiar();
			ListaDuplaCircular lista2Copia = lista2.copiar();

			System.out.println("Listas originais: ");
			lista1.imprimir();
			lista2.imprimir();

			System.out.println("Cópia da lista: ");
			lista1Copia.imprimir();
			lista2Copia.imprimir();
			break;
		}
		
		}
	}

}
