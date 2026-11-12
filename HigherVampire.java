
package semester1.practice10.homework;

public class HigherVampire extends AbstractMonster
        implements FlyingMonster, RegeneratingMonster {

    private double altitude;
    private boolean grounded;
    private int bloodRegen;
    private boolean regenBlocked;

    public HigherVampire() {
        super("Вищий Вампір Детлафф", "Вампіри", 650);
        this.altitude = 20.0;
        this.grounded = false;
        this.bloodRegen = 120;
        this.regenBlocked = false;
    }

    @Override
    public int calculateMonsterAttack() {
        return 150;
    }

    @Override
    public String getBattleCry() {
        return "Детлафф видає моторошний вампірський рев!";
    }

    @Override
    public boolean isAirborne() {
        return !grounded;
    }

    @Override
    public void knockDownToGround() {
        grounded = true;
        altitude = 0;
        System.out.println("Аард перериває піке Детлаффа!");
    }

    @Override
    public int regenerateHealth() {
        if (regenBlocked || !isAlive()) {
            return 0;
        }

        int oldHp = hp;
        hp = Math.min(maxHp, hp + bloodRegen);

        return hp - oldHp;
    }

    @Override
    public void applyMoonDustBomb() {
        regenBlocked = true;
        System.out.println("Бомба Місячний Пил заблокувала регенерацію вампіра!");
    }

    public int receiveSilverStrike(int damage) {
        if (isAirborne()) {
            damage /= 2;
        }

        int actualDamage = Math.max(0, damage);
        receiveDamage(actualDamage);

        return actualDamage;
    }

    @Override
    public String toString() {
        return super.toString()
                + " | Літає: " + isAirborne()
                + " | Регенерація: " + (regenBlocked ? "Заблокована" : "+" + bloodRegen);
    }
}
