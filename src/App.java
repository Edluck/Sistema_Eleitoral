import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import CSVReader.CSVCandidatosReader;
import CSVReader.CSVVotacaoReader;
import SistemaEleitoral.Candidato;


public class App {
    public static void main(String[] args) throws FileNotFoundException {
        //retirando os tracos do argumento de deputados
        args[0] = args[0].replace("-","");
        Map<Integer, Candidato> candidatos = new HashMap<Integer, Candidato>();
        CSVCandidatosReader.candidatosReader(args[1],args[0]);
        CSVVotacaoReader.votacaoReader(args[2]);


        
}
}
