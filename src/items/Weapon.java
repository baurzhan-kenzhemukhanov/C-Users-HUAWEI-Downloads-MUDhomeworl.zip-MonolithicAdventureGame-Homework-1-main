package items;

import interfaces.*;

public class Weapon implements IItem {

    @Override
    public String getName() {
        return "Sword";
    }
    public String getDescription() {
        return "A sword that can be used to attack enemies. It is made of steel.Damage: 20";

    }

    @Override
    public IEntityType.EntityType getType() {
        return IEntityType.EntityType.ITEM;
    }

    @Override
    public IItemType.ItemType getItemType() {
        return IItemType.ItemType.BONES_ITEM;
    }

    @Override
    public void use(ICombatant target) {
        int updatedHealth = target.getHealth() + 20;
        target.setHealth(updatedHealth);
    }
}
