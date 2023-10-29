package SistemaEleitoral;

import java.util.HashMap;
import java.util.Map;

public class Partido {

    private String name;
    private Map<String, Candidato> candidatos = new HashMap<String, Candidato>();

    public void addCandidato(Candidato candidato) {
        this.candidatos.put(candidato.getName(), candidato);
    }

    public Candidato getCandidato(String name) {
        return this.candidatos.get(name);
    }

    public Partido(String name) {
        this.name = name;
    }
    public String getName() {
        return this.name;
    }

}
