package main.attacks;

import main.interfaces.AttackStrategy;
import main.interfaces.Target;

import java.io.*;

public class DictionaryAttack implements AttackStrategy {
    private String dictFile = "dict.txt";

    public void execute(String login, Target target) {
        try (BufferedReader br = new BufferedReader(new FileReader(dictFile))) {
            String password;
            while ((password = br.readLine()) != null) {
                if (target.attemptLogin(login, password)) {
                    System.out.println("Mot de passe trouvé : " + password);
                    return;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
