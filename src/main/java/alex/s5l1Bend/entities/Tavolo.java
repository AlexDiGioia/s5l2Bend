package alex.s5l1Bend.entities;

import lombok.Data;

@Data
public class Tavolo {
    private final int nTavolo;
    private final int maxCoperti;
    private boolean occupato;

    public Tavolo(int tableNumber, int maxCoperti) {
        this.nTavolo = tableNumber;
        this.maxCoperti = maxCoperti;
        this.occupato = false;
    }

    public void occupa() {
        this.occupato = true;
    }

    public void libera() {
        this.occupato = false;
    }
}
