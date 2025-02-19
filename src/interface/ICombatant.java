package interfaces;

public interface ICombatant extends IEntity {

    int getHealth();

    void setHealth(int health);

    int getExperience();

    void setExperience(int experience);

    void takeDamage(int damage);

    int dealDamage();
}
