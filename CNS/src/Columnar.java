import java.util.*;
import java.io.*;
import java.lang.*;

public class Columnar {
    public static void main(String[] args)throws Exception {
        Scanner scan = new Scanner(System.in);
        String line = System.getProperty("line.separator");
        scan.useDelimiter(line);


        File file = new File("C:\\Users\\91721\\IdeaProjects\\CNS\\src\\input.txt");

        BufferedReader brf = new BufferedReader(new FileReader(file));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter plain text:");
        StringBuilder plainText = new StringBuilder(brf.readLine());

        System.out.println("Enter key:");
        String key = br.readLine();
        System.out.println("Key: "+key);
        int[] arrange = arrangeKey(key);
        String encrypted = encryptCT(key, plainText.toString().toUpperCase());
        System.out.println("Encrypted string is:"+encrypted);

        System.out.println("Decrypted String is: "+decryptCT(key, encrypted));

    }

    public static String encryptCT(String key, String text) {
        int[] arrange = arrangeKey(key);

        int lenkey = arrange.length;
        int lentext = text.length();

        int row = (int) Math.ceil((double) lentext / lenkey);

        char[][] grid = new char[row][lenkey];
        int z = 0;
        for (int x = 0; x < row; x++) {
            for (int y = 0; y < lenkey; y++) {
                if (lentext == z) {
                    // at random alpha for trailing null grid
                    grid[x][y] = RandomAlpha();
                    z--;
                } else {
                    grid[x][y] = text.charAt(z);
                }

                z++;
            }
        }
        String enc = "";
        for (int x = 0; x < lenkey; x++) {
            for (int y = 0; y < lenkey; y++) {
                if (x == arrange[y]) {
                    for (int a = 0; a < row; a++) {
                        enc = enc + grid[a][y];
                    }
                }
            }
        }
        return enc;
    }

    public static String decryptCT(String key, String text) {
        int[] arrange = arrangeKey(key);
        int lenkey = arrange.length;
        int lentext = text.length();

        int row = (int) Math.ceil((double) lentext / lenkey);

        String regex = "(?<=\\G.{" + row + "})";
        String[] get = text.split(regex);

        char[][] grid = new char[row][lenkey];

        for (int x = 0; x < lenkey; x++) {
            for (int y = 0; y < lenkey; y++) {
                if (arrange[x] == y) {
                    for (int z = 0; z < row; z++) {
                        grid[z][y] = get[arrange[y]].charAt(z);
                    }
                }
            }
        }

        String dec = "";
        for (int x = 0; x < row; x++) {
            for (int y = 0; y < lenkey; y++) {
                dec = dec + grid[x][y];
            }
        }

        return dec;
    }

    public static char RandomAlpha() {
        //generate random alpha for null space
        Random r = new Random();
        return (char)(r.nextInt(26) + 'a');
    }

    public static int[] arrangeKey(String key) {
        //arrange position of grid

        HashMap<Character,Integer> hm = new HashMap<>();

        char [] keys = key.toCharArray();
        Arrays.sort(keys);
        int i = 0;
        for(Character c: keys)
        {
            hm.put(c,i++);
        }
        int[] num = new int[key.length()];
//        for (int x = 0; x < keys.length; x++) {
//            for (int y = 0; y < key.length(); y++) {
//                if (keys[x].equals(key.charAt(y) + "")) {
//                    num[y] = x;
//                    break;
//                }
//            }
//        }
        i=0;
        for(char c:key.toCharArray())
        {

            num[i] = hm.get(c);
//            System.out.print(num[i]+" ");
            i++;
        }

        return num;
    }
}
