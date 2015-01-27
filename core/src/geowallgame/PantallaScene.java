package geowallgame;

import internet.Conexion;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.majiba.geowall.GeoWallPrin;
import com.majiba.geowall.Pantalla;
import com.majiba.geowall.Usuario;

public class PantallaScene extends Pantalla{
	
	//Creo el escenario, en el cual introduciremos dos actores ( figuras y fondo o muro)
	private Stage escenario;
	//Obtengo o creo el Usuario;
	private Usuario usu;
	
	//Contador
	private int contador=0, repeticiones=0;
	//puntos
	private int puntos=0;
	//intentos
	//private int intentosdiarios=5;
	//Nivel
	//private int nivel = 5;
	//Array de Actores, El tamaño del array es el nivel
	private Array<Actor> Actores = new Array<Actor>();
	private ActorFigura figura;
	private int velocidad = Gdx.graphics.getHeight()/300;


	private ActorFondo fondo, fondo1 ;
	
	
	public PantallaScene(GeoWallPrin game, Usuario user) {
		super(game,user);
		
				
		escenario = new Stage(new ScreenViewport() );
		usu = user;
		//Le añadimos el inputProcessor estos nos permite llamar a los eventos y metodos
		//listener

		//Este Metodo nos controlara el Fondo
		creoFondo();

		//Definimos el Array de Actores o Figuras
		iniciaFiguras();
		
		//Este Metodo nos controlara la parte cambiar de figura al tocar la pantalla		
		controlarFiguras();		

	}

	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		super.render(delta);
		//Este metodo limpia refresca la pantalla
		renderizarJuego();		
		
		
						
	}
	
	public void renderizarJuego(){
		
		Gdx.gl.glClearColor(0.2f, 0.2f, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		Gdx.input.setInputProcessor(escenario);

		controlaFondo();
		muestroPuntuacion();
	
		//game.batch.dispose();
		escenario.draw();
		
		escenario.act();
		
		
		
	}
	//Controlo que vaya bajando el juego
	public void controlaFondo(){
		int varayuda= fondo.getValory()-(velocidad);
		
		//Compruebo que el fondo haya llegado abajo
		if (varayuda<=0){			
			for(int i=0;i<Actores.size;i++){
				if(Actores.get(i).isVisible()){
					this.figura=(ActorFigura)Actores.get(i);
					//figura.setVisible(false);
				}
			}
			//Compruebo que el sean la misma figura
			if(this.fondo.getValor()== this.figura.getValor()){
				repeticiones++;
				if(repeticiones%3==0){
					//usu.setNivel(repeticiones/3);
					velocidad+= repeticiones/3;
				}
				System.out.println("Enorabuena");
				puntos+=100;
				//escenario.dispose();
				
				System.out.println("Usted lleva "+puntos+" puntos");

				//Oculto el fondo anterior
				for(int i =0; i < escenario.getActors().size;i++){
					if(escenario.getActors().items[i]==fondo){
						fondo.setVisible(false);
						//fondo1.setVisible(true);
						this.fondo=new ActorFondo(usu.getNivel());						
						fondo.setWidth((Gdx.graphics.getWidth()/6));	
						fondo.setX(Gdx.graphics.getWidth()/3);
						fondo.setColor(Color.BLACK);
						
						fondo1.setValory(Gdx.graphics.getHeight());
						fondo.setValory(Gdx.graphics.getHeight());
						escenario.getActors().set(i, fondo);
					}					 	
				}
				if(puntos/usu.getNivel()>150){
					//usu.setNivel(usu.getNivel()+1);
					System.out.println("Ha subido un nivel");					
				}
			}else{
				//System.out.println("lo Sentimos");
				findepartida();
			}
			
			
			
			//Creo el nuevo fondo de forma Aleatoria
			//creoFondo();
			
			//Inicializo la y a la altura de la pantalla			
			varayuda=Gdx.graphics.getHeight();					
		}
		fondo.setValory(varayuda);
		fondo1.setValory(varayuda);
		
	}
	
	//Creo el Fondo
	public void creoFondo(){
		fondo = new ActorFondo(usu.getNivel());
		fondo.setWidth((Gdx.graphics.getWidth()/6));	
		fondo.setX(Gdx.graphics.getWidth()/3);
		fondo.setColor(Color.BLACK);
		fondo.setVisible(true);
		fondo1 = new ActorFondo("");
		//fondo1.setWidth(Gdx.graphics.getWidth());	
		fondo1.setX(-Gdx.graphics.getWidth()/2);
		fondo1.setVisible(true);
		//fondo1.setColor(Color.BLUE);
		System.out.println(fondo1.getMifondo().getTexture());
		/*if(escenario.getActors().size>2){
			escenario.getActors().set(1, fondo);
			//escenario.getActors().set(2, fondo1);
		}else{
			escenario.addActor(fondo1);
			escenario.addActor(fondo);
				
		}
		*/escenario.addActor(fondo1);
		escenario.addActor(fondo);
	}
	
	//Metodo que inicia las figuras
	public void iniciaFiguras(){
			
		for(int i=0;i<usu.getNivel();i++){
			figura= new ActorFigura(i);
			figura.setWidth((Gdx.graphics.getWidth()/6));
			figura.setX(Gdx.graphics.getWidth()/3);			
			Actores.add(figura);
			if(i==0){
				figura.setVisible(true);
			}else{
				figura.setVisible(false);
			}			
			escenario.addActor(Actores.get(i));	
		}
		
	}
	
	//Este metodo gestiona El CAMBIO DE Las FIGURAS al pulsar
	public void controlarFiguras(){
		
		
		//Le añadimos un listener o evento al escenario
		//escenario.addCaptureListener(new InputListener() {
		
		escenario.addListener(new InputListener(){
			/*
			 * Estos dos metodos deben ponerse juntos, sin el boolean no se 
			 * realiza el void
			 */
			@Override
			//Cuando este es pulsado se realiza dicha accion
			public boolean touchDown(InputEvent event, float x, float y,
					int pointer, int button) {
				//Actores.get(0).addAction(Actions.color(Color.GREEN, 1));
				return true;
			}
			
			//Cuando este es levantado se realiza dicha accion
			@Override
			public void touchUp(InputEvent event, float x, float y,
					int pointer, int button) {				
    			
				escenario.getActors().items[contador+2].setVisible(false);
				contador=contador+1;
    			if(contador>usu.getNivel()-1){	
    				contador=0;
    			}
    			escenario.getActors().items[contador+2].setVisible(true);
			}
		});	
	}
	
	//metodo termina la partida
	public void findepartida(){
		
		if(puntos>usu.getPuntuacionmax()){
			usu.setPuntuacionmax(puntos);
		}else{
		}
		
		
		if(usu.getIntentos()<0){
			
			//Llevar a la pantalla de los sentimos no puede mas partidas hoy
			//dispose();
			
			Conexion con = new Conexion(game, usu);
			
			game.setScreen(game.listadouser);
			
		}else{
			System.out.println("Ha conseguido "+puntos+" puntos");
			System.out.println("Le quedan "+usu.getIntentos()+" intentos");
			//game.archivito.escribir(usu);
			//usu.guardar(usu);
			
		}
		//Esto debe ser lo ultimo en findepartida ya que en el setIntentos 
		//haremos que se guarde el archivo
		usu.setIntentos(usu.getIntentos()-1);
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
		
		//figura.clear();
		
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
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		super.resize(width, height);
	}
	
	
	public void muestroPuntuacion(){
		Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
		TextField punt = new TextField(""+puntos,skin);
		
		punt.setWidth(Gdx.graphics.getWidth()/8);
		//Le damos un color de fondo en este caso la opacidad es 0 por lo que no se verá
		punt.setColor(0.8f, 0.8f, 0.8f, 0);
		//punt.setColor(0.7f, 0.7f, 0.7f, 0.5f);
		
		//Lo alineamos a la derecha
		punt.setRightAligned(true);
		//Le damos una posicion
		punt.setPosition(Gdx.graphics.getWidth()-punt.getWidth(), Gdx.graphics.getHeight()-(punt.getHeight()));
		//se lo añadimos para que lo dibuje
		escenario.addActor(punt);
		
	}
	
	
	/*
	public boolean keyDown (int keycode) {
		switch(keycode){
			case Keys.BACK:
				game.setScreen(game.ui);
			break;
		}
		
		
		return false;
	
	}
	*/
	
}
