package UpdatedThingsInJava;

public class Switch
{
    public static void main(String[] args) 
    {
        String day = "Sunday";
        String result = "";

        // switch(day)
        // {
        //     case "Saturday", "Sunday" -> System.out.println("wake up in 7am");
        //     case "Monday" -> System.out.println("wake up in 6am");
        //     default -> System.out.println("wake up in 6am");
        // }


        // switch(day)
        // {
        //     case "Saturday", "Sunday" -> result = "7am";
        //     case "Monday" -> result = "6am";
        //     default -> result = "7am";
        // }
        // System.out.println(result);

        // result = switch(day)
        // {
        //     case "Saturday", "Sunday" -> "7am";
        //     case "Monday" -> "6am";
        //     default -> "7am";
        // };

        // System.out.println(result);

        result = switch(day)
        {
            case "Saturday", "Sunday" : yield "7am";
            case "Monday" : yield "6am";
            default : yield "7am";
        };

        System.out.println(result);

    }
}