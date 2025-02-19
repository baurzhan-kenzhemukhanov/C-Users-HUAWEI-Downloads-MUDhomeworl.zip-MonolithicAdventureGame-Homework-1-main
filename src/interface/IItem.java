package interfaces;

public interface IItem extends IEntity {

    void use(ICombatant target);

    IItemType.ItemType getItemType();
}

enum ItemType {
    BONES_ITEM,
    OAKSHIELD,
    STEEL,
    SWORD
}
