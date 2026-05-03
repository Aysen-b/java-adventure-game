import java.util.Scanner;

public abstract class BattleLocation extends Location{
    Scanner scan =new Scanner(System.in);

   protected  Obstacle obstacle;
   protected String award;

    public BattleLocation(Player player , String name , Obstacle obstacle , String award) {
        super(player);
        this.obstacle = obstacle;
        this.name  = name;
        this.award = award;
    }

    public boolean getLocation(){
        int obscount = obstacle.count();
        System.out.println("Şuan Buradasınız -> " + this.getName());
        System.out.println("Dikkatli ol!! " + obscount + " tane " + obstacle.getName() + " Yaşıyor");
        System.out.println("Savaşmak için 'S' veya Kaçmak için 'K' ya basınız !! ");

        String selectCase = scan.nextLine();
        selectCase = selectCase.toUpperCase();

        if(selectCase.equals("S")){
            if(combat(obscount) == true){
                System.out.println(this.getName()+" bölgesindeki tüm düşmanları temizlediniz Tebrikler ^-^");
                if(this.award.equals("Food") && player.getInv().isFood() == false ){
                    System.out.println(this.award + " Kazandınız! ");
                    player.getInv().setFood(true);

                }else if(this.award.equals("Water") && player.getInv().isWater() == false ){
                    System.out.println(this.award + " Kazandınız! ");
                    player.getInv().setWater(true);

                }else if(this.award.equals("Firewood") && player.getInv().isFirewood() == false ){
                    System.out.println(this.award + " Kazandınız! ");
                    player.getInv().setFirewood(true);
                }
                if (player.getInv().isFood() && player.getInv().isWater() && player.getInv().isFirewood()) {
                    System.out.println("Tebrikler oyunu kazandınız !!");
                    return false;
                }

            }
            if(player.getHealthy() <=0 ){
                System.out.println("Öldünüz  ^_^");
                player.setAlive(false);
                return false;
            }

        }
        return true;
    }

    public boolean combat(int obsCount){      // Savaş methodu
        for(int i =0; i<obsCount ;i++){
            int defineObsHealth = obstacle.getHealth();     // eğer bunu yapmazsak 1 canavardan sonra diğer kalan canavarlar da 0 canı olur hepsi ölmüş olur
            playerStats();
            enemyStats();
            while (player.getHealthy() > 0 && obstacle.getHealth() > 0 ){
                System.out.println("Vurmak için 'V' veya Kaçmak için 'K' ya basınız");
                String selectCase = scan.nextLine();
                selectCase=selectCase.toUpperCase();

                if(selectCase.equals("V")){
                    System.out.println("Siz vurdunuz !");
                    obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
                    afterHit();
                    if(obstacle.getHealth() > 0 ) {
                        System.out.println("Sıra canavarda  ^_^");
                        System.out.println("Canavar size vurdu !");
                        player.setHealthy(player.getHealthy() - (obstacle.getDamage() - player.getInv().getArmor()));
                        afterHit();
                    }
                }else {
                    return false;
                }
            }
            if(obstacle.getHealth() <= 0 ){
                System.out.println("Düşmanı yendiniz !!");
                player.setMoney(player.getMoney() + obstacle.getAward());
                System.out.println("Güncel paranız : " + player.getMoney());
                obstacle.setHealth(defineObsHealth);
            }else {
                return false;
            }
            System.out.println("-------------------------------------------------");
        }
        return true;
    }

    public void afterHit(){
        System.out.println("Oyuncunun canı: " + player.getHealthy());
        System.out.println(obstacle.getName() + " canı: " + obstacle.getHealth());
    }

    public void playerStats(){
        System.out.println("Oyuncu Değerleri\n------------------------------------");
        System.out.println("Can:" + player.getHealthy());
        System.out.println("Hasarı:" + player.getTotalDamage());
        System.out.println("Para:" + player.getMoney());
        if(player.getInv().getDamage() > 0 ){
            System.out.println("Silah:" + player.getInv().getWeaponName());
        }
        if(player.getInv().getArmor() >0){
            System.out.println("Zırh:" + player.getInv().getArmorName());
        }

    }

    public void enemyStats(){
        System.out.println("\n" + obstacle.getName() + " Değerleri\n------------------------------------");
        System.out.println("Can:" + obstacle.getHealth());
        System.out.println("Hasar:" + obstacle.getDamage());
        System.out.println("Ödül:" + obstacle.getAward());
    }


}
