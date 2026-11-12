
package semester1.practice10.homework;

public class Noonwraith extends AbstractMonster implements SpectralPhantom {
    private boolean incorporeal;

    public Noonwraith() {
        super("Полудниця з Білого Саду", "Примари", 300);
        this.incorporeal = true;
    }

    @Override
    public int calculateMonsterAttack() {
        return 80;
    }

    @Override
    public String getBattleCry() {
        return "Полудниця видає моторошний крик!";
    }

    @Override
    public boolean isIncorporeal() {
        return incorporeal;
    }

    @Override
    public void bindWithYrdenSign() {
        incorporeal = false;
        System.out.println("Полудницю спіймано в коло знаку Ірден!");
    }

    public int receiveSilverStrike(int damage) {
        if (incorporeal) {
            damage = (int) (damage * 0.2);
        }

        int actualDamage = Math.max(0, damage);
        receiveDamage(actualDamage);

        return actualDamage;
    }

    @Override
    public String toString() {
        return super.toString() + " | Безтілесна: " + incorporeal;
    }
}
