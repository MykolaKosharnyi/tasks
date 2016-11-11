package notebook;

import java.util.Date;

/**
 * The model describes note in notebook.
 * @version 1.0
 * @author Mykola Kosharny
 */
public class Note {

    /** 
     * First name 
     */
    private String firstName;

    /** 
     * Middle name 
     */
    private String middleName;

    /** 
     * Last name 
     */
    private String lastName;

    /** 
     * Full name 
     */
    private String fullName;

    /** 
     * Username 
     */
    private String username;

    /** 
     * Comment 
     */
    private String comment;

    /** 
     * Group 
     */
    private Group group;

    /** 
     * Home number in format 0-yyy-xxxxxx 
     */
    private String homePhone;

    /** 
     * Home number in format 0yy-xxx-xx-xx 
     */
    private String cellPhone;

    /** 
     * Additional home number in format 0yy-xxx-xx-xx 
     */
    private String cellPhoneOptional;

    /** 
     * E-mail 
     */
    private String email;

    /** 
     * Skype username 
     */
    private String skype;

    /** 
     * Address 
     */
    private Address address;

    /** 
     * Full address 
     */
    private String fullAddress;

    /** 
     * Creation date of note 
     */
    private Date initialDate;

    /** 
     * Data of last change of note 
     */
    private Date lastChangeDate;

    /** 
     * Method creates full name from last name and first letter of first name 
     */
    public void createFullName() {
        fullName = lastName + " " + firstName.charAt(0) + ".";
    }

    /** 
     * Method creates full address 
     */
    public void createFullAddress() {
        fullAddress = address.getPostalCode() + ", " + address.getCity() + ", "
                + address.getStreet() + " " + address.getHouseNumber()
                + " flat " + address.getFlatNumber();
    }

    //getters & setters

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public String getHomePhone() {
        return homePhone;
    }

    public void setHomePhone(String homePhone) {
        this.homePhone = homePhone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getCellPhoneOptional() {
        return cellPhoneOptional;
    }

    public void setCellPhoneOptional(String cellPhoneOptional) {
        this.cellPhoneOptional = cellPhoneOptional;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSkype() {
        return skype;
    }

    public void setSkype(String skype) {
        this.skype = skype;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getFullAddress() {
        return fullAddress;
    }

    public void setFullAddress(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    public Date getInitialDate() {
        return initialDate;
    }

    public void setInitialDate(Date initialDate) {
        this.initialDate = initialDate;
    }

    public Date getLastChangeDate() {
        return lastChangeDate;
    }

    public void setLastChangeDate(Date lastChangeDate) {
        this.lastChangeDate = lastChangeDate;
    }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((cellPhone == null) ? 0 : cellPhone.hashCode());
		result = prime * result + ((cellPhoneOptional == null) ? 0 : cellPhoneOptional.hashCode());
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((fullAddress == null) ? 0 : fullAddress.hashCode());
		result = prime * result + ((fullName == null) ? 0 : fullName.hashCode());
		result = prime * result + ((group == null) ? 0 : group.hashCode());
		result = prime * result + ((homePhone == null) ? 0 : homePhone.hashCode());
		result = prime * result + ((initialDate == null) ? 0 : initialDate.hashCode());
		result = prime * result + ((lastChangeDate == null) ? 0 : lastChangeDate.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((middleName == null) ? 0 : middleName.hashCode());
		result = prime * result + ((skype == null) ? 0 : skype.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Note other = (Note) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (cellPhone == null) {
			if (other.cellPhone != null)
				return false;
		} else if (!cellPhone.equals(other.cellPhone))
			return false;
		if (cellPhoneOptional == null) {
			if (other.cellPhoneOptional != null)
				return false;
		} else if (!cellPhoneOptional.equals(other.cellPhoneOptional))
			return false;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (fullAddress == null) {
			if (other.fullAddress != null)
				return false;
		} else if (!fullAddress.equals(other.fullAddress))
			return false;
		if (fullName == null) {
			if (other.fullName != null)
				return false;
		} else if (!fullName.equals(other.fullName))
			return false;
		if (group != other.group)
			return false;
		if (homePhone == null) {
			if (other.homePhone != null)
				return false;
		} else if (!homePhone.equals(other.homePhone))
			return false;
		if (initialDate == null) {
			if (other.initialDate != null)
				return false;
		} else if (!initialDate.equals(other.initialDate))
			return false;
		if (lastChangeDate == null) {
			if (other.lastChangeDate != null)
				return false;
		} else if (!lastChangeDate.equals(other.lastChangeDate))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (middleName == null) {
			if (other.middleName != null)
				return false;
		} else if (!middleName.equals(other.middleName))
			return false;
		if (skype == null) {
			if (other.skype != null)
				return false;
		} else if (!skype.equals(other.skype))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Note [firstName=" + firstName + ", middleName=" + middleName + ", lastName=" + lastName + ", fullName="
				+ fullName + ", username=" + username + ", comment=" + comment + ", group=" + group + ", homePhone="
				+ homePhone + ", cellPhone=" + cellPhone + ", cellPhoneOptional=" + cellPhoneOptional + ", email="
				+ email + ", skype=" + skype + ", address=" + address + ", fullAddress=" + fullAddress
				+ ", initialDate=" + initialDate + ", lastChangeDate=" + lastChangeDate + "]";
	}

}