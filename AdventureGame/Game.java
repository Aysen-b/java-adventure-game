import java.util.Scanner;

public class Game {
    Player player;
    Location location;
    Scanner scan = new Scanner(System.in);

    public void login(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Macera oyununa hoşgeldiniz !");
        System.out.print("Oyuna başlamadan önce lütfen isminizi giriniz :");
        String playerName = scan.nextLine();
        player = new Player(playerName);
        player.selectChar();

    }
    public void start(){
        while(true){
            System.out.println();
            System.out.println("===============================================================");
            System.out.println();
            System.out.println("Devam etmek için bir mekan seçiniz.");
            System.out.println("1. Güvenli Ev --> Burada can yenilenir , canavar yok !");
            System.out.println("2. Mağara --> Karşınıza belki zombi çıkabilir !");
            System.out.println("3. Orman --> Karşınıza belki vampir çıkabilir !");
            System.out.println("4. Nehir --> Karşınıza belki ayı çıkabilir !");
            System.out.println("5. Mağaza --> Silah ve zırh alabilirsin !");
            System.out.println("Gitmek istediğiniz yer : ");
            int selectLocation =scan.nextInt();
            while(selectLocation <1 || selectLocation > 5){
                System.out.println("Geçerli bir sayı gir !!");
                selectLocation = scan.nextInt();

            }
            switch (selectLocation){
                case 1:
                    location = new SafeHouse(player);
                    break;
                case 2:
                    location = new Cave(player);
                    break;
                case 3:
                    location = new Forest(player);
                    break;
                case 4:
                    location = new River(player);
                    break;

                case 5:
                    location= new ToolStore((player));
                    break;

                default:
                    location = new SafeHouse(player);




            }
            if(!location.getLocation()){
                if(!player.isAlive()){
                    System.out.println("Oyun bitti, öldün!");
                } else {
                    System.out.println("Tebrikler oyunu kazandın!");
                }
                break;
            }


        }
    }
}
