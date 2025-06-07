package Model;

public class Carta {
    private int val,val_opt;
    private final TYPE tipo;
    private final FIGURE figura;
    private String id;

    public Carta(int val, TYPE tipo, FIGURE figura) {
        this.val = val;
        this.tipo = tipo;
        this.figura = figura;
        this.id = switch (tipo) {
            case PAUS-> "P";
            case ESPADAS -> "E";
            case COPAS -> "C";
            case OUROS -> "O";
        };
        if(figura.equals(FIGURE.VALETE)||figura.equals(FIGURE.DAMA)||figura.equals(FIGURE.REI)) {
            this.val=10;
        }
        if(figura.equals(FIGURE.AS)) {
            this.val_opt=1;
            this.val=11;
        }
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TYPE getTipo() {
        return tipo;
    }

    public FIGURE getFigura() {
        return figura;
    }

    public String getId() {
        String fig=switch (this.getFigura()){
                case REI -> "r";
                case DAMA -> "d";
                case VALETE -> "v";
                case AS -> "a";
                case NUM ->"n";
        };
        if(!this.getFigura().equals(FIGURE.AS)) {
            return this.id+=fig+val;
        }else{
            return this.id+=fig+val+'/'+val_opt;
        }

    }


}
