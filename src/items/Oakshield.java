package items;

import interfaces.*;

public class Oakshield implements IItem {

    @Override
    public String getName() {
        return "Oakshield";
    }

    @Override
    public IEntityType.EntityType getType() {
        return IEntityType.EntityType.ITEM;
    }

    @Override
    public IItemType.ItemType getItemType() {
        return IItemType.ItemType.OAKSHIELD;
    }

    @Override
    public void use(ICombatant target) {
        int updatedExperience = target.getExperience() + 10;}
    }
