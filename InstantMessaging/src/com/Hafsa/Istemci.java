package com.Hafsa;
import java.io.*;
import java.net.*;

public class Istemci {

	public static void main(String[] args) {
		Const cons=new Const();
		Socket istemciSoket=null;
		DataInputStream dStream=null;
		PrintStream pStream=null;
		DataInputStream inputline=null;
		try {
			istemciSoket=new Socket(cons.SERVER_IP,cons.PORT);
			pStream=new PrintStream(istemciSoket.getOutputStream());
			dStream=new DataInputStream(istemciSoket.getInputStream());
			inputline=new DataInputStream(new BufferedInputStream(System.in));
			
		} 
		catch(UnknownHostException e){
			System.err.println("Sunucu bulunamadý.");
		}
		catch(IOException e){
			System.err.println("Sunucu baðlanmadý.");
		}
		if(istemciSoket !=null && dStream!=null && pStream!=null)
		{
			try {
				String satir;
				pStream.println(inputline.readLine());
				while((satir=dStream.readLine())!=null)
				{
					System.out.println(satir);
					if(satir.indexOf("ACK") !=-1)
					{
						break;
					}
				}
				pStream.println(inputline.readLine());
			} 
			catch (UnknownHostException e) {
				System.err.println("sunucu bulunamadý.");
			}
			catch (IOException e) {
				System.err.println("sunucu baðlanamadý.");
			}
			
		}
		
	}
}
