package EIS;

public class UserDetails 
{
private String userName;
private String userEmail;
private String userPhone;
private String carLicense;
private String startTime;
private String endTime;
private int slotNumber;
private String parkingID;


public String getParkingID() {
	return parkingID;
}


public void setParkingID(String parkingID) {
	this.parkingID = parkingID;
}


public String getUserName() {
	return userName;
}


public void setUserName(String userName) {
	this.userName = userName;
}


public String getUserEmail() {
	return userEmail;
}


public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
}


public String getUserPhone() {
	return userPhone;
}


public void setUserPhone(String userPhone) {
	this.userPhone = userPhone;
}


public String getCarLicense() {
	return carLicense;
}


public void setCarLicense(String carLicense) {
	this.carLicense = carLicense;
}


public String getStartTime() {
	return startTime;
}


public void setStartTime(String startTime) {
	this.startTime = startTime;
}


public String getEndTime() {
	return endTime;
}


public void setEndTime(String endTime) {
	this.endTime = endTime;
}


public int getSlotNumber() {
	return slotNumber;
}


public void setSlotNumber(int slotNumber) {
	this.slotNumber = slotNumber;
}


@Override
public String toString() {
	return "UserDetails [userName=" + userName + ", userEmail=" + userEmail + ", userPhone=" + userPhone
			+ ", carLicense=" + carLicense + ", startTime=" + startTime + ", endTime=" + endTime + ", slotNumber="
			+ slotNumber + "]";
}
















}
