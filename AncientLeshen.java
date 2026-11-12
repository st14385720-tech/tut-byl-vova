
package semester1.practice10.homework;

public final class AncientLeshen extends AbstractMonster implements RegeneratingMonster {

    private int forestTotems;
    private boolean regenBlocked;

    public AncientLeshen() {
        super("Прадавній Лісовик", "Релікти", 800);
        this.forestTotems = 3;
        this.regenBlocked = false;
    }

    @Override
    public int calculateMonsterAttack() {
        return 130;
    }

    @Override
    public String getBattleCry() {
        return "Лісовик кличе духів прадавнього лісу!";
    }

    @Override
    public int regenerateHealth() {
        if (regenBlocked || !isAlive()) {
            return 0;
        }

        int oldHp = hp;
        hp = Math.min(maxHp, hp + 80);

        return hp - oldHp;
    }

    @Override
    public void applyMoonDustBomb() {
        regenBlocked = true;
        System.out.println("Місячний Пил заблокував регенерацію Лісовика!");
    }

    public int getForestTotems() {
        return forestTotems;
    }

    @Override
    public String toString() {
        return super.toString()
                + " | Тотеми: " + forestTotems
                + " | Регенерація: " + (regenBlocked ? "Заблокована" : "Активна");
    }
}
