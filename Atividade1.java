package listaDuplamenteEncadeadaAtividade;

import java.util.Scanner;

public class Atividade1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ListaDupla lista1 = new ListaDupla();
		ListaDupla lista2 = new ListaDupla();

		System.out.println("Digite quantos valores deseja adicionar nas listas");
		int tamanho = sc.nextInt();
		for (int i = 0; i < tamanho; i++) {
			System.out.println("Digite os valores da lista 1: ");
			int valores = sc.nextInt();
			lista1.adiciona(valores);
		}

		for (int i = 0; i < tamanho; i++) {
			System.out.println("Digite os valores da lista 2: ");
			int valores = sc.nextInt();
			lista2.adiciona(valores);
		}
		
		System.out.println(lista1.imprimir());
		System.out.println(lista2.imprimir());
		
		System.out.println("Digite o processo que deseja fazer com esta lista: ");
		System.out.println("1 - Concatenar listas");
		System.out.println("2 - Separar uma lista em duas");
		System.out.println("3 - Intercalar duas listas");

		int opcoes = sc.nextInt();
		switch (opcoes) {
		case 1:
			lista1.concatenar(lista2);
			lista2.esvaziaLista();
			System.out.println("A lista concatenada tem o resultado de: " + lista1.imprimir());
			System.out.println(lista2.imprimir());
			break;
			
		case 2: 
			System.out.println("A partir de qual posição deve se separar?");
			int posicao = sc.nextInt();
			ListaDupla[] listas = lista1.separa(posicao);
			System.out.println("Lista 1: " + listas[0].imprimir());
			System.out.println("Lista 2: " + listas[1].imprimir());
			break;
		case 3:
			ListaDupla listaIntercalada = new ListaDupla();
		    listaIntercalada.intercalar(lista1, lista2);
		    System.out.println("A lista intercalada tem o resultado de: " + listaIntercalada.imprimir());
		}
		sc.close();
	}

}
