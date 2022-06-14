import java.util.ArrayList;
public class SortRute extends Rute{


    public SortRute(int rad, int kolonne, Labyrint lab){
        super(rad, kolonne, lab);
    }

    @Override
    public void gaa(ArrayList<Tuppel> vei, Rute veiKomFra){
        return; 
    }

    @Override
    public char tilTegn(){
        return '#';
    }
    
}
