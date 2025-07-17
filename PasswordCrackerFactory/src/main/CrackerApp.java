package main;

import main.factories.*;
import main.interfaces.*;

public class CrackerApp {
    public static void main(String[] args) {
        if (args.length != 6) {
            System.out.println("Usage: java CrackerApp --type [brute|dictionary] --target [local|web] --login <login>");
            return;
        }

        String type = args[1];
        String target = args[3];
        String login = args[5];

        AttackFactory factory = null;

        if (type.equalsIgnoreCase("brute") && target.equalsIgnoreCase("local")) {
            factory = new BruteForceLocalFactory();
        } else if (type.equalsIgnoreCase("brute") && target.equalsIgnoreCase("web")) {
            factory = new BruteForceWebFactory();
        } else if (type.equalsIgnoreCase("dictionary") && target.equalsIgnoreCase("local")) {
            factory = new DictionaryLocalFactory();
        } else if (type.equalsIgnoreCase("dictionary") && target.equalsIgnoreCase("web")) {
            factory = new DictionaryWebFactory();
        } else {
            System.out.println("Combinaison type/target non supportée.");
            return;
        }

        AttackStrategy attack = factory.createAttack();
        Target tgt = factory.createTarget();
        attack.execute(login, tgt);
    }
}
