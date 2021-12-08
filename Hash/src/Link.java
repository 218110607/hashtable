package Hash.src;

public class Link {
        // (could be other items)
        private DataItem iData; // data item
        public Link next; // next link in list
        // -------------------------------------------------------------
        public Link(DataItem it) // constructor
        { iData = it; }

        
        public DataItem getiData() {
          return iData;
          }
     // -------------------------------------------------------------
        public String getKey(int i)
        {
          switch (i) {
               case 1:
                   return this.iData.getCountryName();               
               case 2:
                   return this.iData.getCountryCode();               
               case 3:
                   return this.iData.getYear();               
               case 4:
                   return this.iData.getValues();               
               default:
                   return "";
                  
           }  
        }
        // -------------------------------------------------------------
        public void  displayLink() // display this link
        {
             System.out.print(iData + "");
        }
}
