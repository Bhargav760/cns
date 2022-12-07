import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.*;

public class RSA {

    static long p, q;
    static long evals[] = new long[100];
    static long dvals[] = new long[100];

    static boolean isPrime(long n)
    {
        long l = (int) Math.sqrt(n);
        for(int i=0;i<l;i++)
        {
            if(n%i == 0)
                return false;
        }
        return true;
    }

    static void calculateE()
    {
        long n = p*q;
        int k = 0;
        long d = 0;
        for(long i=2;i<n;i++)
        {
            if(n%i == 0)
                continue;
            if(isPrime(i)&&i!=p&&i!=q)
            {
                evals[k] = i;
                d = calculateD(i);
                if(d>0)
                    dvals[k] = d;
                if(k == 99)
                    break;
            }
        }
    }

    static long calculateD(long x)
    {
        long n = p*q;
        long d = 1;
        while (true)
        {
            d = d+n;
            if(d%x == 0)
            {
                return d/x;
            }
        }
    }

    String encrypt(String msg)
    {
        String encryptedMsg = "";
        int character,cipher;
        long ct = 1;
        long n = p*q;
        for(char c: msg.toCharArray())
        {
            character = c-96;
            for(int i=0;i<evals[0];i++)
            {
                ct = ct * character;
                ct = ct % n;
            }
            cipher = (char)ct+96;
            encryptedMsg += ""+cipher;
        }

        return encryptedMsg;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String msg = br.readLine();

        p = Integer.parseInt(br.readLine());
        q = Integer.parseInt(br.readLine());

        if(!isPrime(p) && !isPrime(q))
        {
            System.out.println("Wrong input");
            return;
        }



    }
}
