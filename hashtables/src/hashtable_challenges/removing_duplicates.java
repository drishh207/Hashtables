package hashtable_challenges;
import java.util.*;

public class removing_duplicates 
{
    public static void main(String args[])
    {
        LinkedList<employee> list = new LinkedList<>();
        employee emp1 = new employee("Jake",122);
        employee emp2 = new employee("Amy",1819);
        employee emp3 = new employee("Rosa",2007);
        employee emp4 = new employee("Charles",284);
        list.add(emp1);
        list.add(emp2);
        list.add(emp3);
        list.add(emp4);
        list.add(emp1);
        list.add(emp3);
        System.out.println(list);
        
        HashMap<Integer , employee> hashtable = new HashMap<>();
       // System.out.println(h);
        ListIterator<employee> itr = list.listIterator();
        List<employee> remove = new ArrayList<>();
       
        while(itr.hasNext())
        {
           employee emp = itr.next();
           //we caanot remove an element while using listiterator as it will throw run time exception as it doesnot want any change in the list.
           if(hashtable.containsKey(emp.getId()))
               remove.add(emp);
           else
               hashtable.put(emp.getId(), emp);
        }
        
        //removing duplicate elements stored in remove from list
        remove.forEach((emp) -> {
            list.remove(emp);
        });
        
        System.out.println("---------------------------------");
        list.forEach(emp -> System.out.println(emp.toString()));
    }
    
}
