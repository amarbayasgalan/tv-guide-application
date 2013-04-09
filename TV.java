package com.example.mysqliteexample;

public class TV {
  
	int tv_id;
	String tv_name;
	
	public TV(){
		
	}
	
	// constructor
	public TV (int tv_id, String tv_name){
		this.tv_id = tv_id;
		this.tv_name = tv_name;
	}
	 // getting ID
    public int getTV_ID(){
        return this.tv_id;
    }
    // setting id
    public void setTV_ID(int tv_id){
        this.tv_id = tv_id;
    }
    // getting name
    public String getTV_NAME(){
        return this.tv_name;
    }
    // setting name
    public void setTV_NAME(String tv_name){
        this.tv_name = tv_name;
    }
    
}
