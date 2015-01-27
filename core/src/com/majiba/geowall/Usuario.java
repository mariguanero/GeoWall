package com.majiba.geowall;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import com.badlogic.gdx.*;
import com.badlogic.gdx.files.FileHandle;

public class Usuario implements java.io.Serializable{

	private String nick="", email="", password="";
	//private MAC
	private int nivel;
    private int intentos;
    private int puntuacionmax;
    private Date fechaultimavez;
    private int id;
    boolean sonido, vibracion;
	 

    
    
    
    public Usuario(){
    	
    	
    	//Lectura del archivo
    	boolean existe = Gdx.files.local("archivo.bin").exists();
    	if(existe){
    		Alasaca guardar = new Alasaca();
    		//System.out.println("EL archivo existe");
    		nick = guardar.leer().nick;
    		email = guardar.leer().email;
    		password = guardar.leer().password;
    		id= guardar.leer().id;    		
    		nivel = 15;//guardar.leer().nivel;
    		sonido=	guardar.leer().sonido;
    		vibracion = guardar.leer().sonido;
    		puntuacionmax = guardar.leer().puntuacionmax;
    		fechaultimavez = guardar.leer().fechaultimavez;
    		if(fechaultimavez.getDay()!=new Date().getDay()){
    			intentos=10;
    			fechaultimavez= new Date();
    		}else{
    			intentos = guardar.leer().intentos;
    		}
    		//Debo acer la comprobacion para los intentos
    	}else{
    		
    		nick ="Juasman";
    		email="email@email";
    		password="LaContrasena";
    		nivel=1;
    		id=0;
    		intentos=10;
        	puntuacionmax =0;
        	if(intentos ==0){
        		intentos=10;	
        	}else{
        		System.out.println("El numero de intentos es : "+intentos);
        	}
        	
        	fechaultimavez= new Date();
        	sonido=true;
        	vibracion=true;
        	guardar();
        	
    	}
    	

    	
    }
    
    
   /* public void guardar(Usuario user){
    	guardar.escribir(user);
    }-*/
    
    
    



	public String getNick() {
		return nick;
	}



	public void setNick(String nick) {
		this.nick = nick;
	}



	public int getIntentos() {
		return intentos;
	}



	public void setIntentos(int intentos) {
		
		this.intentos = intentos;
		guardar();
	}



	public int getPuntuacionmax() {
		return puntuacionmax;
	}



	public void setPuntuacionmax(int puntuacionmax) {
		this.puntuacionmax = puntuacionmax;
	}



	public Date getFechaultimavez() {
		return fechaultimavez;
	}



	public void setFechaultimavez(Date fechaultimavez) {
		this.fechaultimavez = fechaultimavez;
	}


    
	public int getNivel() {
		return nivel;
	}




	public void setNivel(int nivel) {		
		this.nivel = nivel;
	}


	public void guardar() {
		Alasaca guardar = new Alasaca();
		guardar.escribir(this);
		
	}
/*

	public void setGuardar(Alasaca guardar) {
		this.guardar = guardar;
	}

    
  */


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public boolean isSonido() {
		return sonido;
	}


	public void setSonido(boolean sonido) {
		this.sonido = sonido;
	}


	public boolean isVibracion() {
		return vibracion;
	}


	public void setVibracion(boolean vibracion) {
		this.vibracion = vibracion;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}  
    
}

