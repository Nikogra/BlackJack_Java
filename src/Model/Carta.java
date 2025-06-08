package Model;

public class  Carta {
    private  int val,val_opt;
    private  final  TYPE tipo;
    private  final FIGURE figura;
    private  String id;
    private boolean trocou = false;

    public Carta(int val, TYPE tipo, FIGURE figura) {
        this.val = val;
        this.tipo = tipo;
        this.figura = figura;
        id = switch (tipo) {
            case PAUS-> "P";
            case ESPADAS -> "E";
            case COPAS -> "C";
            case OUROS -> "O";
        };
        if(figura.equals(FIGURE.VALETE)||figura.equals(FIGURE.DAMA)||figura.equals(FIGURE.REI)) {
            setVal(10);
        }
        if(figura.equals(FIGURE.AS)) {
            val_opt=1;
            setVal(11);
        }
    }

    public void setVal(int v) {
        this.val = v;
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
        String fig=switch (figura){
                case REI -> "r";
                case DAMA -> "d";
                case VALETE -> "v";
                case AS -> "a";
                case NUM2,
                     NUM3,
                     NUM4,
                     NUM5,
                     NUM6,
                     NUM7,
                     NUM8,
                     NUM9,
                     NUM10 ->"n";
        };
        if(!this.getFigura().equals(FIGURE.AS)) {
            return id = id + fig + val;
        }else{
            return id+=fig+ String.valueOf(val)+'/'+ String.valueOf(val_opt);
        }
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
