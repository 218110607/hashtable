package Hash.src;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
public class App {
  //A.csv output.csv 1 1000 1 13 Mali
  //c:; cd 'c:\Users\nhcadmin\Desktop\Hash'; & 'C:\Program Files\Eclipse Foundation\jdk-17.0.0.35-hotspot\bin\java.exe' '--enable-preview' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'C:\Users\nhcadmin\AppData\Roaming\Code\User\workspaceStorage\adc2dfd14f96cfaaf76c01860a7c75f2\redhat.java\jdt_ws\Hash_cf3b12b\bin' 'Hash.src.App' A.csv output.csv 1 1000 1 13 Mali
      public static void main(String[] args) throws Exception {                 
            String inputFile = args[0];
            String outputFile =args[1];
            int column =Integer.valueOf(args[2]);
            int size =Integer.valueOf(args[3]);
            int collisionResolution = Integer.valueOf(args[4]);            
            int prime = Integer.valueOf(args[5]);                       
            int removeCount =args.length-6;           
            String[] removes = new String[removeCount];
            for (int i = 0; i < removeCount; i++) {
              removes[i] = args[6+i];
            }              
            File file = new File(inputFile);
            //Hash table – Displacement (Linear Probing)                 
            if(collisionResolution == 1 ){                     
              long readStartTime = System.nanoTime();                                    
              HashTableD hashTable = new HashTableD(size,prime,column);
              //read data for data set
              Scanner finput = new Scanner(file);
              
              while (finput.hasNextLine()) {
                  String line = finput.nextLine();             
                  String[] parts= line.split(",");
                  String countryName = parts[0];
                  String countryCode = parts[1];
                  String year = parts[2];
                  String value = parts[3];
                  DataItem item = new DataItem(countryName,countryCode,year,value);                      
                  hashTable.insert(item);
              }
              long readEndTime = System.nanoTime();
              long readTime = readEndTime - readStartTime;
              System.out.println("Read Time IN Nano : "+readTime);
              
              //Search and remove selected items from the memory;
              long deleteStartTime = System.nanoTime();
              for (int i = 0; i < removes.length; i++) {
                DataItem deletedItem;
                do{                     
                  deletedItem = hashTable.delete(removes[i]);
                }while(deletedItem != null); 
              }       
              
              long deleteEndTime = System.nanoTime();
              long deleteTime = deleteEndTime - deleteStartTime;
              System.out.println("Remove Time IN Nano : "+deleteTime);                     

              //Write the result to a CSV output file.
              FileWriter myWriter = new FileWriter(outputFile);
              long writeStartTime = System.nanoTime();    
              for(int j=0; j<hashTable.getArraySize(); j++)
              {
                  DataItem item =   hashTable.getDataItem(j);                        
                  if(item != null ){  
                    if(!item.equals(hashTable.getNonItem())){
                                                                
                      myWriter.write(item.toString());
                    }                          
                    
                  }                             
              }
              myWriter.close();
              long writeEndTime = System.nanoTime();
              long writeTime = writeEndTime - writeStartTime;
              System.out.println("Write Time IN Nano : "+writeTime);
              
            } 
                //Hash table - Chaining                        
            if(collisionResolution == 2 )
            {                     
                    long readStartTime = System.nanoTime();                                   
                    HashTableC hashTable = new HashTableC(size,prime,column);
                    //read data for data set
                    Scanner finput = new Scanner(file);
                    
                    while (finput.hasNextLine()) {
                        String line = finput.nextLine();             
                        String[] parts= line.split(",");
                        String countryName = parts[0];
                        String countryCode = parts[1];
                        String year = parts[2];
                        String value = parts[3];
                        DataItem item = new DataItem(countryName,countryCode,year,value);                          
                        Link theLink = new Link(item);
                                         
                        hashTable.insert(theLink);
                        //hashTable.displayTable();
                    }
                    long readEndTime = System.nanoTime();
                    long readTime = readEndTime - readStartTime;
                    System.out.println("Read Time IN Nano : "+readTime);
                    //hashTable.displayTable();
                    //Search and remove selected items from the memory;
                    long deleteStartTime = System.nanoTime(); 
                    for (int i = 0; i < removes.length; i++) {
                      hashTable.delete(removes[i]);   
                    }                                        
                                    
                    long deleteEndTime = System.nanoTime();
                    long deleteTime = deleteEndTime - deleteStartTime;
                    System.out.println("Remove Time IN Nano : "+deleteTime);                     

                    //Write the result to a CSV output file.
                    FileWriter myWriter = new FileWriter(outputFile);
                    long writeStartTime = System.nanoTime();    
                    for(int i=0; i<hashTable.getArraySize(); i++)
                    {
                      SortedList sortedList = hashTable.getHashArray(i);
                      Link current = sortedList.getFirst(); // start at beginning of list
                      while(current != null) // until end of list,
                      {
                           DataItem item = current.getiData(); // print data
                          current = current.next; // move to next link
                          myWriter.write(item.toString());
                      }                                                                          
                    }
                    myWriter.close();
                    long writeEndTime = System.nanoTime();
                    long writeTime = writeEndTime - writeStartTime;
                    System.out.println("Write Time IN Nano : "+writeTime);
                    
                  } 
    }
  }