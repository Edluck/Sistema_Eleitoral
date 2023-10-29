import CSVReader.CSVCandidatosReader;
import CSVReader.CSVVotacaoReader;

public class App {
    public static void main(String[] args) {
        CSVCandidatosReader csvCandReader = new CSVCandidatosReader();
        CSVVotacaoReader csvVotReader = new CSVVotacaoReader();
        csvCandReader.candidatosReader(args[1]);
        csvVotReader.votacaoReader(args[2]);
    
}
}
