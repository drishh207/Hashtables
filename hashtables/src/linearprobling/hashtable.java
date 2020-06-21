package linearprobling;

public class hashtable 
{
    storedemployee[] hashtable;
    
    hashtable()
    {
        hashtable = new storedemployee[10];
    }
    
    private int hashkey(String key)
    {
        return key.length() % hashtable.length;
    }
    
    private boolean occupied(int hashedkey)
    {
        return hashtable[hashedkey] != null;
    }
    
    public void put(String key, employee emp)
    {
        int hashedkey = hashkey(key);
        if(occupied(hashedkey) == true)
        {
            int stop = hashedkey;
            if(hashedkey == hashtable.length-1)         //wrapping the hashedkey to the start as there may be space in the front
                hashedkey = 0;
            else
                hashedkey++;
            
            while(occupied(hashedkey) == true && hashedkey != stop) //till we donot get the space to put the element or the array is full
            {
                hashedkey = (hashedkey +1) % hashtable.length;      //it also wraps when we reach the last element in the array
            }                                                       //e.g. 10 % 10 = 0;    9 % 10 = 9;
        }
        
        if(occupied(hashedkey) == true)                             //if after traversing the whole array, no space is free.
            System.out.println("Array full");
        else
            hashtable[hashedkey] = new storedemployee(key,emp);
    }
    
    private int findkey(String key)
    {
        int hashedkey = hashkey(key);
        //if the key to be found is at the location where it was supposed to be, means no linear probling required
        if(hashtable[hashedkey] != null && hashtable[hashedkey].key.equalsIgnoreCase(key))
            return hashedkey;
        
        //apply linear probing
        int stop = hashedkey;
        if(hashedkey == hashtable.length-1)
            hashedkey = 0;
        else
            hashedkey++;
        
        //till either we have traversed the whole array or not encountered any null value or till we don't get the match 
        while(hashedkey != stop && hashtable[hashedkey] != null && !hashtable[hashedkey].key.equalsIgnoreCase(key))
             hashedkey = (hashedkey +1) % hashtable.length;
        
        if(stop == hashedkey)
            return -1;
        else
            return hashedkey;
        
//        if(hashtable[hashedkey] !=null && hashtable[hashedkey].key.equals(key))
//            return hashedkey;
//        else
//            return -1;
                             
    }
    
    public employee gets(String key)
    {
        int hashedkey = findkey(key);
        if(hashedkey == -1)
            return null;
        else
            return hashtable[hashedkey].emp;
    }
    
    public employee remove(String key)
    {
        int hashedkey = findkey(key);
        //System.out.println("key: "+key);
        if(hashedkey == -1)
            return null;
        
        //rehashing
        employee emp = hashtable[hashedkey].emp;
        hashtable[hashedkey] = null;
        
        storedemployee[] oldarray = hashtable;
        hashtable = new storedemployee[oldarray.length];
        for(int i = 0; i < oldarray.length; i++)
        {
            if(oldarray[i] != null)
                put(oldarray[i].key, oldarray[i].emp);
        }
        return emp;
    }
    
    public void print()
    {
        for(int i = 0; i < hashtable.length; i++)
        {
            if(hashtable[i] == null)
                System.out.println("empty");
            else
                System.out.println(hashtable[i].emp);
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
        h.put("charles", emp5);
        h.put("rosa", emp4);  
        
        //h.print();
        //System.out.println("Retrieved value: "+h.gets("rosa"));

        employee janeJones=new employee("Jones",123);
        employee johnDoe=new  employee("doe",4567);
        employee marySmith = new  employee("Smith",13);
        employee mikeWilson=new employee("Wilson",3245);
        employee jamesBond=new employee("Bond",007);
        
        h.put("jones", janeJones);
        h.put("Doe", johnDoe);
        h.put("Wilson", mikeWilson);
        h.put("Smith", marySmith);
        h.put("bond",jamesBond);
        //h.print();
        
//        System.out.println("Retrieved value: "+h.gets("smith"));
//        System.out.println("Retrieved value: "+h.gets("wilson"));
//        System.out.println("Retrieved value: "+h.gets("rosa"));
//        System.out.println("Retrieved value: "+h.gets("bond"));
        
        System.out.println("Removed element1: "+h.remove("rosa"));
        System.out.println("Removed element2: "+h.remove("smith"));       
        h.print();
    }
}
