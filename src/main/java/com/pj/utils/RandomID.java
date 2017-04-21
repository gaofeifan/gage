package com.pj.utils;
import java.util.*;
import java.text.*;

/**
 * Created by zywang
 * User: wang
 * Date: 2007-11-15
 * Time: 17:23:32
 */
public class RandomID {
    public String GenTradeId()    {
        String tradeId = "";
        RandomStrg.setCharset("a-zA-Z0-9");
        RandomStrg.setLength("15");
        try {
            RandomStrg.generateRandomObject();
            tradeId=RandomStrg.getRandom();
        } catch (Exception e){
            System.out.println("e = " + e.toString());
        }
        return tradeId;
    }

    public String GenWebId()    {
        String tradeId = "";
        RandomStrg.setCharset("0-9");
        RandomStrg.setLength("10");
        try {
            RandomStrg.generateRandomObject();
            tradeId=RandomStrg.getRandom();
        } catch (Exception e){
            System.out.println("e = " + e.toString());
        }
        return tradeId;
    }
	public String GenOrderId()    {
			
			Calendar c = Calendar.getInstance(Locale.CHINA);
			Date d = c.getTime();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
			return sdf.format(d) + (int)(Math.random() *10);

		}
	/**
	 * 获取订单
	 * @return
	 */
	public String GenSmsId()    {
        String tradeId = "";
        RandomStrg.setCharset("0-9");
        RandomStrg.setLength("8");
        try {
            RandomStrg.generateRandomObject();
            tradeId=RandomStrg.getRandom();
        } catch (Exception e){
            System.out.println("e = " + e.toString());
        }
        return tradeId;
    }
	public static void main(String[] args) {
		RandomID randomId= new RandomID();
		System.out.println(randomId.GenTradeId());
	}
}
