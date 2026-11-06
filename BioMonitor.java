
package semester1.practice09.homework;

public class BioMonitor {
    private int hp;
    private final int maxHp;
    private int humanity;
    private boolean cyberpsychosis;

    public BioMonitor(int maxHp) {
        if (maxHp <= 0) {
            throw new IllegalArgumentException("Неправильне значення HP!");
        }

        this.maxHp = maxHp;
        this.hp = maxHp;
        this.humanity = 100;
        this.cyberpsychosis = false;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getHumanity() {
        return humanity;
    }

    public boolean isCyberpsychosis() {
        return cyberpsychosis;
    }

    public void reduceHumanity(int cost) {
        if (cost < 0) {
            return;
        }

        humanity = Math.max(0, humanity - cost);

        if (humanity < 20) {
            cyberpsychosis = true;
            System.out.println("КРИТИЧНЕ ПОПЕРЕДЖЕННЯ: КІБЕРПСИХОЗ!");
        }
    }

    public void injectImmunoblockers(int restoreAmount) {
        if (restoreAmount < 0) {
            return;
        }

        humanity = Math.min(100, humanity + restoreAmount);

        if (humanity >= 20) {
            cyberpsychosis = false;
            System.out.println("Нейро-стабільність відновлено!");
        }
    }

    public int applyDamage(int rawDamage, int totalArmor) {
        int actualDamage = Math.max(5, rawDamage - totalArmor);
        hp = Math.max(0, hp - actualDamage);
        return actualDamage;
    }

    public void restoreHealth(int amount) {
        if (amount > 0) {
            hp = Math.min(maxHp, hp + amount);
        }
    }

    @Override
    public String toString() {
        int filled = (int) ((double) hp / maxHp * 10);
        String healthBar = "[" + "█".repeat(filled)
                + "░".repeat(10 - filled) + "]";

        String status = cyberpsychosis
                ? "CYBERPSYCHOSIS"
                : "Стабільний";

        return "HP: " + healthBar + " " + hp + "/" + maxHp
                + " | Humanity: " + humanity + "/100 [" + status + "]";
    }
}
