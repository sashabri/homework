package block4.unit4.users;

import block4.unit4.Basket;
import block4.unit4.RolesEnum;

//принцип замены Барбары Лисков (Liskov Substitution Principle), AbstractUser может играть роль за предка.
public class UserImpl extends AbstractUser implements User {

    private int money;
    private Basket myBasket = new Basket();

    public UserImpl(String name, int money) {
        super(name, RolesEnum.SHOPPER);
        this.money = money;
    }

    public int getMoney() {
        return money;
    }

    public Basket getMyBasket() {
        return myBasket;
    }

    public void buyFood() {
       money -= myBasket.generalPrice();
    }

    public void depositMoney(int money) {
        this.money += money;
    }
}
