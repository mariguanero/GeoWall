package com.majiba.geowall;

import internet.Conexion;
import geowallgame.PantallaScene;
import ui.PantallaUI;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.files.*;

import config.PantallaConfig;

public class GeoWallPrin extends LwjglApplication {

	public SpriteBatch batch;
	
	private Usuario user;
	//public Pantalla coche;
	//public Pantalla animacion;
	//public Pantalla auto;
	public Pantalla scene2d;
	public Pantalla ui;
	public Pantalla configuracion;
	public Pantalla listadouser;
	
	//para cargar el audio
	private AssetManager ass= new AssetManager();

	private Music music;
	private Sound teclas;
	
	

	@Override
	public void create() {
		user= new Usuario();
		/*
		 *Esto es para controlar como se crea el usuario es temporal
		 **/ 
    		/*System.out.println("String: "+user.getNick());
    		System.out.println("Int: "+user.getIntentos());
    		System.out.println("Date: "+user.getFechaultimavez());
    		System.out.println("Sonido: "+user.sonido);
    		System.out.println("Vibra: "+user.vibracion);
		 */
		// Creamos algunas cosas sencillas...
		batch = new SpriteBatch();
		
		//coche = new PantallaCoche(this);
		//animacion = new PantallaJuego(this);
		//auto = new PantallaAuto(this);
		scene2d = new PantallaScene(this,user);
		ui = new PantallaUI(this,user);
		configuracion = new PantallaConfig(this,user);
		listadouser = new Conexion(this,user);
		setScreen(ui);

	// Compruebo si esta el sonido activado	
		if(user.sonido){
			
			music = Gdx.audio.newMusic(Gdx.files.internal("sonido/gameboyrmx.mp3"));
			music.play();
			music.setLooping(true);
			//music.play();
			music.setVolume(0.5f);	
		}
	}
	//@Override
	/*public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}*/

	@Override
	public Screen getScreen() {
		// TODO Auto-generated method stub
		return super.getScreen();
	}
	
	//Nos devolvera la pantalla o la consola grafica que usamos en el juego
	
	public SpriteBatch getSpriteBach(){
		
		return batch;
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
		//getSpriteBach().end();
		/*if(music.isPlaying()){
			music.dispose();
		}*/

	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		super.pause();
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		super.resume();
	}

	@Override
	public void setScreen(Screen screen) {
		// TODO Auto-generated method stub
		//super.getScreen().dispose();
		/*if(screen==this.listadouser){
			this.listadouser=new Conexion(this,user);
		}*/
		//
		super.setScreen(screen);
		//this.user= new Usuario();
		//dispose();
		
	}

	@Override
	public void render() {
		// TODO Auto-generated method stub
		super.render();
		/*if(user.isSonido()){
			music.play();
			music.setVolume(1);
		}else{
			music.stop();
		}*/
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		super.resize(width, height);
	}

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

	public Music getMusic() {
		return music;
	}

	public void setMusic(Music music) {
		this.music = music;
	}
	
	
	

	
	

}
