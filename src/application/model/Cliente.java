package application.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Cliente{
	
    private final StringProperty id;
    private final StringProperty tempoBar;
    private final StringProperty tempoCasa;
    
    public Cliente() {
        this(null, null, null);
    }
	
    public Cliente(String id, String tempoBar, String tempoCasa) {
        this.id = new SimpleStringProperty(id);
        this.tempoBar = new SimpleStringProperty(tempoBar);
        this.tempoCasa = new SimpleStringProperty(tempoCasa);
    }

	public StringProperty getId() {
		return id;
	}

	public StringProperty getTempoBar() {
		return tempoBar;
	}

	public StringProperty getTempoCasa() {
		return tempoCasa;
	}
}
