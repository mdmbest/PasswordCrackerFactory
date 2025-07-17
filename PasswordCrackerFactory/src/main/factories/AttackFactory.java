package main.factories;

import main.interfaces.AttackStrategy;
import main.interfaces.Target;

public interface AttackFactory {
    AttackStrategy createAttack();
    Target createTarget();
}
