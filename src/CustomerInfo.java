import java.text.SimpleDateFormat;
import java.util.Date;

public class CustomerInfo {
	
	private Date dtDate;
	private String strDate;
	private String strCusID;
	private String strDoorEnt;
	private String strDateOut;
	private String strDateIn;
	private String strDoorNum;
	
	public CustomerInfo()
	{
		try{
			this.dtDate = new Date();
			
		}
		catch(Exception e)
		{
			System.out.println("Err");
		}
		
		this.strCusID = "";
		this.strDoorEnt = " ";
		this.strDateIn = " ";
		this.strDateOut = " ";
		this.strDoorNum = " ";
		this.strDate = " ";
	}
	public CustomerInfo(String strDate, String strCusID, String strDoorEnt, String strDateIn, String strDateOut,String strDoorNum)
	{
		this.strDate = strDate;
		this.strCusID = strCusID;
		this.strDoorEnt = strDoorEnt;
		this.strDateIn = strDateIn;
		this.strDateOut =  strDateOut;
		this.strDoorNum = strDoorNum;
	}
	public CustomerInfo(Date dtDate, String strCusID, String strDoorEnt,String strDoorNum)
	{
		this.dtDate = dtDate;
		this.strCusID = strCusID;
		this.strDoorEnt = strDoorEnt;
		this.strDoorNum = strDoorNum;
	}
	
	//.
	public void setdtDate(Date dtDate)
	{
		this.dtDate = dtDate;
	}
	public void setDate(String strDate)
	{
		this.strDate = strDate;
	}
	public void setCusId(String strCusID)
	{
		this.strCusID = strCusID;
	}
	public void setDoor(String strDoorEnt)
	{
		this.strDoorEnt = strDoorEnt;
	}
	public void setDateIn(String strDateIn)
	{
		this.strDateIn = strDateIn;
	}
	public void setDateOut(String strDateOut)
	{
		this.strDateOut = strDateOut;
	}
	public void setDoorNum(String strDoorNum)
	{
		this.strDoorNum = strDoorNum;
	}
	
	//.
	public Date getDDate()
	{
		return(this.dtDate);
	}
	public String getDate()
	{
	  return(this.strDate);
	}
	
	public String getCusId()
	{
		return(this.strCusID);
	}
	public String getDoorEnt()
	{
		return(this.strDoorEnt);
	}
	public String getDateIn()
	{
		return(this.strDateIn);
	}
	public String getDateOut()
	{
		return(this.strDateOut);
	}
	public String getDoorNum()
	{
		return(this.strDoorNum);
	}
	public String Result()
	{
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String temp =
				"DoorNum " + this.strDoorNum + "\nCusID " + this.strCusID + "\nDate " + 
		        sm.format(this.dtDate) + "\nDateIn " + this.strDateIn + 
		        "\nDate "+ this.strDateOut + "\nDoorName: "+ this.strDoorEnt;
		return temp;
				
				
				
	}
	public String Result1()
	{
		String temp =
				"DoorNum " + this.strDoorNum + "CusID " + this.strCusID + "Date " + 
		        this.strDate + "DateIn " + this.strDateIn + 
		        "DateOut "+ this.strDateOut + "DoorName: "+ this.strDoorEnt;
		return temp;
				
				
				
	}

}
