package block4.unit4.users;

import block4.unit4.RolesEnum;

//принцип DRY, определяю обязательные поля и методы в абстрактном классе, чтобы не писать один и тот же код в наследниках.
public class AbstractUser implements User {

    private String name;
    private int id = (int) (10000 + Math.random()*99999);
    private RolesEnum rolesEnum;

    public AbstractUser(String name, RolesEnum rolesEnum) {
        this.name = name;
        this.rolesEnum = rolesEnum;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public RolesEnum getRole() {
        return this.rolesEnum;
    }
}
