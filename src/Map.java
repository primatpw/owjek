import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by agungwb on 10/04/2017.
 */
public class Map {
    public static final Integer WIDTH = 100;
    public static final Integer HEIGHT = 50;
    private Character map[][] = new Character[HEIGHT][WIDTH];

    public Map() {
        initMap();
    }

    public Character get(int posI, int posJ){
        return map[posI][posJ];
    }
    
   

    public void set(Character c, int posI, int posJ){
        map[posI][posJ] = c;
    }

    private void initMap(){
        BufferedReader br = null;
        FileReader fr = null;

        try {

            fr = new FileReader("map.txt");
            br = new BufferedReader(fr);

            String currentLine;

            int i = 0;
            while ((currentLine = br.readLine()) != null) {
                for(int j = 0; j<WIDTH; j++){
                    map[i][j] = currentLine.charAt(j);
                }
                i++;
            }

        } catch (IOException e) {

            e.printStackTrace();

        } finally {

            try {

                if (br != null)
                    br.close();

                if (fr != null)
                    fr.close();

            } catch (IOException ex) {

                ex.printStackTrace();

            }

        }
    }
    
    public Character[][] getMap(){
    	return map;
    }

    public void print(){
        int jjPosAlphabet = 81;
        int jjPosNumber = 0;


        System.out.print("   ");
        for (int j = 0; j<Map.WIDTH; j++){
            if (j % 10 == 0) System.out.print((char)jjPosAlphabet++);
            else System.out.print(" ");
        }

        System.out.println();

        System.out.print("   ");
        for (int j = 0; j<Map.WIDTH; j++){
            System.out.print(jjPosNumber++);
            if (jjPosNumber >= 10) jjPosNumber = 0;
        }

        System.out.println();

        int iiPosAlphabet = 65;
        int iiPosNumber = 0;

        for (int i = 0; i<Map.HEIGHT; i++){

            if (i % 10 == 0) System.out.print((char)iiPosAlphabet++);
            else System.out.print(" ");

            System.out.print(iiPosNumber++);
            if (iiPosNumber >= 10) iiPosNumber = 0;

            System.out.print(" ");

            for (int j = 0; j<Map.WIDTH; j++){
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
    
}