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
        CSVCandidatosReader.candidatosReader(args[0],args[1],args[3], candidatos);
        CSVVotacaoReader.votacaoReader(args[2]);
        int i = 1;
        System.out.println("Deuputados " + args[0] + " eleitos:");
        for(Candidato candidato : candidatos.values()){
            if(candidato.getCd_sit_tot_turno() == 2 || candidato.getCd_sit_tot_turno() == 3)
            {  
                System.out.println(i + " - " + candidato);
                i++;
            }
        }

        System.out.println(args[0]);
        
        //printRelatorioIdade(candidatos, i);
}
}
