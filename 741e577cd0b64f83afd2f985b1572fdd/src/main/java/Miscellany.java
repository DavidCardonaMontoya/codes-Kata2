public class Miscellany {
    public static StringBuilder concatenate(String arg1, String ... args){
        StringBuilder strBuilder = new StringBuilder(arg1);
        for (String arg : args){
            strBuilder.append(arg);
        }

        return strBuilder;
    }
}
