package main.targets;

import main.interfaces.Target;

import java.io.*;
import java.net.*;

public class WebTarget implements Target {
    private final String url = "http://localhost/web/login.php";

    @Override
    public boolean attemptLogin(String login, String password) {
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);

            String postParams = "login=" + login + "&password=" + password;

            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.writeBytes(postParams);
                wr.flush();
            }

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder response = new StringBuilder();
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                response.append(inputLine);
            in.close();

            return response.toString().contains("Connexion réussie");
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
