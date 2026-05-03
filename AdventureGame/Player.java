import java.util.Scanner;

public class Player {
    private int damage,healthy,money,realHealth;
    private String gamerName,charachterName;
    private Inventory inv;
    Scanner scan = new Scanner(System.in);
    private boolean isAlive = true;


    public Player(String gamerName) {   // Constructer
        this.gamerName = gamerName;
        this.inv= new Inventory();

    }

    public void selectChar(){
        switch (charMenu()){
            case 1:
                setCharachterName("Samuray");
                setDamage(5);
                setHealthy(21);
                setMoney(15);
                setRealHealth(21);
                break;
            case 2:
                setCharachterName("Okçu");
                setDamage(7);
                setHealthy(18);
                setMoney(20);
                setRealHealth(18);
                break;
            case 3:
                setCharachterName("Şovalye");
                setDamage(8);
                setHealthy(24);
                setMoney(5);
                setRealHealth(24);
                break;
            default:
                setCharachterName("Samuray");
                setDamage(5);
                setHealthy(21);
                setMoney(15);
                break;
        }
        System.out.println("Karakter:" + getCharachterName() + "\t Hasar:" + getDamage() + "\t Sağlık:" + getHealthy() + "\t Para:" + getMoney());
    }
    public int charMenu(){
        System.out.println("Lütfen bir karakter seçiniz : ");
        System.out.println("1 --> Samuray , Hasar: 5 , Sağlık: 21 , Para : 15");
        System.out.println("2 --> Okçu , Hasar: 7 , Sağlık: 18 , Para : 20");
        System.out.println("3 --> Şovalye , Hasar: 8 , Sağlık: 24 , Para : 5");
        System.out.println("Karakter Seçiminiz: ");
        int charID = scan.nextInt();

        while (charID < 1 || charID >3){
            System.out.println("Lütfen geçerli bir sayı seçiniz !!");
            charID = scan.nextInt();
        }
        return charID;
    }

    public int getTotalDamage(){
        return this.getDamage() + this.getInv().getDamage();
    }


    // ---------------- Getter and Setter ---------------------------------

    public String getCharachterName() {
        return charachterName;
    }

    public void setCharachterName(String charachterName) {
        this.charachterName = charachterName;
    }

    public String getGamerName() {
        return gamerName;
    }

    public void setGamerName(String gamerName) {
        this.gamerName = gamerName;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealthy() {
        return healthy;
    }

    public void setHealthy(int healthy) {
        this.healthy = healthy;
    }

    public Inventory getInv() {
        return inv;
    }

    public void setInv(Inventory inv) {
        this.inv = inv;
    }

    public int getRealHealth() {
        return realHealth;
    }

    public void setRealHealth(int realHealth) {
        this.realHealth = realHealth;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    }






