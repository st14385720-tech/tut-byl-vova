
package semester1.practice09.homework;

public class Task5CyberpunkRipperdocSim {

    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println(" CYBERPUNK 2077: RIPPERDOC SIMULATOR");
        System.out.println("======================================");

        CyberMercenary mercenary = new CyberMercenary("Девід Мартінес", 120, 1000);

        System.out.println("\n=== ВСТАНОВЛЕННЯ ІМПЛАНТІВ ===");

        mercenary.installImplant(new SandevistanOs());
        mercenary.installImplant(new MantisBlades());
        mercenary.installImplant(new SubdermalTitaniumArmor());

        System.out.println("\n=== ПЕРЕВІРКА ЗАЙНЯТОГО СЛОТА ===");
        mercenary.installImplant(new SandevistanOs());

        System.out.println("\n=== АКТИВАЦІЯ КІБЕРПСИХОЗУ ===");
        mercenary.reduceHumanity(1);

        System.out.println(mercenary);

        mercenary.triggerFullOverdrive();

        int bossHp = 1100;
        int bossArmor = 50;
        int bossAttack = 180;

        System.out.println("\n======================================");
        System.out.println(" БІЙ ПРОТИ АДАМА СМЕШЕРА");
        System.out.println("======================================");

        for (int round = 1; round <= 4 && bossHp > 0; round++) {
            System.out.println("\n=== РАУНД " + round + " ===");

            int damage = Math.max(5, mercenary.getTotalAttack() - bossArmor);
            bossHp = Math.max(0, bossHp - damage);

            System.out.println("Найманець завдав " + damage + " шкоди!");
            System.out.println("HP Адама Смешера: " + bossHp);

            if (bossHp <= 0) {
                System.out.println("\nАДАМ СМЕШЕР ПЕРЕМОЖЕНИЙ!");
                break;
            }

            int receivedDamage = mercenary.getBioMonitor()
                    .applyDamage(bossAttack, mercenary.getTotalArmor());

            System.out.println("Найманець отримав " + receivedDamage + " шкоди!");

            mercenary.endTurn();

            System.out.println(mercenary.getBioMonitor());

            if (mercenary.getBioMonitor().getHp() <= 0) {
                System.out.println("\nНАЙМАНЕЦЬ ЗАГИНУВ!");
                break;
            }

            if (round == 1) {
                System.out.println("\n=== ВИКОРИСТАННЯ ІМУНОБЛОКАТОРІВ ===");
                mercenary.injectImmunoblockers(30);
            }
        }

        System.out.println("\n======================================");
        System.out.println(" ФІНАЛЬНИЙ СТАН НАЙМАНЦЯ");
        System.out.println("======================================");

        System.out.println(mercenary);
    }
}
