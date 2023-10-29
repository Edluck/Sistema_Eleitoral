package SistemaEleitoral;

public class Partido {
    
    public enum TipoPartido {
        CD_CARGO,
        NR_NOTAVEL,
        QT_VOTOS
    }
    private String name;

    public Partido(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

}
