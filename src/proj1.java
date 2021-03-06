import java.util.*;
import java.io.*;

/**
 * Name: Izzy Hurley
 * Lab Name: proj1
 * Lab Purpose: The goal of proj1 is to create a program
 * Date: 4/1/19
 * Collaborators: None
 * ON MY HONOR: IH
 */

public class proj1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("trainingtext.txt"));
        Hashtable<String,ArrayList <String>> d = new Hashtable() ;
        //fill dictionary
        ArrayList starterKeys = new ArrayList();
        while (scanner.hasNext()) {
            String next = scanner.nextLine();
            StringTokenizer stringTokenizer = new StringTokenizer(next, " ");
            String nextS = stringTokenizer.nextToken();
            for (int i = 0; i< stringTokenizer.countTokens()-1; i++){
                String s = stringTokenizer.nextToken();
                if ((nextS.charAt(nextS.length()-1) == '.' ||
                        nextS.charAt(nextS.length()-1) == '!' ||
                        nextS.charAt(nextS.length()-1) == '?' ||
                        nextS.charAt(nextS.length()-1) == ';')
                        && java.lang.Character.isUpperCase(s.charAt(0))){
                    starterKeys.add(s);}
                if (!d.keySet().contains(nextS)){
                    ArrayList sval = new ArrayList();
                    sval.add(s);

                   d.put(nextS,sval);
                   nextS = s;
                }
                else {d.get(nextS).add(s);
                    nextS = s;
                }
            }
        }
       Object [] keys = d.keySet().toArray();

        Random r = new Random();
        Scanner userScan = new Scanner(System.in);
        System.out.println("How many words would you like to display");
        int in  = userScan.nextInt();
        String output = "";
        String lastAddKey = "";
        for (int i = in; i>0; i--){
        if (output.length() == 0 || output.charAt(output.length()-1) == '.'
                || output.charAt(output.length()-1) == '!'
                || output.charAt(output.length()-1) == '?')
        { int num = r.nextInt(starterKeys.size());
            String begin = (String)starterKeys.get(num);
            lastAddKey = begin;
        output+= " " + begin;
        int newnum = r.nextInt(d.get(lastAddKey).size());
        String nextAddkey =  d.get(lastAddKey).get(newnum);
          output+= " " + nextAddkey;
          lastAddKey = nextAddkey;


        }
            String nextAddkey = "";
        if (d.get(lastAddKey)== null){
            nextAddkey = (String)starterKeys.get(r.nextInt(starterKeys.size()));
            output += ". " + nextAddkey;
            lastAddKey = nextAddkey;
        }
int bound = d.get(lastAddKey).size()-1;

        if ((bound)<1){ nextAddkey =  d.get(lastAddKey).get(0); }
        else { int newnum = r.nextInt(d.get(lastAddKey).size());
             nextAddkey = d.get(lastAddKey).get(newnum);}
            output += " " + nextAddkey;
            lastAddKey = nextAddkey;
        }
      //  String s = (String)keys[r.nextInt(keys.length)];
       // output+= " " +s;
        System.out.println(output);
        }
       // System.out.println(output);
    }



