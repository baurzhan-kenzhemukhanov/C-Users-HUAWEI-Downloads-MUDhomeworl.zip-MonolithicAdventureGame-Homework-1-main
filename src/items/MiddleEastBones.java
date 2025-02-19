package items;

import interfaces.*;

public class MiddleEastBones implements IItem {

    @Override
    public String getName() {
        return "Middle East Bones";
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
