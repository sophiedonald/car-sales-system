public class TryParseInt{    
    public static int tryParseInt(String toBeParsed)
    {
        try{
            return Integer.parseInt(toBeParsed);
            
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}