package Hash.src;

public class SortedList {
    private Link first; // ref to first list item
  
    // -------------------------------------------------------------
    public void SortedList() // constructor
    { 
        first = null; 
    }
    // -------------------------------------------------------------
    public void insert(Link theLink,int keyOrder) // insert link, in order
    {
        
        String key = theLink.getKey(keyOrder);
        Link previous = null; // start at first
        Link current = first;
        // until end of list,
        while( current != null && key.compareTo(current.getKey(keyOrder)) != 0 )
        { // or current > key,
            previous = current;
            current = current.next; // go to next item
        }
        if(previous == null)  // if beginning of list,
            first = theLink;   // first --> new link
        else    // not at beginning,
            previous.next = theLink; // prev --> new link
        
        theLink.next = current; // new link --> current
        
    } // end insert()
    public Link getFirst() {
        return first;
    }
    public void setFirst(Link first) {
        this.first = first;
    }
    // -------------------------------------------------------------
    public void delete(String key) // delete link
    { // (assumes non-empty list)
        Link previous = null; // start at first
        Link current = first;
        // until end of list,
        while( current != null)// && key != current.getKey(keyOrder) )
        { // or key == current,
            previous = current;
            current = current.next; // go to next link
        }
        // disconnect link
        if(previous==null) // if beginning of list
            first = first.next; // delete first link
        else // not at beginning
             previous.next = current.next; // delete current link
    } // end delete()
    // -------------------------------------------------------------
    public Link find(String key,int keyOrder) // find link
    {
        Link current = first; // start at first
        // until end of list,
        while(current != null)// && current.getKey(keyOrder) <= key)
        { // or key too small,
            if(current.getKey(keyOrder) == key) // is this the link?
            return current; // found it, return link
            current = current.next; // go to next item
        }
        return null; // didn’t find it
    } // end find()
    // -------------------------------------------------------------
    public void displayList()
    {
        //System.out.print("List (first-->last): ");
        Link current = first; // start at beginning of list
        while(current != null) // until end of list,
        {

            current.displayLink(); // print data
            current = current.next; // move to next link           
        }
       
    }
}
