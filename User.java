
public abstract class User
{
    protected String ASURITEID;
    protected String password;
    protected String name;

    public abstract void login();
    public abstract void logout();

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
