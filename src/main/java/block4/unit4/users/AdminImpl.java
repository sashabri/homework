package block4.unit4.users;

import block4.unit4.RolesEnum;

public class AdminImpl extends AbstractUser implements User {
    public AdminImpl(String name) {
        super(name, RolesEnum.ADMIN);
    }
}
