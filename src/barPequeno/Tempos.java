package barPequeno;

public class Tempos 
{
	private long tBar;
	private long tCasa;
	
/* --------------------------------------------------------------------------------------------- */

	public Tempos(long tBar, long tCasa) 
	{
		this.tBar = tBar * 1000;
		this.tCasa = tCasa * 1000;
	}
	
/* --------------------------------------------------------------------------------------------- */
	
	public long getTempoBar() {
		return this.tBar;
	}
	
/* --------------------------------------------------------------------------------------------- */

	public long getTempoCasa() {
		return this.tCasa;
	}
	
/* --------------------------------------------------------------------------------------------- */

	public void setTempoBar(long tBar) {
		this.tBar = tBar;
	}
	
/* --------------------------------------------------------------------------------------------- */

	public void setTempoCasa(long tCasa) {
		this.tCasa = tCasa;
	}
	
/* --------------------------------------------------------------------------------------------- */

}
