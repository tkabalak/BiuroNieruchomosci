/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package nieruchomosci.biuro;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Tomasz
 */
public class server {
        
    private static final int PORT = 50000; 
    private static final int PORTPing = 50001; 
    private static final String HOST = "127.0.0.1";  
        //server
         static Socket socket = null;  
         static Socket socketPing = null;  
           /*static*/ PrintWriter out;
           /*static*/ BufferedReader in;
           boolean statusServera;
    public server() throws IOException{
       
    }
    public boolean is_connect() throws IOException{
        boolean flag;
        
        if(socketPing != null){
            flag= true;
            try {
                
                ping();
                
            } catch (Exception e) {
                socketPing = null;
                System.out.println("null");
            }
            
        }else{
            flag= false;
                ping();
        }
        return flag;
    }
    public void ping() throws IOException{
        socketPing = new Socket(HOST, PORTPing);
                System.out.println("Connection Ping");        
                BufferedReader input = new BufferedReader(new InputStreamReader(socketPing.getInputStream()));        
                PrintWriter output = new PrintWriter(socketPing.getOutputStream(),true); 
                String ping;
                while ((ping = input.readLine()) != null) 
                {
                if(ping.equals("Ping") ){
                    System.out.println("pong");
                output.println("pong");
                output.flush();
                }
                if(ping.equals("Pong") ){
                input.close();
                output.close();
                socketPing.close();
                break;
                
                }
                }
                System.out.print("Close Ping");
    }
    public void connect() throws UnknownHostException, IOException{
        try{
        System.out.println("Attempting to connect to "+HOST+":"+PORT);
        socket = new Socket(HOST, PORT);
        System.out.println("Connection Established");        
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));        
        out = new PrintWriter(socket.getOutputStream(),true); 
        }catch(IOException e){
            System.out.println("Proba połączenia z serverem");
            throw new IOException();
        }
    }
    
    public void readResponse() throws IOException{
        String userInput;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));          
        System.out.println("Response from server:");
        //String input=in.readLine();
        while ((userInput = in.readLine()) != null) {
            System.out.println(userInput);
        }
    }
    
    public boolean Request_Is_userIhaslo(final String login,final String haslo) throws IOException{
connect();
        boolean flaga=false;
        try{
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));      
        out = new PrintWriter(socket.getOutputStream(),true) ;

                        long start = System.currentTimeMillis();  

                        String input = in.readLine();  
                        System.out.println(System.currentTimeMillis() + " Server: " + input);
                            out.println("Is_userIhaslo;"+login+";"+haslo);  
                            out.flush();
                        System.out.println("Poszlo");
                        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        String x=in.readLine();
                        if(x.length() == 4 ){
                            flaga=true;
                        }
                        System.out.println(System.currentTimeMillis() + " Server: " + x );
                        in.close();
                        out.close();
                        socket.close();
        }catch(Exception e){
            Logger.getLogger(server.class.getName()).log(Level.WARNING, null, e);
            
        }
   return flaga;
   
}

