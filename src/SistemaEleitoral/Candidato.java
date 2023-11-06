package SistemaEleitoral;

import java.time.LocalDate;

public class Candidato {
    
    private int cd_cargo;
    private int cd_situacao_candidato_tot;
    private int nr_candidato;
    private String nm_urna_candidato;
    private int nr_partido;
    private String sg_partido;
    private int nr_federacao;
    private LocalDate dt_nascimento;
    private int cd_sit_tot_turno;
    private int cd_genero;
    private String nm_tipo_destinacao_votos;

    public Candidato(int cd_cargo, int cd_situacao_candidato_tot, int nr_candidato, String nm_urna_candidato, int nr_partido, String sg_partido, int nr_federacao, LocalDate dt_nascimento, int cd_sit_tot_turno, int cd_genero, String nm_tipo_destinacao_votos) {
        this.cd_cargo = cd_cargo;
        this.cd_situacao_candidato_tot = cd_situacao_candidato_tot;
        this.nr_candidato = nr_candidato;
        this.nm_urna_candidato = nm_urna_candidato;
        this.nr_partido = nr_partido;
        this.sg_partido = sg_partido;
        this.nr_federacao = nr_federacao;
        this.dt_nascimento = dt_nascimento;
        this.cd_sit_tot_turno = cd_sit_tot_turno;
        this.cd_genero = cd_genero;
        this.nm_tipo_destinacao_votos = nm_tipo_destinacao_votos;
    }

    public int getCd_cargo() {
        return cd_cargo;
    }
    public int getCd_cargo_situacao_tot() {
        return cd_situacao_candidato_tot;
    }
    public int getNr_candidato() {
        return nr_candidato;
    }
    public String getNm_urna_candidato() {
        return nm_urna_candidato;
    }
    public int getNr_partido() {
        return nr_partido;
    }
    public String getSg_partido() {
        return sg_partido;
    }
    public int getNr_federacao() {
        return nr_federacao;
    }
    public LocalDate getDt_nascimento() {
        return dt_nascimento;
    }
    public int getCd_sit_tot_turno() {
        return cd_sit_tot_turno;
    }
    public int getCd_genero() {
        return cd_genero;
    }
    public String getNm_tipo_destinacao_votos() {
        return nm_tipo_destinacao_votos;
    }

     private int qtd_votos = 0;
     private int idade = 0;

     public void setIdade(LocalDate data_eleicao) {
         this.idade = data_eleicao.getYear() - this.dt_nascimento.getYear();
     }

     public void addVoto() {
         this.qtd_votos++;
     }
     public int getQtd_votos() {
         return qtd_votos;
     }

    @Override
    public String toString() {
        return this.nm_urna_candidato + " (" + this.sg_partido + ", " + this.qtd_votos + ")";
    }
}
