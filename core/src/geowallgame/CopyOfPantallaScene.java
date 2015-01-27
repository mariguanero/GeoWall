package geowallgame;

import java.util.ArrayList;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.majiba.geowall.GeoWallPrin;
import com.majiba.geowall.Pantalla;

public class CopyOfPantallaScene /*extends Pantalla*/{
	
	private Stage escenario;
	private Actor figura;//, fondo,figuraprueba= new ActorFigura(12);
	private int contador=0;
	private int nivel = 15;

	private ArrayList<Actor> Actores = new ArrayList<Actor>(); 

	public CopyOfPantallaScene(GeoWallPrin game) {
		//super(game);
		
				
		escenario = new Stage(new ScreenViewport());
		Gdx.input.setInputProcessor(escenario);
		
		
		for(int i=0;i<nivel;i++){
			figura= new ActorFigura(i);
			Actores.add(figura);
			if(i==0){
				figura.setVisible(true);
			}else{
				figura.setVisible(false);
			}			
			escenario.addActor(Actores.get(i));	
		}
		
		//controlarJuego();

		
	}

	/*@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		super.render(delta);
		
		renderizarJuego();		
						
	}
	
	public void renderizarJuego(){
		Gdx.gl.glClearColor(0.7f, 0.7f, 0.7f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);		
		escenario.draw();
		escenario.act();
		
	}
	
	public void controlarJuego(){
		//Creamos una sequencia
		
		escenario.addCaptureListener(new InputListener() {
			@Override
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				//Actores.get(0).addAction(Actions.color(Color.GREEN, 1));
				return true;
			}
			
			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {				
				//Actores.get(0).addAction(Actions.color(Color.GREEN, 1));
				
    			escenario.getActors().items[contador].setVisible(false);// removeValue(Actores.get(contador), true);
				contador++;
    			if(contador>nivel-1){	
    				contador=0;
    			}
    			escenario.getActors().items[contador].setVisible(true);
    			//figura= new ActorFigura(2);
    			System.out.println("llega aqui "+contador);
    			//miCoche.setTexture(textura);
    			//escenario.addActor(figura);
    			
				System.out.println("hola juasman");
			}
		});
		/*if(Gdx.input.isTouched()){
			contador++;
			if(contador>15){
				contador=0;
			}
			//escenario.getActors().items[contador].setVisible(true);
			System.out.println("hola...hola Caracola");
		}
	}

	@Override*/
	/*public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
		//figura.clear();
	}*/
	
	

	
}

