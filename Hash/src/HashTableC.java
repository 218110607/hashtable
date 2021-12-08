package Hash.src;

public class HashTableC {
    private SortedList[] hashArray; // array of lists
    private int arraySize;
    private int Prime;
    private int KeyOrder;
    private DataItem nonItem; // for deleted items
    // -------------------------------------------------------------
    public HashTableC(int size,int prime,int keyOrder) // constructor
    {
        arraySize = size;
        Prime = prime;
        KeyOrder = keyOrder;        
        nonItem = new DataItem("-1","-1","-1","-1"); // deleted item key is -1
        hashArray = new SortedList[arraySize]; // create array
        for(int j=0; j<arraySize; j++){ // fill array
            hashArray[j] = new SortedList(); // with lists
        }
    }    
   // -------------------------------------------------------------
    public SortedList getHashArray(int i) {
        return hashArray[i];
    }   
    // -------------------------------------------------------------
    public int getArraySize() {
        return arraySize;
    }          
    // -------------------------------------------------------------
    public int hashFunc(String key)  // hash function
    {
        int result = 0;
        switch (this.KeyOrder) {
            case 1,2:
                String ks = (String) key;          
                int n = ks.length();
                for (int i = 0; i < ks.length(); i++) {
                    int ch = (int) ks.charAt(i);
                    result += (int) (ch * Math.pow(31,(n-1-i)));            
                }
                result = Math.abs(result % Prime);
                return result;
            case 3:
                int  ki = Integer.parseInt(key);
                result = ki % Prime;        
                return result;              
            default:
                return -1;              
        }                                                         
    }
    // -------------------------------------------------------------     

    public void displayTable()
    {
        System.out.print("Table: ");
        for(int j=0; j<arraySize; j++)
        {
            System.out.print(j + "."); // display cell number
            hashArray[j].displayList(); // display list
        }       
    }
    // -------------------------------------------------------------
    public void insert(Link theLink) // insert a link
    {
        String key = theLink.getKey(KeyOrder);
       
        int hashVal = hashFunc(key); // hash the key
       
        hashArray[hashVal].insert(theLink,this.KeyOrder); // insert at hashVal
       
    } // end insert()
    
   // -------------------------------------------------------------
   public Link find(String key) // find link
    {
        int hashVal = hashFunc(key); // hash the key
        Link theLink = hashArray[hashVal].find(key,this.KeyOrder); // get link
        return theLink; // return link
    }
    // -------------------------------------------------------------    
    public void delete(String key) // delete a link
    {
        int hashVal = hashFunc(key); // hash the key
        hashArray[hashVal].delete(key); // delete link
    } // end delete()
    // -------------------------------------------------------------
} // end class HashTable