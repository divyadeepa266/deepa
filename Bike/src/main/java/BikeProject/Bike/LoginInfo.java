package BikeProject.Bike;

import java.io.Serializable;

public class LoginInfo implements Serializable {
private String UserName;
private String Password;
@Override
public String toString() {
	return "LoginInfo [UserName=" + UserName + ", Password=" + Password + "]";
}
public LoginInfo(String userName, String password) {
	super();
	UserName = userName;
	Password = password;
}
public LoginInfo() {
	super();
	// TODO Auto-generated constructor stub
}
public String getUserName() {
	return UserName;
}
public void setUserName(String userName) {
	UserName = userName;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}

}
