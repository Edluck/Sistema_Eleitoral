import java.io.FileNotFoundException;
import CSVReader.CSVCandidatosReader;
import CSVReader.CSVVotacaoReader;


public class App {
    public static void main(String[] args) throws FileNotFoundException {
        CSVCandidatosReader.candidatosReader(args[1]);
        CSVVotacaoReader.votacaoReader(args[2]);
 
}
}
