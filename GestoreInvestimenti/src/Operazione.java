import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;
/**
 * Programa di gestione investimenti
 *
 * @author Nicola Cappelli
 * @version Gennaio 2025
 */
public class Operazione {
    private String ca;
    private String nome;
    private int mcIniziale;
    private int mcFinale;
    private int supply;
    private double solanaComprati;
    private double guadagno;
    private Path path = Paths.get("./GestoreInvestimenti/src/operazioniChiuse.txt");;

    public Operazione(String ca, String nome, int mciniziale, int supply, double solanaComprati, double guadagno, int mcFinale) {
        List<String> line = new ArrayList<>();
        this.ca = ca;
        this.nome = nome;
        this.mcIniziale = mciniziale;
        this.supply = supply;
        this.solanaComprati = solanaComprati;
        this.guadagno = guadagno;
        this.mcFinale = mcFinale;
        line.add(ca);
        line.add(nome);
        line.add(mciniziale+"");
        line.add(supply+"");
        line.add(solanaComprati+"");
        line.add(guadagno+"");
        line.add(mcFinale+"");
        try {
            //standard option trovato online
            Files.write(path, line, StandardOpenOption.APPEND, StandardOpenOption.CREATE);
        } catch (IOException ex) {
            System.out.println("Errore scrittura!");
        }

    }

    public double getGuadagno() {
        return guadagno;
    }

    @Override
    public String toString() {
        return "nome :" + nome + ", ca "+ca+", supply: "+supply+" solana comprati: " +" Mc iniziale: "+mcIniziale+" Mc Finale: "+mcFinale+ solanaComprati+" guadagno: "+guadagno;
    }
}