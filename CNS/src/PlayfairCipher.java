import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashSet;

class PlayfairCipher
{
    int length = 0;
    int [][] matrix = new int[5][5];

    public static void main(String[] args)throws Exception {

        PlayfairCipher plc = new PlayfairCipher();
        File file = new File("C:\\Users\\91721\\IdeaProjects\\CNS\\src\\input.txt");

        BufferedReader brf = new BufferedReader(new FileReader(file));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter plain text:");
        StringBuilder input = new StringBuilder(brf.readLine());


        System.out.println("Enter key:");
        String key = br.readLine();
        System.out.println("Key: "+key);
        HashSet<Character> hs = new HashSet<>();
        char [][] matrix = new char[5][5];
        int i=0,j=0;
        for(char c:key.toCharArray())
        {
            hs.add(c);
            matrix[i][j] = c;
            j++;
            if(j>=5)
            {
                i++;
                j=0;
            }
        }

        hs.add('j');
        char c = 65;
        for(int k=i;k<5;k++)
        {
            for(int l=j;l<5;l++)
            {

                while(hs.add(c)==false )
                {
                    c++;
                }

                matrix[k][l] = c;
            }
            j=0;
        }

        for(int x=0;x<5;x++)
        {
            for(int y=0;y<5;y++)
            {
                System.out.print(matrix[x][y]+" ");
            }
            System.out.println();
        }

        String encryptedString = plc.cipher(input.toString().toUpperCase());
        System.out.println("Encrypted string is:"+encryptedString);

    }
    String cipher(String in)
    {
        length = (int) in.length() / 2 + in.length() % 2;
        for(int i = 0; i < (length - 1); i++)
        {
            if(in.charAt(2 * i) == in.charAt(2 * i + 1))
            {
                in = new StringBuffer(in).insert(2 * i + 1, 'X').toString();
                length = (int) in.length() / 2 + in.length() % 2;
            }
        }
        String[] digraph = new String[length];
        for(int j = 0; j < length ; j++)
        {
            if(j == (length - 1) && in.length() / 2 == (length - 1))
                in = in + "X";
            digraph[j] = in.charAt(2 * j) +""+ in.charAt(2 * j + 1);
        }
        String out = "";
        String[] encDigraphs = new String[length];
        encDigraphs = encodeDigraph(digraph);
        for(int k = 0; k < length; k++)
            out = out + encDigraphs[k];
        return out;
    }
    Point getPoint(char c)
    {
        Point pt = new Point(0,0);
        for(int i = 0; i < 5; i++)
            for(int j = 0; j < 5; j++)
                if(c == matrix[i][j])
                    pt = new Point(i,j);
        return pt;
    }
    String[] encodeDigraph(String di[])
    {
        String[] encipher = new String[length];
        for(int i = 0; i < length; i++)
        {
            char a = di[i].charAt(0);
            char b = di[i].charAt(1);
            int r1 = (int) getPoint(a).getX();
            int r2 = (int) getPoint(b).getX();
            int c1 = (int) getPoint(a).getY();
            int c2 = (int) getPoint(b).getY();

            if(r1 == r2)
            {
                c1 = (c1 + 1) % 5;
                c2 = (c2 + 1) % 5;
            }

            else if(c1 == c2)
            {
                r1 = (r1 + 1) % 5;
                r2 = (r2 + 1) % 5;
            }

            else
            {
                int temp = c1;
                c1 = c2;
                c2 = temp;
            }

            encipher[i] = matrix[r1][c1] + "" + matrix[r2][c2];
        }
        return encipher;
    }

}