import java.io.FileNotFoundException;
import SistemaEleitoral.Acervo;

public class App {

    public static void main(String[] args) throws FileNotFoundException {
        //retirando os tracos do argumento de deputados
        args[0] = args[0].replace("-","");
        Acervo acervo = new Acervo(args[0],args[1], args[2], args[3]);
        acervo.geraRelatorio(args[0]);
}
}
