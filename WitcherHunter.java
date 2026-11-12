
package semester1.practice10.homework;

public class WitcherHunter {
    private final String schoolName;
    private final int silverSwordAtk;
    private final int signIntensity;

    public WitcherHunter(String schoolName, int silverSwordAtk, int signIntensity) {
        this.schoolName = schoolName;
        this.silverSwordAtk = silverSwordAtk;
        this.signIntensity = signIntensity;
    }

    public void applyBestiaryTactics(AbstractMonster target) {
        System.out.println("\n=== АНАЛІЗ БЕСТІАРІЮ ===");

        if (target instanceof SpectralPhantom sp && sp.isIncorporeal()) {
            System.out.println("Ґеральт застосовує знак ІРДЕН!");
            sp.bindWithYrdenSign();
        }

        if (target instanceof FlyingMonster fm && fm.isAirborne()) {
            System.out.println("Ґеральт застосовує знак ААРД!");
            fm.knockDownToGround();
        }

        if (target instanceof RegeneratingMonster rm) {
            System.out.println("Ґеральт кидає бомбу МІСЯЧНИЙ ПИЛ!");
            rm.applyMoonDustBomb();
        }
    }

    public final int executeSilverStrike(AbstractMonster target) {
        if (target == null || !target.isAlive()) {
            return 0;
        }

        applyBestiaryTactics(target);

        int damage = silverSwordAtk * signIntensity / 100;

        if (target instanceof RoyalGriffin griffin) {
            damage = griffin.receiveSilverStrike(damage);
        } else if (target instanceof Noonwraith noonwraith) {
            damage = noonwraith.receiveSilverStrike(damage);
        } else if (target instanceof HigherVampire vampire) {
            damage = vampire.receiveSilverStrike(damage);
        } else {
            target.receiveDamage(damage);
        }

        System.out.println("\n⚔️ Срібний меч завдає " + damage + " шкоди!");
        System.out.println("Залишок HP монстра: " + target.getHp()
                + "/" + target.getMaxHp());

        return damage;
    }

    @Override
    public String toString() {
        return "Мисливець: Ґеральт із Рівії"
                + " (Школа " + schoolName
                + " | Срібний меч: " + silverSwordAtk
                + " ATK | Інтенсивність Знаків: "
                + signIntensity + "%)";
    }
}
