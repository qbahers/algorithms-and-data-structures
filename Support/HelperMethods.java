package Support;

public class HelperMethods 
{
    public static String stringArrayToString(String[] array) 
    {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        int l = array.length;
        for (int i = 0; i < l-1; i++)
        {
            sb.append(array[i] + ", ");
        }
        sb.append(array[l-1] + "}");
        return sb.toString();
    }
}
