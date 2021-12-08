package Hash.src;

public class HashTableD {
    private DataItem[] hashArray; // array holds hash table
    private int arraySize;
    private int Prime;
    private int KeyOrder;
    private DataItem nonItem; // for deleted items
    // -------------------------------------------------------------
    public HashTableD(int size,int prime,int keyOrder) // constructor
    {
        arraySize = size;
        Prime = prime;
        KeyOrder = keyOrder;
        hashArray = new DataItem[arraySize];
        nonItem = new DataItem("-1","-1","-1","-1"); // deleted item key is -1
    }
    
    public DataItem getNonItem() {
        return nonItem;
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
     
    public int getArraySize() {
        return arraySize;
    }    
    
    public DataItem getDataItem(int i) {
        return hashArray[i];
    }
    
    // -------------------------------------------------------------
    public void displayTable()
    {
        System.out.print("Table: ");
        for(int j=0; j<arraySize; j++)
        {
            if(hashArray[j] != null)
                if(!hashArray[j].equals(nonItem))
                   System.out.print(hashArray[j] + "");
            // else
            // System.out.print("** ");
        }
        System.out.println("");
    }
    public void insert(DataItem item) // insert a DataItem
    // (assumes table not full)
    {
        String key = item.getKey(KeyOrder); // extract key
        int hashVal = hashFunc(key); // hash the key
        // until empty cell or -1,
        while(hashArray[hashVal] != null && hashArray[hashVal].getKey(KeyOrder) != "-1")
        {
            ++hashVal; // go to next cell
            hashVal %= arraySize; // wraparound if necessary
        }
        hashArray[hashVal] = item; // insert item
    } // end insert()
    // -------------------------------------------------------------
    public DataItem delete(String key) // delete a DataItem
    {
         
        int hashVal = hashFunc(key); // hash the key        
        while(hashArray[hashVal] != null) // until empty cell,
        { // found the key?            
            if(hashArray[hashVal].getKey(KeyOrder).equals(key) )
            {              
                DataItem temp = hashArray[hashVal]; // save item
                hashArray[hashVal] = nonItem; // delete item
                return temp; // return item
            }
            ++hashVal; // go to next cell
            hashVal %= arraySize; // wraparound if necessary
        }
        return null; // can’t find item
    } // end delete()
    // -------------------------------------------------------------

}
