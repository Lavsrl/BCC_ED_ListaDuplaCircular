package listaDuplamenteEncadeadaAtividade;

public class ListaDuplaCabeca {
	Celula cabeca;
	int totalDeElementos;

	public ListaDuplaCabeca() {
	        this.cabeca = new Celula();
	        this.totalDeElementos = 0;
	    }

	boolean posicaoOcupada(int pos) {
		return (pos >= 0 && pos < this.totalDeElementos);
	}

	Celula pegaCelula(int pos) {
		if (!this.posicaoOcupada(pos)) {
			throw new IllegalArgumentException("Posicao nao existe");
		} else {
			Celula atual = this.cabeca.getProxima();
			for (int i = 0; i < pos; i++) {
				atual = atual.getProxima();
			}
			return atual;
		}
	}

	Object pega(int pos) {
		return this.pegaCelula(pos).getElemento();
	}

	void adicionaNoComeco(Object elemento) {
		Celula nova = new Celula(this.cabeca.getProxima(), this.cabeca, elemento);
		if (this.totalDeElementos == 0) {
			this.cabeca.setProxima(nova);
		} else {
			this.cabeca.getProxima().setAnterior(nova);
			this.cabeca.setProxima(nova);
		}
		this.totalDeElementos++;
	}

	void adiciona(Object elemento) {
		if (this.totalDeElementos == 0) {
			this.adicionaNoComeco(elemento);
		} else {
			Celula nova = new Celula(null, this.cabeca, elemento);
			Celula ultima = this.cabeca.getAnterior();
			ultima.setProxima(nova);
			this.cabeca.setAnterior(nova);
			this.totalDeElementos++;
		}
	}
	
	void removeDoComeco() {
	    if (!this.posicaoOcupada(0)) {
	        throw new IllegalArgumentException("Posicao nao existe");
	    } else {
	        Celula primeira = this.cabeca.getProxima();
	        Celula proxima = primeira.getProxima();
	        this.cabeca.setProxima(proxima);
	        if (proxima != null) {
	            proxima.setAnterior(this.cabeca);
	        } else {
	            this.cabeca.setAnterior(null);
	        }
	        this.totalDeElementos--;
	    }
	    if (this.totalDeElementos == 0) {
	        this.cabeca.setAnterior(null);
	    }
	}

	void removeDoFim() {
	    if (!this.posicaoOcupada(totalDeElementos - 1)) {
	        throw new IllegalArgumentException("Posicao nao existe");
	    } else {
	        Celula ultima = this.cabeca.getAnterior();
	        Celula penultima = ultima.getAnterior();
	        penultima.setProxima(null);
	        this.cabeca.setAnterior(penultima);
	        this.totalDeElementos--;
	    }
	    if (this.totalDeElementos == 0) {
	        this.cabeca.setProxima(null);
	    }
	}

	void remove(int pos) {
	    if (!this.posicaoOcupada(pos)) {
	        throw new IllegalArgumentException("Posicao nao existe");
	    } else {
	        if (pos == 0) {
	            this.removeDoComeco();
	        } else if (pos == this.totalDeElementos - 1) {
	            this.removeDoFim();
	        } else {
	            Celula atual = this.pegaCelula(pos);
	            Celula anterior = atual.getAnterior();
	            Celula proxima = atual.getProxima();
	            anterior.setProxima(proxima);
	            proxima.setAnterior(anterior);
	            this.totalDeElementos--;
	        }
	    }
	}

}
