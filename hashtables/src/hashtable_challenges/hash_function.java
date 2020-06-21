package hashtable_challenges;


public class hash_function 
{
    public static void main(String args[])
    {
        int[] num = new int[10];
        int[] numToAdd = {59382, 43, 6894, 500, 99, -58};
        for(int  i = 0; i < numToAdd.length; i++)
            num[hash(numToAdd[i])] = numToAdd[i];
        
        for(int i = 0; i < num.length; i++)
        {
            System.out.println(num[i]);
        }
    }
    
    
    public static int hash(int value)
    {
        String v = ""+value;
        int length = v.length();
        
        return Math.abs(value % (int) 10);
        //System.out.println(key);
    }
}
