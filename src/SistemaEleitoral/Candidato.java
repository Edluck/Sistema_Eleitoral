package SistemaEleitoral;

import java.time.LocalDate;

public abstract class Candidato {
    
    private String name;
    private LocalDate dataNascimento;
    private Partido partido;
    private TipoCandidato tipoCandidato;
    private Boolean participou_Federacao;

    public Candidato(String name, LocalDate dataNascimento) {
        this.name = name;
        this.dataNascimento = dataNascimento;
    }

    public String getName() {
        return name;
    }

}
