package br.feevale.utils;

public class Fatorial {
	
	private int nro;
	private long fatorial;
	private String msgErro;
	
	public Fatorial( int nro ) {
		
		this.fatorial = 1;
		this.nro = nro;
		
		if( nro > 0 && nro < 17 ) {
			while( nro > 1 ) {
				this.fatorial *= nro--;
			}
		} else {
			msgErro = "Só posso calcular fatorias de números entre 1 e 17";
		}
	}
	
	public int getNro() {
		return nro;
	}
	
	public long getFatorial() {
		return fatorial;
	}
	
	public String getMsgErro() {
		return msgErro;
	}
	
	public boolean isFatorialOK() {
		return msgErro == null;
	}

	@Override
	public String toString() {

		if( isFatorialOK() ) {
			return Long.toString( fatorial );
		} else {
			return msgErro;
		}
	}
}


