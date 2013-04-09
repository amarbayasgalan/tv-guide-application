package com.example.mysqliteexample;

public class HUTULBUR {
  
	int hutulbur_id;
	String hutulbur_name;
	String hutulbur_time;
	String hutulbur_alert;
	int hutulbur_tv_id;
	
	// constructor
	public HUTULBUR (int hutulbur_id, String hutulbur_name, String hutulbur_time, String hutulbur_alert, int hutulbur_tv_id){
		this.hutulbur_id = hutulbur_id;
		this.hutulbur_name = hutulbur_name;
		this.hutulbur_time = hutulbur_time;
		this.hutulbur_alert = hutulbur_alert;
		this.hutulbur_tv_id = hutulbur_tv_id;
	}
	
	 // getting id
    public int getHUTULBUR_ID(){
        return this.hutulbur_id;
    }
    // setting id
    public void setHUTULBUR_ID(int hutulbur_id){
        this.hutulbur_id = hutulbur_id;
    }
    // getting name
    public String getHUTULBUR_NAME(){
        return this.hutulbur_name;
    }
    // setting name
    public void setHUTULBUR_NAME(String hutulbur_name){
        this.hutulbur_name = hutulbur_name;
    }
    // getting time
    public String getHUTULBUR_TIME(){
        return this.hutulbur_time;
    }
    // setting time
    public void setHUTULBUR_TIME(String hutulbur_time){
        this.hutulbur_time = hutulbur_time;
    }
    // getting alert
    public String getHUTULBUR_ALERT(){
        return this.hutulbur_alert;
    }
    // setting alert
    public void setHUTULBUR_ALERT(String hutulbur_alert){
        this.hutulbur_alert = hutulbur_alert;
    }
    // getting tv_id
    public int getHUTULBUR_TV_ID(){
        return this.hutulbur_tv_id;
    }
    // setting tv_id
    public void setHUTULBUR_TV_ID(int hutulbur_tv_id){
        this.hutulbur_tv_id = hutulbur_tv_id;
    }
}
