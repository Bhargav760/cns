import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.*;
class RailFenceBasic{
    int depth;
    String Encryption(String plainText,int depth)throws Exception
    {
        int r=depth,len=plainText.length();
        int c=len/depth;
        char mat[][]=new char[r][c];
        int k=0;

        String cipherText="";

        for(int i=0;i< c;i++)
        {
            for(int j=0;j< r;j++)
            {
                if(k!=len)
                    mat[j][i]=plainText.charAt(k++);
                else
                    mat[j][i]='X';
            }
        }
        for(int i=0;i< r;i++)
        {
            for(int j=0;j< c;j++)
            {
                cipherText+=mat[i][j];
            }
        }
        return cipherText;
    }


    String Decryption(String cipherText,int depth)throws Exception
    {
        int r=depth,len=cipherText.length();
        int c=len/depth;
        char mat[][]=new char[r][c];
        int k=0;

        String plainText="";


        for(int i=0;i< r;i++)
        {
            for(int j=0;j< c;j++)
            {
                mat[i][j]=cipherText.charAt(k++);
            }
        }
        for(int i=0;i< c;i++)
        {
            for(int j=0;j< r;j++)
            {
                plainText+=mat[j][i];
            }
        }

        return plainText;
    }
}

class RailFence{
    public static void main(String args[])throws Exception
    {
        RailFenceBasic rf=new RailFenceBasic();
        Scanner scn=new Scanner(System.in);
        int depth;

        String cipherText,decryptedText;

        File file = new File("C:\\Users\\91721\\IdeaProjects\\CNS\\src\\input.txt");

        BufferedReader brf = new BufferedReader(new FileReader(file));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter plain text:");
        StringBuilder plainText = new StringBuilder(brf.readLine());


        System.out.println("Enter depth for Encryption:");
        depth=scn.nextInt();

        cipherText=rf.Encryption(plainText.toString(),depth);
        System.out.println("Encrypted text is:\n"+cipherText);

        decryptedText=rf.Decryption(cipherText, depth);

        System.out.println("Decrypted text is:\n"+decryptedText);

    }
}