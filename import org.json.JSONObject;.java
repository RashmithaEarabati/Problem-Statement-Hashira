import org.json.JSONObject;

import java.math.BigInteger;

public class MaxRootFinderBig {
    public static void main(String[] args) {
        String jsonString = """
        {
          "keys": {
              "n": 10,
              "k": 7
          },
          "1": {
              "base": "6",
              "value": "13444211440455345511"
          },
          "2": {
              "base": "15",
              "value": "aed7015a346d635"
          },
          "3": {
              "base": "15",
              "value": "6aeeb69631c227c"
          },
          "4": {
              "base": "16",
              "value": "e1b5e05623d881f"
          },
          "5": {
              "base": "8",
              "value": "316034514573652620673"
          },
          "6": {
              "base": "3",
              "value": "2122212201122002221120200210011020220200"
          },
          "7": {
              "base": "3",
              "value": "20120221122211000100210021102001201112121"
          },
          "8": {
              "base": "6",
              "value": "20220554335330240002224253"
          },
          "9": {
              "base": "12",
              "value": "45153788322a1255483"
          },
          "10": {
              "base": "7",
              "value": "1101613130313526312514143"
          }
        }
        """;

        JSONObject json = new JSONObject(jsonString);

        BigInteger maxRoot = BigInteger.valueOf(Long.MIN_VALUE);

        for (String key : json.keySet()) {
            if (key.equals("keys")) continue; // skip keys object

            JSONObject rootObj = json.getJSONObject(key);
            int base = Integer.parseInt(rootObj.getString("base"));
            String value = rootObj.getString("value");

            // Convert value from given base to decimal BigInteger
            BigInteger decimalValue = new BigInteger(value, base);

            if (decimalValue.compareTo(maxRoot) > 0) {
                maxRoot = decimalValue;
            }
        }

        // Prepare output JSON
        JSONObject output = new JSONObject();
        output.put("max_root", maxRoot.toString());

        System.out.println(output.toString(2));
    }
}
