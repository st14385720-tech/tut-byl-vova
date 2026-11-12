
package semester1.practice10.homework;

public class Task5WitcherBestiaryAndMutagenSim {

    public static void main(String[] args) {

        System.out.println("============== 🐺 ВІДЬМАК 3: БЕСТІАРІЙ ТА ПОЛЮВАННЯ 🐺 ==============");

        WitcherHunter geralt = new WitcherHunter("Вовка", 220, 150);

        System.out.println(geralt);

        AbstractMonster[] contracts = {
                new RoyalGriffin(),
                new Noonwraith(),
                new HigherVampire(),
                new AncientLeshen()
        };

        for (int i = 0; i < contracts.length; i++) {

            AbstractMonster monster = contracts[i];

            System.out.println("\n==================================================");
            System.out.println("КОНТРАКТ №" + (i + 1));
            System.out.println(monster);

            System.out.println("\n" + monster.getBattleCry());

            if (monster instanceof FlyingMonster fm && fm.isAirborne()) {
                System.out.println("Монстр знаходиться в повітрі!");
            }

            if (monster instanceof SpectralPhantom sp && sp.isIncorporeal()) {
                System.out.println("Примара безтілесна та поглинає 80% шкоди!");
            }

            if (monster instanceof RegeneratingMonster) {
                System.out.println("Монстр має здатність до регенерації!");
            }

            int damage = geralt.executeSilverStrike(monster);

            if (monster instanceof RegeneratingMonster rm && monster.isAlive()) {
                int restored = rm.regenerateHealth();
                System.out.println("Монстр відновив " + restored + " HP.");
            }

            System.out.println("\nПІДСУМОК:");
            System.out.println(monster);

            if (!monster.isAlive()) {
                System.out.println("Контракт виконано! Монстра переможено!");
            } else {
                System.out.println("Монстр залишився живим. Потрібен ще один удар!");
            }
        }

        System.out.println("\n==================================================");
        System.out.println("🐺 УСІ КОНТРАКТИ ОБРОБЛЕНО!");
        System.out.println("Геральт із Рівії завершує полювання.");
        System.out.println("==================================================");
    }
}
