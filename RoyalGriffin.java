
package semester1.practice10.homework;

public class RoyalGriffin extends AbstractMonster implements FlyingMonster {
    private double altitude;
    private boolean grounded;

    public RoyalGriffin() {
        super("Королівський Грифон", "Гібриди", 400);
        this.altitude = 30.0;
        this.grounded = false;
    }

    @Override
    public int calculateMonsterAttack() {
        return 100;
    }

    @Override
    public String getBattleCry() {
        return "Грифон видає гучний бойовий крик!";
    }

    @Override
    public boolean isAirborne() {
        return !grounded;
    }

    @Override
    public void knockDownToGround() {
        grounded = true;
        altitude = 0;
        System.out.println("Грифона збито знаком Аард на землю!");
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
        return super.toString() + " | В повітрі: " + isAirborne()
                + " | Висота: " + altitude + " м";
    }
}
