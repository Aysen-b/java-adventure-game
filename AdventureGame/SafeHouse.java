public class SafeHouse extends NormalLocation {
     SafeHouse(Player player) {
        super(player, "Güvenli Ev ");
    }

    public boolean getLocation(){
        player.setHealthy(player.getRealHealth());
        System.out.println("Canınız iyileşti");
        System.out.println("Şuan Güvenli Evdesin !");

        return true;
    }

}
