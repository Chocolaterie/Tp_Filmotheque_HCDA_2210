package com.filmotheque.ihm.api.v2;

public class ServiceHelper {

	public static void logService(ServiceResponse response) {
		System.out.println(String.format("Reponse metier : %s - %s", response.code, response.message));
	}
}
