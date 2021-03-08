package textread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        int maxLines=100;
        String [] text = new String[maxLines];
        System.out.println("Enter line of text or stop to exit");
        int lineCounts=0;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        while(lineCounts<maxLines){
            try {
                input = reader.readLine();
                if(input.equals("stop"))
                    break;
                text[lineCounts] = input;
                lineCounts++;

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        printtext(text,lineCounts);

    }
    public static void printtext(String [] text,int count){
        for(int i=0;i<count;i++){
            System.out.println(text[i]);
        }
    }
}
