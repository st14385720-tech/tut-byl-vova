
package semester1.practice10.homework;

public abstract class AbstractMonster {
    private final String name;
    private final String bestiaryCategory;
    protected int hp;
    protected final int maxHp;

    public AbstractMonster(String name, String bestiaryCategory, int maxHp) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Назва монстра не може бути порожньою!");
        }

        if (bestiaryCategory == null || bestiaryCategory.isEmpty()) {
            throw new IllegalArgumentException("Категорія не може бути порожньою!");
        }

        if (maxHp <= 0) {
            throw new IllegalArgumentException("HP має бути більше нуля!");
        }

        this.name = name;
        this.bestiaryCategory = bestiaryCategory;
        this.maxHp = maxHp;
        this.hp = maxHp;
    }

    public String getName() {
        return name;
    }

    public String getBestiaryCategory() {
        return bestiaryCategory;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public abstract int calculateMonsterAttack();

    public abstract String getBattleCry();

    public final boolean isAlive() {
        return hp > 0;
    }

    public void receiveDamage(int dmg) {
        if (dmg > 0) {
            hp = Math.max(0, hp - dmg);
        }
    }

    @Override
    public String toString() {
        int filled = (int) ((double) hp / maxHp * 10);

        String healthBar = "[" + "█".repeat(filled)
                + "░".repeat(10 - filled) + "]";

        return name + " [" + bestiaryCategory + "] | HP: "
                + healthBar + " " + hp + "/" + maxHp;
    }
}
