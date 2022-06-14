import java.util.ArrayList;
public class Aapning extends HvitRute {

    public Aapning(int rad, int kolonne, Labyrint lab){
        super(rad, kolonne, lab);
    }

    @Override
    public void gaa(ArrayList<Tuppel> vei, Rute veiKomFra){
        ArrayList<Tuppel> vei1 = new ArrayList<>(vei);
        vei1.add(new Tuppel(rad,kolonne));

        lab.utveier.add(vei1);

    }

    
    @Override
    public char tilTegn(){
        return '0'; //der det er aapning vil det naa komme 0
    }
    
}
