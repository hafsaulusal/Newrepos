package com.Hafsa;
import java.io.*;
import java.net.*;

public class Sunucu {
	public static void main(String[] args) {
		Const cons=new Const();
		ServerSocket echoServer=null;
		String line;
		DataInputStream dStream;
		PrintStream pStream;
		Socket istemciSoket=null;
		try {
			echoServer=new ServerSocket(cons.PORT);
		} catch (Exception e) {
			System.out.println("sunucu açýlma hatasý");
		}
		try {
			istemciSoket=echoServer.accept();
			dStream=new DataInputStream(istemciSoket.getInputStream());
			pStream=new PrintStream(istemciSoket.getOutputStream());
			while(true)
			{
				line=dStream.readLine();
				pStream.println("Sunucudan gelen :" + line);
			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
      
}
