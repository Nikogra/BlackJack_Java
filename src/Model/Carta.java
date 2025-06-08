package Model;

public class  Carta {
    private  int val,val_opt=1;
    private  final  TYPE tipo;
    private  final FIGURE figura;
    private  String id;
    private boolean trocou = false;

    public Carta(int val, TYPE tipo, FIGURE figura) {
        this.val = val;
        this.tipo = tipo;
        this.figura = figura;

        String fig = switch (figura) {
            case REI -> "r";
            case DAMA -> "d";
            case VALETE -> "v";
            case AS -> "a";
            default -> "n";
        };

        String naipe = switch (tipo) {
            case PAUS -> "P";
            case ESPADAS -> "E";
            case COPAS -> "C";
            case OUROS -> "O";
        };

        if (figura == FIGURE.AS && trocou==false) {
            this.id = naipe + fig + this.val + "/" + this.val_opt;
        } else {
            this.id = naipe + fig + this.val;
        }

        if(figura.equals(FIGURE.VALETE)||figura.equals(FIGURE.DAMA)||figura.equals(FIGURE.REI)) {
            setVal(10);
        }
        if(figura.equals(FIGURE.AS)) {
            setVal(11);
        }
    }

    public void setVal(int v) {
        this.val = v;
    }

    public void setValopt(int v) {
        this.val_opt = v;
    }

    public int getVal() {
        return val;
    }


    public TYPE getTipo() {
        return tipo;
    }

    public FIGURE getFigura() {
        return figura;
    }

    public String getId() {
        return id;
    }

    public void alteraValores(){
        if(this.getFigura().equals(FIGURE.AS)){
            trocou=true;
            val=val_opt;
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(this.getId());
        return builder.toString();
    }


}
