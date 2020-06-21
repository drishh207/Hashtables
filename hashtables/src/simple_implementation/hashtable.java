//A very simple and basic implementation of hashtables. It doesnot take care of collisions.
package simple_implementation;

public class hashtable 
{
    employee[] hashtable;
    
    hashtable()
    {
        hashtable = new employee[10]; 
    }
    
    private int hashkey(String key)
    {
        //not an efficient hash function as this leeds to many collisions
        return key.length() % hashtable.length;
    }
    
    public void put(String key, employee emp)
    {
        int hashedkey = hashkey(key);
        //not handling collisions 
        if(hashtable[hashedkey] != null)
            System.out.println("Sorry the position " + hashedkey +" is already occupied");
        else
            hashtable[hashedkey] = emp;
    }
    
    public employee gets(String key)
    {
        int hashedkey = hashkey(key);
        return hashtable[hashedkey];
    }
    
    public void printtable()
    {
        for (employee emp : hashtable) {
            System.out.println(emp);
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
        h.put("rosa", emp4);                //will not be added in hashtable as it collides with jake (4 letter word).
        h.put("charles", emp5);
        
        h.printtable();
        
        System.out.println("retrieved value for terry: "+ h.gets("terry"));
    }
}
