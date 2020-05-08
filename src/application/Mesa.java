package application;

public class Mesa extends Thread {
	private int numCadeiras;
	private int numLivres;
	private boolean bebendo;
	
	public Mesa(int numCadeiras) {
		this.numCadeiras = numCadeiras;
		this.setNumLivres(numCadeiras);
	}

	public int getNumCadeiras() {
		return numCadeiras;
	}

	public void setNumCadeiras(int numCadeiras) {
		this.numCadeiras = numCadeiras;
	}
	
	public boolean isBebendo() {
		return this.bebendo;
	}

	public void setBebendo(boolean bebendo) {
		this.bebendo = bebendo;
	}

	public int getNumLivres() {
		return numLivres;
	}

	public void setNumLivres(int numLivres) {
		this.numLivres = numLivres;
	} 	
	
	public boolean insereCliente(int numLivres) {
		if (numLivres == 0) {
			return false;
		}
		else {
			numLivres --;
			setBebendo(true);
			return true;
		}
	}
	
	public boolean removeCliente(int numLivres) {
		if (numLivres == numCadeiras) {
			return false;
		} 
		if (numLivres == numCadeiras - 1) {
			setBebendo(false);
		}  
		numLivres++;
		return true;
	}
}