public int getUserID(String login) throws IOException{
    connect();
    in = new BufferedReader(new InputStreamReader(socket.getInputStream()));        
        out = new PrintWriter(socket.getOutputStream(),true);  

                        long start = System.currentTimeMillis();  

                        String input = in.readLine();  
                        System.out.println(System.currentTimeMillis() + " Server: " + input);
                            out.println("getUserID;"+login);  
                            out.flush();
                        System.out.println("Poszlo");
                        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        String x=in.readLine();
                        int ID= Integer.parseInt(x);
                        System.out.println(System.currentTimeMillis() + " Server: " + x );
                        in.close();
                        out.close();
                        socket.close();
                        
   return ID;
}

 public boolean Add_user(String login,String haslo,String imie,String nazwisko) throws IOException{
     connect();
     boolean flaga=false;
     in = new BufferedReader(new InputStreamReader(socket.getInputStream()));        
        out = new PrintWriter(socket.getOutputStream(),true);  

                        long start = System.currentTimeMillis();  

                        String input = in.readLine();  
                        System.out.println(System.currentTimeMillis() + " Server: " + input);
                            out.println("add_user;"+login+";"+haslo+";"+imie+";"+nazwisko);  
                            out.flush();
                        System.out.println("Poszlo");
                        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        String x=in.readLine();
                        System.out.print(x);
                        flaga=Boolean.parseBoolean(x);
                        System.out.println(System.currentTimeMillis() + " Server: " + x );
                        in.close();
                        out.close();
                        socket.close();
 return flaga;
 }
    public boolean Add_oferta(int ID_user,String Transakcja,double czynsz,double m2,int pietro,int max_pieter,int rok) throws IOException{
        connect();
     boolean flaga=false;
     in = new BufferedReader(new InputStreamReader(socket.getInputStream()));        
        out = new PrintWriter(socket.getOutputStream(),true);  

                        long start = System.currentTimeMillis();  

                        String input = in.readLine();  
                        System.out.println(System.currentTimeMillis() + " Server: " + input);
                            out.println("add_oferta;"+ID_user+";"+Transakcja+";"+czynsz+";"+m2+";"+pietro+";"+max_pieter+";"+rok);//+";"+panstwo+";"+Wojewodztwo+";"+dzielnica+";"+ulica+";"+rodzaj+";"+stan+";"+okna+";"+ogrzewanie+";"+lazienka+";"+WC+";"+kuchnia+";"+garaz+";"+piwnica+";"+parking+";"+umeblowanie+";"+winda+";"+balkon+";"+zsyp+";"+woda);  
                            out.flush();
                        System.out.println("Poszlo");
                        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        String x=in.readLine();
                        System.out.print(x);
                        flaga=Boolean.parseBoolean(x);
                        System.out.println(System.currentTimeMillis() + " Server: " + x );
                        in.close();
                        out.close();
                        socket.close();
 return flaga; 
    }
    
     public boolean Add_adres(String panstwo,String Wojewodztwo,String dzielnica,String ulica) throws IOException{
        boolean flaga=false;
        connect();
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));        
        out = new PrintWriter(socket.getOutputStream(),true);  

                        long start = System.currentTimeMillis();  

                        String input = in.readLine();  
                        System.out.println(System.currentTimeMillis() + " Server: " + input);
                            out.println("add_adress;"+panstwo+";"+Wojewodztwo+";"+dzielnica+";"+ulica);//+";"+rodzaj+";"+stan+";"+okna+";"+ogrzewanie+";"+lazienka+";"+WC+";"+kuchnia+";"+garaz+";"+piwnica+";"+parking+";"+umeblowanie+";"+winda+";"+balkon+";"+zsyp+";"+woda);  
                            out.flush();
                        System.out.println("Poszlo");
                        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        String x=in.readLine();
                        System.out.print(x);
                        flaga=Boolean.parseBoolean(x);
                        System.out.println(System.currentTimeMillis() + " Server: " + x );
                        in.close();
                        out.close();
                        socket.close();
      return flaga; 
     }
     
     public boolean Add_szczegoly(String rodzaj,String stan,String okna,String ogrzewanie,String lazienka,
                                 String WC,boolean kuchnia,boolean garaz,boolean piwnica,boolean parking,
                                 boolean umeblowanie,boolean winda,boolean balkon,boolean zsyp,boolean woda) throws IOException{
          boolean flaga=false;
        connect();
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));        
        out = new PrintWriter(socket.getOutputStream(),true);  

                        long start = System.currentTimeMillis();  

                        String input = in.readLine();  
                        System.out.println(System.currentTimeMillis() + " Server: " + input);
                            out.println("add_szczegoly;"+rodzaj+";"+stan+";"+okna+";"+ogrzewanie+";"+lazienka+";"+WC+";"+kuchnia+";"+garaz+";"+piwnica+";"+parking+";"+umeblowanie+";"+winda+";"+balkon+";"+zsyp+";"+woda);  
                            out.flush();
                        System.out.println("Poszlo");
                        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                        String x=in.readLine();
                        System.out.print(x);
                        flaga=Boolean.parseBoolean(x);
                        System.out.println(System.currentTimeMillis() + " Server: " + x );
                        in.close();
                        out.close();
                        socket.close();
          return flaga; 
     }
     
}
