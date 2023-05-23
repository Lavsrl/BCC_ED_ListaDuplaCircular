package listaDuplamenteEncadeadaAtividade;

public class Celula {
	Celula proxima; //Aponta para a proxima celular
	Celula anterior; // Aponta para a celula anterior
	Object elemento; //Objeto armazenado
	
    public Celula() {
        this.proxima = null;
        this.anterior = null;
        this.elemento = null;
    }
	
	Celula(Celula proxima, Object elemento){
		this.proxima = proxima;
		this.anterior = null;
		this.elemento = elemento;
	}
	
	Celula(Celula proxima, Celula anterior, Object elemento){
		this.proxima = proxima;
		this.anterior = anterior;
		this.elemento = elemento;
	}
	
	Celula(Object elemento){
		this.proxima = null;
		this.anterior = null;
		this.elemento = elemento;
	}

	public Celula getProxima() {
		return proxima;
	}

	public void setProxima(Celula proxima) {
		this.proxima = proxima;
	}

	public Celula getAnterior() {
		return anterior;
	}

	public void setAnterior(Celula anterior) {
		this.anterior = anterior;
	}

	public Object getElemento() {
		return elemento;
	}

	public void setElemento(Object elemento) {
		this.elemento = elemento;
	}
}
