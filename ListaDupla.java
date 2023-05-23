package listaDuplamenteEncadeadaAtividade;

public class ListaDupla {
	Celula primeira;
	Celula ultima;
	int totalDeElementos = 0;

	boolean posicaoOcupada(int pos) {
		return((pos >= 0)&&(pos < this.totalDeElementos));
	}
	
	Celula pegaCelula(int pos) {
		if(!this.posicaoOcupada(pos)) {
			throw new IllegalArgumentException("Posicao nao existe");
		} else {
			Celula atual = this.primeira;
			for(int i = 0; i < pos; i++) {
				atual = atual.getProxima();
			}
			return(atual);
		}
	}
	

	Object pega(int pos) {
		return(this.pegaCelula(pos).getElemento());
	}

	void adicionaNoComeco(Object elemento) {
		if(this.totalDeElementos == 0) {
			Celula nova = new Celula(elemento);
			this.primeira = nova;
			this.ultima = nova;
		} else {
			Celula nova = new Celula(this.primeira, elemento);
			this.primeira.setAnterior(nova);
			this.primeira = nova;
		}
		this.totalDeElementos++;
	}
	
	void adiciona(Object elemento) {
		if(this.totalDeElementos == 0) {
			this.adicionaNoComeco(elemento);
		} else {
			Celula nova = new Celula(elemento);
			this.ultima.setProxima(nova);
			nova.setAnterior(this.ultima);
			this.ultima = nova;
			this.totalDeElementos++;	
		}
	}
	
	//QUESTAO A
	void concatenar(ListaDupla lista) {
		if(lista.totalDeElementos == 0){
			throw new IllegalArgumentException("Não há valores para adicionar");
		} else if (this.totalDeElementos == 0){
			this.primeira = lista.primeira;
		} else {
			this.ultima.setProxima(lista.primeira);
			lista.primeira.setAnterior(ultima);
			this.ultima = lista.ultima;
			this.totalDeElementos += lista.totalDeElementos;
		}
	}

	//QUESTAO B
	ListaDupla[] separa(int pos) {
	    if (!this.posicaoOcupada(pos)) {
	        throw new IllegalArgumentException("Posicao nao existe");
	    }

	    ListaDupla[] listas = new ListaDupla[2];
	    listas[0] = new ListaDupla();
	    listas[1] = new ListaDupla();

	    int contador = 0;
	    Celula atual = this.primeira;

	    while (contador < pos) {
	        listas[0].adiciona(atual.getElemento());
	        atual = atual.getProxima();
	        contador++;
	    }

	    while (atual != null) {
	        listas[1].adiciona(atual.getElemento());
	        atual = atual.getProxima();
	    }

	    return listas;
	}
	
	//QUESTAO C
	void intercalar(ListaDupla lista1, ListaDupla lista2) {
	    ListaDupla listaIntercalada = new ListaDupla();

	    Celula atualLista1 = lista1.primeira;
	    Celula atualLista2 = lista2.primeira;

	    while (atualLista1 != null && atualLista2 != null) {
	        int valorLista1 = (int) atualLista1.getElemento();
	        int valorLista2 = (int) atualLista2.getElemento();

	        if (valorLista1 < valorLista2) {
	            listaIntercalada.adiciona(valorLista1);
	            atualLista1 = atualLista1.getProxima();
	        } else {
	            listaIntercalada.adiciona(valorLista2);
	            atualLista2 = atualLista2.getProxima();
	        }
	    }

	    while (atualLista1 != null) {
	        listaIntercalada.adiciona((int) atualLista1.getElemento());
	        atualLista1 = atualLista1.getProxima();
	    }

	    while (atualLista2 != null) {
	        listaIntercalada.adiciona((int) atualLista2.getElemento());
	        atualLista2 = atualLista2.getProxima();
	    }

	    this.primeira = listaIntercalada.primeira;
	    this.ultima = listaIntercalada.ultima;
	    this.totalDeElementos = listaIntercalada.totalDeElementos;
	}

	void adiciona(int pos, Object elemento) {
		if(pos == 0) {
			this.adicionaNoComeco(elemento);
		} else if (pos == this.totalDeElementos) {
			this.adiciona(elemento);
		} else {
			Celula anterior = this.pegaCelula(pos-1);
			Celula proxima = anterior.getProxima();
			Celula nova = new Celula(anterior.getProxima(), elemento);
			nova.setAnterior(anterior);
			anterior.setProxima(nova);
			proxima.setAnterior(nova);
			this.totalDeElementos++;
		}
	}

	//Remove Celulas no comeco da lista
	void removeDoComeco() {
		if(!this.posicaoOcupada(0)) {
			throw new IllegalArgumentException("Posicao nao existe");
		} else {
			this.primeira = this.primeira.getProxima();
			this.totalDeElementos--;
			this.primeira.setAnterior(null);
		}
		if(this.totalDeElementos == 0) {
			this.ultima = null;
		}
	}

	void removeDoFim() {
		if(!this.posicaoOcupada(totalDeElementos - 1)) {
			throw new IllegalArgumentException("Posicao nao existe");
		} else {
			if(this.totalDeElementos == 1) {
				this.removeDoComeco();
			} else {
				Celula penultima = this.ultima.getAnterior();
				penultima.setProxima(null);
				this.ultima = penultima;
				this.totalDeElementos--;
			}
		}
	}
	
	void remove(int pos) {
		if(!this.posicaoOcupada(pos)) {
			throw new IllegalArgumentException("Posicao nao existe");
		} else {
			if(pos == 0) {
				this.removeDoComeco();
			} else if(pos == this.totalDeElementos - 1) {
				this.removeDoFim();
			} else {
				Celula anterior = this.pegaCelula(pos -1);
				Celula atual = anterior.getProxima();
				Celula proxima = atual.getProxima();
				anterior.setProxima(proxima);
				proxima.setAnterior(anterior);
				this.totalDeElementos--;	
			}
		}
	}

	boolean contem(Object elemento) {
		Celula atual = this.primeira;
		while(atual != null) {
			if(atual.getElemento().equals(elemento)) {
				return true;
			}
			atual = atual.getProxima();
		}
		return false;
	}

	int tamanho() {
		return(this.totalDeElementos);
	}

	void esvaziaLista() {
		this.primeira = null;
		this.ultima = null;
		this.totalDeElementos = 0;
	}

	String imprimir() {
		if(this.totalDeElementos == 0) {
			return("[]");
		} else {
			StringBuilder builder = new StringBuilder("[");
			Celula atual = this.primeira;
			for(int i = 0; i < this.totalDeElementos - 1; i++) {
				builder.append(atual.getElemento());
				builder.append(", ");
				atual = atual.getProxima();
			}
			builder.append(atual.getElemento());
			builder.append("]");
			return(builder.toString());
		}
	}
	
}
