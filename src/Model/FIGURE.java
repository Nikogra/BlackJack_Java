package Model;

public enum FIGURE {
    REI,
    DAMA,
    VALETE,
    AS,
    NUM;

    public Carta createCard(int val, TYPE type) {
        return switch (this) {
            case REI, DAMA, VALETE, AS, NUM ->  new Carta(val, type, this);
        };
    }
}
