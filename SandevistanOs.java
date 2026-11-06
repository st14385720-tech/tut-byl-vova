
package semester1.practice09.homework;

public class SandevistanOs extends AbstractCyberImplant {

    public SandevistanOs() {
        super("Militech Sandevistan Apogee", "Нейро-ОС", 35);
    }

    @Override
    public int getAttackBonus() {
        return 90;
    }

    @Override
    public int getArmorBonus() {
        return 20;
    }

    @Override
    public String activateSpecialAbility() {
        return "⚡ САНДЕВІСТАН АКТИВОВАНО: Час сповільнено на 85%! Вороги завмерли на місці!";
    }
}
