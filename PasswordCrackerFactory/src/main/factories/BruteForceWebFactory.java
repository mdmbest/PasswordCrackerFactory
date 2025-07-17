package main.factories;

import main.attacks.BruteForceAttack;
import main.interfaces.AttackStrategy;
import main.interfaces.Target;
import main.targets.WebTarget;

public class BruteForceWebFactory implements AttackFactory {
    public AttackStrategy createAttack() {
        return new BruteForceAttack();
    }

    public Target createTarget() {
        return new WebTarget();
    }
}
