package chaining;
import java.util.*;

public class hashtable 
{
    private LinkedList<storedemployee>[] hashtable;
    
    hashtable()
    {
        hashtable = new LinkedList[10];
        for(int i = 0; i < hashtable.length; i++)
        {
            hashtable[i] = new LinkedList<storedemployee>(); 
        }
    }
    
    private int hashkey(String key)
    {
        //return key.length() % hashtable.length;
        return Math.abs(key.hashCode() % hashtable.length);  //using inbuilt hash function of JDK - more efficient
    }
    
    public void put(String key, employee emp)
    {
        int hashedkey = hashkey(key);
        hashtable[hashedkey].add(new storedemployee(key,emp));
    }
    
    public employee gets(String key)
    {
        int hashedkey = hashkey(key);
        ListIterator itr = hashtable[hashedkey].listIterator();
        storedemployee emp = null;
        while(itr.hasNext())
        {
            emp = (storedemployee) itr.next();
            if(emp.key.equalsIgnoreCase(key))
                return emp.emp;
        }
        
        return null;
    }
    
    public employee deletee(String key)
    {
        int index = 0;
        int hashedkey = hashkey(key);
        ListIterator itr = hashtable[hashedkey].listIterator();
        storedemployee emp = null;
        while(itr.hasNext())
        {
            emp = (storedemployee) itr.next();
            index++;
            if(emp.key.equalsIgnoreCase(key))
                break;
        }
        
        if(emp == null)
            return null;
        else
        {
            //done index-1 since index is starting from 0 and incrementing to 1 in 1st iteration which should not be done
            hashtable[hashedkey].remove(index-1);
            return emp.emp;
        }
        
    }
    
    public void printtable()
    {
        for(int i = 0; i < hashtable.length; i++)
        {
            if(hashtable[i].isEmpty())
                System.out.println("Position " + i + ": empty");
            else
            {
                System.out.print("Position " + i + ": ");
                ListIterator itr = hashtable[i].listIterator();
                while(itr.hasNext())
                {
                    storedemployee emp = (storedemployee) itr.next();
                    System.out.print(emp.emp.toString());
                    System.out.print(" <=> ");
                }
                System.out.print("null");
                System.out.println("");
            }
        }
    }
    
    public static void main(String args[])
    {
        hashtable h = new hashtable();
        employee emp1 = new employee("Jake",1);
        employee emp2 = new employee("Amy",2);
        employee emp3 = new employee("Terry",3);
        employee emp4 = new employee("Rosa",4);
        employee emp5 = new employee("Charles",5);
        
        h.put("jake",emp1);
        h.put("amy",emp2);
        h.put("terry", emp3);
        h.put("rosa", emp4);                
        h.put("charles", emp5);
        
        h.printtable();
        
        System.out.println("Retrieved value for terry: "+ h.gets("terry"));
        System.out.println("Retrieved value for rosa: "+ h.gets("rosa"));
        
        System.out.println("Deleted value: " + h.deletee("jake"));
        h.printtable();
    }
}