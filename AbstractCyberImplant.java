
package semester1.practice09.homework;

public abstract class AbstractCyberImplant {
    private final String name;
    private final String slot;
    private final int humanityCost;

    public AbstractCyberImplant(String name, String slot, int humanityCost) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Назва імпланта не може бути порожньою!");
        }

        if (slot == null || slot.isEmpty()) {
            throw new IllegalArgumentException("Слот не може бути порожнім!");
        }

        if (humanityCost < 0) {
            throw new IllegalArgumentException("Вартість людяності не може бути від'ємною!");
        }

        this.name = name;
        this.slot = slot;
        this.humanityCost = humanityCost;
    }

    public String getName() {
        return name;
    }

    public String getSlot() {
        return slot;
    }

    public int getHumanityCost() {
        return humanityCost;
    }

    public abstract int getAttackBonus();

    public abstract int getArmorBonus();

    public abstract String activateSpecialAbility();

    @Override
    public String toString() {
        return name
                + " | Слот: " + slot
                + " | Атака: +" + getAttackBonus()
                + " | Броня: +" + getArmorBonus()
                + " | Вартість людяності: -" + humanityCost;
    }
}
