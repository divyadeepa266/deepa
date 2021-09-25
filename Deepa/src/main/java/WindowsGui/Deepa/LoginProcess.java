package WindowsGui.Deepa;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class LoginProcess implements Serializable{
private String UName;
private String UPass;
public LoginProcess() {
	super();
	// TODO Auto-generated constructor stub
}
public LoginProcess(String uName, String uPass) {
	super();
	UName = uName;
	UPass = uPass;
}
public String getUName() {
	return UName;
}
public void setUName(String uName) {
	UName = uName;
}
public String getUPass() {
	return UPass;
}
public void setUPass(String uPass) {
	UPass = uPass;
}
@Override
public String toString() {	
	return "UName=" + UName + "_UPass=" + UPass + "\n";
}
}
