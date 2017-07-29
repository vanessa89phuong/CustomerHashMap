import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		ArrayList<CustomerInfo> arrCusList1 = new ArrayList<CustomerInfo>();
		ArrayList<CustomerInfo> arrCusList2 = new ArrayList<CustomerInfo>();
		ArrayList<CustomerInfo> arrCusList3 = new ArrayList<CustomerInfo>();
		List<Date> arrDate1 = new ArrayList<Date>();
		List<Date> arrDate2 = new ArrayList<Date>();
		CustomerInfo custInfoObj = new CustomerInfo();
		int k = 0;
		long diff = 0;
		
		try{
		CustomerInfo cusInfoObj1 = 
				new CustomerInfo(sm.parse("2017-07-21 11:20:36"), "34567","Entrance 1","2");
		
		CustomerInfo cusInfoObj2 = 
				new CustomerInfo(sm.parse("2017-07-21 11:20:40"), "34567","Entrance 1","2");
		
		CustomerInfo cusInfoObj3 = 
				new CustomerInfo(sm.parse("2017-07-21 11:50:36"), "34567","Entrance 1","2");
		
		CustomerInfo cusInfoObj4 = 
				new CustomerInfo(sm.parse("2017-07-21 15:20:36"), "34567","Entrance 1","1");

		CustomerInfo cusInfoObj5 = 
				new CustomerInfo(sm.parse("2017-07-21 9:20:36"), "34579","Entrance 1","1");
		
		CustomerInfo cusInfoObj6 = 
				new CustomerInfo(sm.parse("2017-07-21 8:20:40"), "34556","Entrance 1","4");
		
		CustomerInfo cusInfoObj7 = 
				new CustomerInfo(sm.parse("2017-07-21 11:40:00"), "34551","Entrance 1","2");
		
		CustomerInfo cusInfoObj8 = 
				new CustomerInfo(sm.parse("2017-07-21 15:20:56"), "34543","Entrance 1","1");
		arrCusList1.add(cusInfoObj1);
		arrCusList1.add(cusInfoObj2);
		arrCusList1.add(cusInfoObj3);
		arrCusList1.add(cusInfoObj4);
		arrCusList1.add(cusInfoObj5);
		arrCusList1.add(cusInfoObj6);
		arrCusList1.add(cusInfoObj7);
		arrCusList1.add(cusInfoObj8);
		}
		catch(Exception e)
		{
			System.out.println("eee");
		}
		
		for(CustomerInfo info: arrCusList1)
		{
	//		System.out.println(info.Result());
		}
		
		HashMap<String,HashMap<String,HashMap<String,List<Date>>>> hmList;
		
		hmList = new HashMap<String,HashMap<String,HashMap<String,List<Date>>>>();
		HashMap<String,HashMap<String,List<Date>>> hmList1;
		HashMap<String,List<Date>> hmList2;
		
		
		for(CustomerInfo info1 : arrCusList1)
		{
			hmList1 = hmList.get(info1.getDoorNum());
			if(hmList1 == null)
			{
				hmList1 = new HashMap<String,HashMap<String,List<Date>>>();
				hmList.put(info1.getDoorNum(), hmList1);
			}
			hmList2 = hmList1.get(info1.getCusId());
			if(hmList2 == null)
			{
				hmList2 = new HashMap<String,List<Date>>();
				hmList1.put(info1.getCusId(), hmList2);
			}
			if(hmList2.get(info1.getDoorEnt()) == null)
			{
				List<Date> lDate = new ArrayList<Date>();
				lDate.add(info1.getDDate());
				hmList2.put(info1.getDoorEnt(),lDate);
			}
			else{
				List lDate = hmList2.get(info1.getDoorEnt());
				lDate.add(info1.getDDate());
				hmList2.put(info1.getDoorEnt(), lDate);
			}
			
			
		}
		for(String s: hmList.keySet())
		{
			//System.out.println(" Door num " + s );
			HashMap<String,HashMap<String,List<Date>>> hm1 = hmList.get(s);
			for(String p: hm1.keySet())
			{
				//System.out.println(" UserID " + p);
				HashMap<String,List<Date>> hm2 = hm1.get(p);
				for(Map.Entry<String, List<Date>> entry: hm2.entrySet())
				{
					String key = entry.getKey();
					//System.out.println("door name : " + key);
					for(Date dt: entry.getValue())
					{
					//	System.out.println(" date : " + dt);
					}
				}
			}
		}
		
		//. comparision
		arrCusList1.clear();
		arrCusList3.clear();
		for(String s: hmList.keySet())
		{
			HashMap<String,HashMap<String,List<Date>>> hm1 = hmList.get(s);
			for(String p: hm1.keySet())
			{		
				HashMap<String,List<Date>> hm2 = hm1.get(p);
				for(Map.Entry<String, List<Date>> entry: hm2.entrySet())
				{
					String key = entry.getKey();
					arrDate1 = entry.getValue();
					if(arrDate1.size() == 1)
					{
						for(Date dt: arrDate1)
						{
						if(s.compareTo("2")==0)
						{
							custInfoObj =
									new CustomerInfo(p,sm.format(dt),key,sm.format(dt),"null-up ",s);
						}
						else
						{
							custInfoObj =
									new CustomerInfo(p,sm.format(dt),key,"null-up ",sm.format(dt),s);
						}
						
						arrCusList3.add(custInfoObj);
						}
						
					}
					else
					{
						Collections.sort(arrDate1);
						arrDate1.add(new Date());
						k = arrDate1.size();
						for(int nI = 0; nI < (k-1); nI++)
						{
							for(int nJ = nI +1; nJ < k; nJ++)
							{
								long d1 = arrDate1.get(nI).getTime();
								long d2 = arrDate1.get(nJ).getTime();
								diff = (d2 - d1)/1000;
								if(diff > 30)
								{
									if(s.compareTo("2") == 0)
									{
										custInfoObj =
												new CustomerInfo(p,sm.format(arrDate1.get(nI)),key,sm.format(arrDate1.get(nI)),"null",s);
									}
									else
									{
										custInfoObj =
												new CustomerInfo(p,sm.format(arrDate1.get(nI)),"null",key,sm.format(arrDate1.get(nI)),s);
									}
									arrCusList3.add(custInfoObj);
									arrDate2.add(arrDate1.get(nI));
									
									 
								}
								break;
								
								
							}
						}
						arrDate1.clear();
						for(Date dt1 : arrDate2)
						{
							arrDate1.add(dt1);
						}
						
					}					
				}
			}
		}
		for(CustomerInfo info4: arrCusList3)
		{
			System.out.println(info4.Result1());
		}
		
		
		
	}

}
