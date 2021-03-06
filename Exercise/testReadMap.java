import java.io.IOException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;

public class testReadMap {
    public static class TileMap {
        private String name;
        private int[][] tileMap = new int[7][13];

        public TileMap (String fileName){
            readFile(fileName);
        }

        public int[][] getTileMap() {
            return tileMap;
        }
    
        public String getName() {
            return name;
        }
    
        public void setName(String name) {
            this.name = name;
        }
    
        public void setTileMap(int[][] tileMap) {
            this.tileMap = tileMap;
        }
    
        public void readFile(String fileName) {
            try {
                BufferedReader bReader = new BufferedReader(new FileReader(fileName));

                //read first line
                String nameTile = bReader.readLine();
                setName(nameTile);
                
                //read second line, which is "the map"
                String line = bReader.readLine();
                bReader.close();
    
                //spit string, the push it into 2D integer array
                String[] mapData = line.split(" ");
                int index = 0;
                for (int i=0; i<7; i++){
                    for (int j=0; j<13; j++){
                        tileMap[i][j] = Integer.parseInt(mapData[index++]);
                    }
                }

                
            } catch (IOException e){
                System.out.println("IOException error");
            }
        }
    
        public void printMapData() {
            System.out.println(this.getName());
            for (int[] i:tileMap){
                for (int j: i){
                    System.out.print(j + " ");
                }
                System.out.println();
            }
        }    
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String fileName = sc.nextLine();
        
        TileMap mapData = new TileMap(fileName);
        
        mapData.printMapData();

        sc.close();
    }
}