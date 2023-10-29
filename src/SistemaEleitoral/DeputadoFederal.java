package SistemaEleitoral;

import java.time.LocalDate;

public class DeputadoFederal extends Candidato {
    

    public DeputadoFederal(String name, LocalDate dataNascimento) {
        super(name, dataNascimento);
    }

    public String toString() {
        return this.getName();
    }
}
