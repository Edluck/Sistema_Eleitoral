package SistemaEleitoral;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Candidato {

    private int cd_cargo;
    private int cd_situacao_candidato_tot;
    private int nr_candidato;
    private String nm_urna_candidato;
    private int nr_partido;
    private String sg_partido;
    private int nr_federacao;
    private String dt_nascimento;
    private int cd_sit_tot_turno;
    private int cd_genero;
    private String nm_tipo_destinacao_votos;

    public Candidato(int cd_cargo, int cd_situacao_candidato_tot, int nr_candidato, String nm_urna_candidato,
            int nr_partido, String sg_partido, int nr_federacao, String dt_nascimento, int cd_sit_tot_turno,
            int cd_genero, String nm_tipo_destinacao_votos) {
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

    public int getCd_situacao_candidato_tot() {
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

    public String getDt_nascimento() {
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

    public void setIdade(String dataEleicao) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        CharSequence dt_nascimento_seq = this.dt_nascimento;
        LocalDate dataNascimento = LocalDate.parse(dt_nascimento_seq, formatter);
        LocalDate dataEleicaoLocalDate = LocalDate.parse(dataEleicao, formatter);
        Period periodo = Period.between(dataNascimento, dataEleicaoLocalDate);
        this.idade = periodo.getYears();
    }

    public int getIdade() {
        return this.idade;
    }

    public void addVotos(int n_votos) {
        this.qtd_votos += n_votos;
    }

    public int getQtd_votos() {
        return qtd_votos;
    }

    @Override
    public String toString() {
        DecimalFormat format = new DecimalFormat("#,###");
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator('.');
        format.setDecimalFormatSymbols(symbols);

        String plural_votos = "";

        if (this.qtd_votos > 1) {
            plural_votos = "s";
        }

        return this.nm_urna_candidato + " (" + this.sg_partido + ", " + format.format(this.qtd_votos) + " voto"
                + plural_votos + ")";
    }
}