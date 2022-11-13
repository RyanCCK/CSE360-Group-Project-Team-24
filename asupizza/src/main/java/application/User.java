package application;
import java.io.Serializable;

public class User implements Serializable
{
    protected String ASURITEID;
    protected String password;
    protected String name;
    protected boolean isCashier = false;
    protected boolean isChef = false;

    public User(String asuriteID, String password, String name)
    {
        this.ASURITEID = asuriteID;
        this.password = password;
        this.name = name;
    }

    public String getASURITEID()
    {
        return ASURITEID;
    }

    public String getPassword()
    {
        return password;
    }

    public String name()
    {
        return name;
    }

    public boolean isCashier()
    {
        return isCashier;
    }

    public boolean isChef()
    {
        return isChef;
    }

    public void setASURITEID(String newID)
    {
        ASURITEID = newID;
    }

    public void setPassword(String newPass)
    {
        password = newPass;
    }

    public void setName(String newName)
    {
        name = newName;
    }
}
