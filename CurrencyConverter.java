import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.Scanner;

public class CurrencyConverter {

    private static final String API_BASE_URL = "https://api.api-ninjas.com/v1/convertcurrency";

    public CurrencyConverter() {

        System.out.println("Currency Converting from? :");
        HashMap<Integer, String> code = new HashMap<Integer, String>();
        code.put(1, "USD");
        code.put(2, "CAD");
        code.put(3, "EUR");
        code.put(4, "HKD");
        code.put(5, "INR");

        Scanner sc = new Scanner(System.in);
        for (int i = 1; i <= code.size(); i++) {
            System.out.print(i + ") " + code.get(i) + "\t\t");
        }
        int from = sc.nextInt();
        String fromCurrency = code.get(from);

        System.out.println("Currency Converting to? :");
        for (int i = 1; i <= code.size(); i++) {
            if (i == from)
                continue;
            System.out.print(i + ") " + code.get(i) + "\t\t");
        }
        int to = sc.nextInt();
        String toCurrency = code.get(to);

        System.out.println("\nAmount you want to convert? :");
        double amount = sc.nextDouble();

        try {
            URL url = new URL(API_BASE_URL + "?want=" + toCurrency + "&have=" + fromCurrency + "&amount=" + amount);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("accept", "application/json");
            InputStream responseStream = connection.getInputStream();
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(responseStream);
            System.out.println(root.path("fact").asText());
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("\n\t\tIf you want to use it again? -> Press Y");
        char ch = sc.next().charAt(0);
        if (ch == 'y' || ch == 'Y') {
            new CurrencyConverter();
        } else {
            return;
        }
    }

    public static void main(String[] args) {
        System.out.println("\t\tWelcome to SkyBug's Currency Converter!\n");
        new CurrencyConverter();
        System.out.println("\t\tThank you for using SkyBug's currency converter!");
    }
}
