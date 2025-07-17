package main.factories;

import main.attacks.DictionaryAttack;
import main.interfaces.AttackStrategy;
import main.interfaces.Target;
import main.targets.WebTarget;

public class DictionaryWebFactory implements AttackFactory {
    public AttackStrategy createAttack() {
        return new DictionaryAttack();
    }

    public Target createTarget() {
        return new WebTarget();
    }
}
