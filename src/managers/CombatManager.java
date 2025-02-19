package managers;

import interfaces.ICombatant;

public class CombatManager {

    public void processCombat(ICombatant attacker, ICombatant defender) {
        System.out.println(attacker.getName() + " engages in combat with " + defender.getName() + "!");

        executeAttack(attacker, defender);

        if (defender.getHealth() > 0) {
            executeAttack(defender, attacker);
        }
    }

    private void executeAttack(ICombatant attacker, ICombatant defender) {
        int damage = attacker.dealDamage();
        defender.takeDamage(damage);

        System.out.println(attacker.getName() + " deals " + damage + " damage to " + defender.getName());
        System.out.println(defender.getName() + " health: " + defender.getHealth());
    }
}

