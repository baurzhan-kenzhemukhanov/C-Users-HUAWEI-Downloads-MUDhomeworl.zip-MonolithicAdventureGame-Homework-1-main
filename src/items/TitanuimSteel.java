package items;

import interfaces.*;

public class TitanuimSteel implements IItem {

    @Override
    public String getName() {
        return "Titanuim Steel";
    }

    @Override
    public IEntityType.EntityType getType() {
        return IEntityType.EntityType.ITEM;
    }

    @Override
    public IItemType.ItemType getItemType() {
        return IItemType.ItemType.STEEL;
    }

    @Override
    public void use(ICombatant target) {
        int updatedExperience = target.getExperience() + 5;
        target.setExperience(updatedExperience);
    }
}
