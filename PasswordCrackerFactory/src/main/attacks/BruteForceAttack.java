package main.attacks;

import main.interfaces.AttackStrategy;
import main.interfaces.Target;

public class BruteForceAttack implements AttackStrategy {
    private String alphabet = "abcdefghijklmnopqrstuvwxyz0123456789";
    private int maxLength = 4;

    public void execute(String login, Target target) {
        bruteForce("", login, target, 0);
    }

    private void bruteForce(String current, String login, Target target, int depth) {
        if (depth > maxLength) return;
        if (target.attemptLogin(login, current)) {
            System.out.println("Mot de passe trouvé : " + current);
            System.exit(0);
        }
        for (char c : alphabet.toCharArray()) {
            bruteForce(current + c, login, target, depth + 1);
        }
    }
}
