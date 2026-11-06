
package semester1.practice09.homework;

public class CyberMercenary {
    private final String nickname;
    private final int baseAttack;
    private final BioMonitor bioMonitor;
    private final AbstractCyberImplant[] implants;
    private int implantCount;

    public CyberMercenary(String nickname, int baseAttack, int maxHp) {
        if (nickname == null || nickname.isEmpty()) {
            throw new IllegalArgumentException("Нікнейм не може бути порожнім!");
        }

        if (baseAttack < 0) {
            throw new IllegalArgumentException("Атака не може бути від'ємною!");
        }

        this.nickname = nickname;
        this.baseAttack = baseAttack;
        this.bioMonitor = new BioMonitor(maxHp);
        this.implants = new AbstractCyberImplant[4];
        this.implantCount = 0;
    }

    public boolean installImplant(AbstractCyberImplant implant) {
        if (implant == null) {
            System.out.println("Помилка: імплант не знайдено!");
            return false;
        }

        if (implantCount >= implants.length) {
            System.out.println("Немає вільних слотів!");
            return false;
        }

        for (int i = 0; i < implantCount; i++) {
            if (implants[i].getSlot().equalsIgnoreCase(implant.getSlot())) {
                System.out.println("Слот " + implant.getSlot() + " вже зайнятий!");
                return false;
            }
        }

        implants[implantCount] = implant;
        implantCount++;

        bioMonitor.reduceHumanity(implant.getHumanityCost());

        System.out.println("Імплант встановлено: " + implant.getName());
        return true;
    }

    public int getTotalAttack() {
        int totalAttack = baseAttack;

        for (int i = 0; i < implantCount; i++) {
            totalAttack += implants[i].getAttackBonus();
        }

        if (bioMonitor.isCyberpsychosis()) {
            totalAttack = (int) (totalAttack * 1.5);
        }

        return totalAttack;
    }

    public int getTotalArmor() {
        int totalArmor = 0;

        for (int i = 0; i < implantCount; i++) {
            totalArmor += implants[i].getArmorBonus();
        }

        return totalArmor;
    }

    public void triggerFullOverdrive() {
        System.out.println("\n=== АКТИВАЦІЯ ІМПЛАНТІВ ===");

        for (int i = 0; i < implantCount; i++) {
            System.out.println(implants[i].activateSpecialAbility());
        }
    }

    public void endTurn() {
        if (bioMonitor.isCyberpsychosis()) {
            int damage = (int) Math.ceil(bioMonitor.getHp() * 0.10);
            bioMonitor.applyDamage(damage, 0);

            System.out.println("Кіберпсихоз завдає шкоди: " + damage + " HP!");
        }
    }

    public void injectImmunoblockers(int amount) {
        bioMonitor.injectImmunoblockers(amount);
    }

    public void reduceHumanity(int amount) {
        bioMonitor.reduceHumanity(amount);
    }

    public BioMonitor getBioMonitor() {
        return bioMonitor;
    }

    @Override
    public String toString() {
        String result = "\n=== ДОСЬЄ НАЙМАНЦЯ ===\n";
        result += "Нікнейм: " + nickname + "\n";
        result += "Базова атака: " + baseAttack + "\n";
        result += "Загальна атака: " + getTotalAttack() + "\n";
        result += "Загальна броня: " + getTotalArmor() + "\n";
        result += bioMonitor.toString();
        result += "\n\nВстановлені імпланти:\n";

        for (int i = 0; i < implantCount; i++) {
            result += implants[i].toString() + "\n";
        }

        return result;
    }
}
