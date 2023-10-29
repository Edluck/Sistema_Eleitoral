package SistemaEleitoral;

public abstract class Candidato {
    public enum TipoCandidato {
        CD_CARGO,
        CD_SITUACAO_CANDIDATO_TOT,
        NR_CANDIDATO,
        NM_URNA_CANDIDATO,
        NR_PARTIDO,
        SG_PARTIDO,
        NR_FEFERACAO,
        DT_NASCIMENTO,
        CD_SIT_TOT_TURNO,
        CD_GENERO,
        NM_TIPO_DESTINACAO_VOTOS,
    }
    private String name;

    public Candidato(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


}
