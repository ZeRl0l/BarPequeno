package barPequeno;

public class Mesa 
{
	private int numCadeiras;
	private int numLivres;
	private boolean bebendo;
	
/* --------------------------------------------------------------------------------------------- */

	public Mesa(int numCadeiras)
	{
		this.numCadeiras = numCadeiras;
		this.numLivres = numCadeiras;
		this.bebendo = false;		
	}
	
/* --------------------------------------------------------------------------------------------- */

	public int getNumCadeiras() {
		return numCadeiras;
	}
	
/* --------------------------------------------------------------------------------------------- */

	public int getNumLivres() {
		return numLivres;
	}
	
/* --------------------------------------------------------------------------------------------- */

	public boolean isBebendo() {
		return this.bebendo;
	}
	
/* --------------------------------------------------------------------------------------------- */

	public void setNumCadeiras(int numCadeiras) {
		this.numCadeiras = numCadeiras;
	}
	
/* --------------------------------------------------------------------------------------------- */

	public void setNumLivres(int numLivres) {
		this.numLivres = numLivres;
	} 	
	
/* --------------------------------------------------------------------------------------------- */

	public void setBebendo(boolean bebendo) {
		this.bebendo = bebendo;
	}
	
/* --------------------------------------------------------------------------------------------- */

	public boolean addCliente() 
	{
		if (numLivres == 0) {
			return false;
		}
		this.numLivres--;
		
		if (numLivres == 0) {
			setBebendo(true);
		}
		return true;
	}
	
/* --------------------------------------------------------------------------------------------- */

	public boolean removeCliente() 
	{
		if (numLivres == numCadeiras) {
			return false;
		} 
		if (numLivres == numCadeiras - 1) {
			setBebendo(false);
		}  
		numLivres++;
		return true;
	}
	
/* --------------------------------------------------------------------------------------------- */

	public boolean isVazia() {
		return numLivres == numCadeiras ? true : false;
	}
	
/* --------------------------------------------------------------------------------------------- */

}
