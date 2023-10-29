package SistemaEleitoral;

import java.util.Date;

public abstract class Candidato {
    
    private String name;
    private Date dataNascimento;
    private Partido partido;
    private TipoCandidato tipoCandidato;
    private Boolean participou_Federacao;

    public Candidato(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
