import java.util.ArrayList;
public class HvitRute extends Rute {

    public HvitRute(int rad, int kolonne, Labyrint lab){
        super(rad, kolonne,lab);
    }

    @Override
    public void gaa(ArrayList<Tuppel> vei, Rute veiKomFra){
        ArrayList<Tuppel> vei1 = new ArrayList<>(vei);
        vei1.add(new Tuppel(rad,kolonne));

        if(!nord.equals(veiKomFra)) nord.gaa(vei1,this); 
        if(!sor.equals(veiKomFra)) sor.gaa(vei1,this);
        if(!oest.equals(veiKomFra)) oest.gaa(vei1, this);
        if(!vest.equals(veiKomFra)) vest.gaa(vei1, this);
    }


    @Override
    public char tilTegn(){
        return '.';
    }
    
}
