package hashmap_class;
import java.util.*;

public class hashmap 
{
    
    public static void main(String args[])
    {
        employee emp1 = new employee("Jake",1);
        employee emp2 = new employee("Amy",2);
        employee emp3 = new employee("Terry",3);
        employee emp4 = new employee("Rosa",4);
        employee emp5 = new employee("Charles",5);

        HashMap<String , employee> h = new HashMap<>();
        h.put("jake", emp1);
        h.put("amy", emp2);
        h.put("terry", emp3);
        
        //if we try to put value with existing key, it will replace the original value. So we use putIfAbsent() method
        //it returns the value which is originally at the position.
        System.out.println(h.putIfAbsent("jake", emp5));
        
        System.out.println("Removed value: " + h.remove("amy"));
        
        System.out.println(h.containsKey("amy"));   //should return false
        System.out.println(h.containsValue(emp3));  //should return true
        
        //at key terry, emp5 is substituted. The key doesnot change.
        h.replace("terry", emp5);
        
        //Printing method 1
        Iterator itr = h.values().iterator();
        while(itr.hasNext())
        {
            System.out.println(itr.next());
        }
        
        //Printing method2
        h.forEach((k,v) -> System.out.println("Key :" + k + " Employee: " + v));
    }
    
    
}
