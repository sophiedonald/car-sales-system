package carsalessystem;
public class TryParseInt{    
    public static int tryParseInt(String toBeParsed)
    {
        try{
            return Integer.parseInt(toBeParsed);
            
        } catch (NumberFormatException e) {
            return -1; //if toBeParsed cannot be parsed to an integer
        }
    }
}