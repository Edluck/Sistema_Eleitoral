package SistemaEleitoral;

import java.time.LocalDate;

public class DeputadoEstadua extends Candidato {
    

    public DeputadoEstadua(String name, LocalDate dataNascimento) {
        super(name, dataNascimento);
    }
    public String toString() {
        return this.getName();
    }
}
