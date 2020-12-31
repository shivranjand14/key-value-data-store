package com.datastore.main;

import org.json.simple.JSONObject;


public class DataStoreConsumer {
	public static void main(String[] args) {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("firstName", "Shivranjan");
		jsonObject.put("lastName", "Dharmadhikari");
		jsonObject.put("address", "Karad");
		
		System.out
				.println("========================CREATE ==============================");
		
		
		DataStore myDataStore = new DataStore(
				"C:\\Users\\John\\Documents\\DataStore");
		System.out.println(myDataStore.create("1", jsonObject, 10));// success
		System.out.println(myDataStore.create("1", jsonObject));// failure
		System.out.println(myDataStore.create("1", jsonObject, 10));// failure
		System.out.println(myDataStore.create("2", jsonObject));// success
		System.out.println(myDataStore.create(
				"helloDataStoreThisIsKeyNameValidation", new JSONObject()));// failure
		try {
		
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		System.out.println("====================AFTER WAIT===============");
		jsonObject.put("age", "25");
		System.out.println(myDataStore.create("1", jsonObject, 10));// success
		System.out.println(myDataStore.create("1", jsonObject));// failure
		System.out.println(myDataStore.create("1", jsonObject, 10));// failure
		System.out.println(myDataStore.create("2", jsonObject));// failure

	
		System.out
				.println("==========================READ===============================");

		System.out.println(myDataStore.read("1"));// success
		System.out.println(myDataStore.read("2"));// success
		System.out.println(myDataStore.read("3"));// failure
		System.out.println(myDataStore
				.read("helloDataStoreThisIsKeyNameValidation"));// failure
		try {
			// wait for 10 seconds
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("====================AFTER WAIT===============");
		System.out.println(myDataStore.read("1"));// failure
		System.out.println(myDataStore.read("2"));// success

	
		System.out
				.println("========================DELETE ==============================");
	
		System.out.println(myDataStore.delete("1"));// failure
		System.out.println(myDataStore.delete("2"));// success
		System.out.println(myDataStore.delete("2"));// failure
		System.out.println(myDataStore.delete("3"));// failure
		System.out.println(myDataStore
				.delete("helloDataStoreThisIsKeyNameValidation"));// failure
		
	}
}
