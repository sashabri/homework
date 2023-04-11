package block4.unit4.users;

import block4.unit4.RolesEnum;
//принцип открытости/закрытости (Open Closed Principle), если потребуется новый пользователь с новой ролью,
// то можно будет создать новый класс не затрагивая AbstractUser, AdminImpl, AbstractUser
public interface User {
    public String getName();

    public int getId();

    public RolesEnum getRole();
}
