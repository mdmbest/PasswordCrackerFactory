package main.factories;

import main.attacks.BruteForceAttack;
import main.interfaces.AttackStrategy;
import main.interfaces.Target;
import main.targets.LocalTarget;

public class BruteForceLocalFactory implements AttackFactory {
    public AttackStrategy createAttack() {
        return new BruteForceAttack();
    }

    public Target createTarget() {
        return new LocalTarget();
    }
}
