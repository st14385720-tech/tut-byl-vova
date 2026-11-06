package semester1.practice08.homework;

public class Task5ShadowMonarchRpg {
    private String name;
    private int level;
    protected int hp;
    protected int maxHp;
    protected int baseAttack;
    protected int defense;

    public Task5ShadowMonarchRpg(String name, int level, int maxHp, int baseAttack, int defense) {
        if (name == null || name.isEmpty() || level <= 0 ||
                maxHp <= 0 || baseAttack < 0 || defense < 0) {
            throw new IllegalArgumentException("Неправильні характеристики!");
        }

        this.name = name;
        this.level = level;
        this.maxHp = maxHp;
        this.hp = maxHp;
        this.baseAttack = baseAttack;
        this.defense = defense;
    }

    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getHp() {
        return hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public int getBaseAttack() {
        return baseAttack;
    }

    public int getDefense() {
        return defense;
    }

    public int takeDamage(int rawDamage) {
        int actual = Math.max(5, rawDamage - defense);
        hp = Math.max(0, hp - actual);
        return actual;
    }

    public int performAttack() {
        return baseAttack;
    }

    public boolean isAlive() {
        return hp > 0;
    }

    protected String buildHealthBar() {
        int filled = (int) ((double) hp / maxHp * 10);
        return "[" + "█".repeat(filled) + "░".repeat(10 - filled) + "]";
    }

    @Override
    public String toString() {
        return "DungeonEntity{name='" + name +
                "', lvl=" + level +
                ", HP=" + buildHealthBar() + " " + hp + "/" + maxHp +
                ", ATK=" + baseAttack +
                ", DEF=" + defense + "}";
    }
}
