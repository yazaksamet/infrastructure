package ynwa.core.data;
import ynwa.core.entity.User;

public class UserEntity extends DbEntity<User> {

	@Override
	public void ValidateSave(User entity) {
		
	}

	@Override
	public String GetSelectAllQuery() {
		return "from User";
	}

	@Override
	public String GetSelectSingleQuery() {
		return "from User where user_id=:n";
	}

}
