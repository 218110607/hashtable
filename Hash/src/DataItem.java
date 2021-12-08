package Hash.src;

public class DataItem 
{ 
    private String CountryName;
    private String CountryCode;
    private String Year;
    private String Values;
    //--------------------------------------------------------------
    public DataItem(String countryName, String countryCode, String year, String values) {
        CountryName = countryName;
        CountryCode = countryCode;
        Year = year;
        Values = values;
    }
//--------------------------------------------------------------
    public String getKey(int i)
    { 
        switch (i) {
            case 1:
                return this.getCountryName();               
            case 2:
                return this.getCountryCode();               
            case 3:
                return this.getYear();               
            case 4:
                return this.getValues();               
            default:
                return "";
               
        }       
     }
//--------------------------------------------------------------    
    public String getCountryName() {
        return CountryName;
    }
    public void setCountryName(String countryName) {
        CountryName = countryName;
    }
    public String getCountryCode() {
        return CountryCode;
    }
    public void setCountryCode(String countryCode) {
        CountryCode = countryCode;
    }
    public String getYear() {
        return Year;
    }
    public void setYear(String year) {
        this.Year = year;
    }
    public String getValues() {
        return Values;
    }
    public void setValues(String values) {
        Values = values;
    }
   
    //--------------------------------------------------------------
    @Override
    public String toString() {
        return CountryName  + "," + CountryCode + "," + Year + "," + Values+"\n" ;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        DataItem other = (DataItem) obj;
        if (CountryCode == null) {
            if (other.CountryCode != null)
                return false;
        } else if (!CountryCode.equals(other.CountryCode))
            return false;
        if (CountryName == null) {
            if (other.CountryName != null)
                return false;
        } else if (!CountryName.equals(other.CountryName))
            return false;
        if (Values == null) {
            if (other.Values != null)
                return false;
        } else if (!Values.equals(other.Values))
            return false;
        if (Year == null) {
            if (other.Year != null)
                return false;
        } else if (!Year.equals(other.Year))
            return false;
        return true;
    }
   
 
    } // end class