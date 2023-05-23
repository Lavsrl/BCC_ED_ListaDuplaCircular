package listaDuplamenteEncadeadaAtividade;

public class ListaDuplaCircular {
	private Celula cabeca;
	private int totalDeElementos;

	public ListaDuplaCircular() {
		cabeca = null;
		totalDeElementos = 0;
	}

	//QUESTAO A 
	public int tamanho() {
		return (this.totalDeElementos);
	}

	//QUESTAO B
	public void inserirAEsquerda(Object elemento) {
		Celula novaCelula = new Celula(null, null, elemento);

		if (cabeca == null) {
			cabeca = novaCelula;
			novaCelula.setProxima(cabeca);
			novaCelula.setAnterior(cabeca);
		} else {
			novaCelula.setProxima(cabeca);
			novaCelula.setAnterior(cabeca.getAnterior());
			cabeca.getAnterior().setProxima(novaCelula);
			cabeca.setAnterior(novaCelula);
			cabeca = novaCelula;
		}

		totalDeElementos++;
	}

	public void inserirADireita(Object elemento) {
		Celula novaCelula = new Celula(null, null, elemento);

		if (cabeca == null) {
			cabeca = novaCelula;
			novaCelula.setProxima(cabeca);
			novaCelula.setAnterior(cabeca);
		} else {
			Celula ultimaCelula = cabeca.getAnterior();

			ultimaCelula.setProxima(novaCelula);
			novaCelula.setAnterior(ultimaCelula);
			novaCelula.setProxima(cabeca);
			cabeca.setAnterior(novaCelula);
		}

		totalDeElementos++;
	}
	
	
	//QUESTAO C
	public void concatenar(ListaDuplaCircular lista) {
		if (lista.totalDeElementos == 0) {
			throw new IllegalArgumentException("Não há valores para adicionar");
		}

		ListaDuplaCircular listaCopia = lista.copiar();

		if (this.totalDeElementos == 0) {
			this.cabeca = listaCopia.cabeca;
		} else {
			Celula ultimaListaAtual = this.cabeca.getAnterior();
			Celula primeiraListaNova = listaCopia.cabeca;
			Celula ultimaListaNova = listaCopia.cabeca.getAnterior();

			ultimaListaAtual.setProxima(primeiraListaNova);
			primeiraListaNova.setAnterior(ultimaListaAtual);
			ultimaListaNova.setProxima(this.cabeca);
			this.cabeca.setAnterior(ultimaListaNova);
		}

		this.totalDeElementos += listaCopia.totalDeElementos;
	}

	//QUESTAO D
	public void intercalar(ListaDuplaCircular lista1, ListaDuplaCircular lista2) {
		if (lista1.cabeca != null && lista2.cabeca != null) {
			ListaDuplaCircular lista1Copia = lista1.copiar();
			ListaDuplaCircular lista2Copia = lista2.copiar();

			Celula celulaLista1 = lista1Copia.cabeca;
			Celula celulaLista2 = lista2Copia.cabeca;

			while (celulaLista1.getProxima() != lista1Copia.cabeca && celulaLista2.getProxima() != lista2Copia.cabeca) {
				inserirADireita(celulaLista1.getElemento());
				celulaLista1 = celulaLista1.getProxima();

				inserirADireita(celulaLista2.getElemento());
				celulaLista2 = celulaLista2.getProxima();
			}

			inserirADireita(celulaLista1.getElemento());
			inserirADireita(celulaLista2.getElemento());
		}
	}

	//QUESTAO E
	public ListaDuplaCircular copiar() {
		ListaDuplaCircular listaCopia = new ListaDuplaCircular();

		if (cabeca != null) {
			Celula atual = cabeca;

			do {
				listaCopia.inserirADireita(atual.getElemento());
				atual = atual.getProxima();
			} while (atual != cabeca);
		}

		return listaCopia;
	}

	public void imprimir() {
		if (this.totalDeElementos == 0) {
			System.out.println("[]");
			return;
		} else {
			Celula atual = this.cabeca;
			System.out.print("[ ");
			do {
				System.out.print(atual.getElemento() + " ");
				atual = atual.getProxima();
			} while (atual != this.cabeca);
			System.out.print("]");
			System.out.println();
		}
	}

}