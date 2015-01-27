package config;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.delay;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.moveBy;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.parallel;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.run;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;

import javafx.geometry.Bounds;

import sun.font.TextLabel;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.Input.TextInputListener;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.BitmapFont.TextBounds;
import com.badlogic.gdx.graphics.g2d.Gdx2DPixmap;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.CheckBox;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea.TextAreaListener;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.majiba.geowall.GeoWallPrin;
import com.majiba.geowall.Pantalla;
import com.majiba.geowall.Usuario;

public class PantallaConfig extends Pantalla{
		
	private Stage escenariopciones;
	
	Button btnVolv,btnGuardar; 
	TextArea tanick;	
	CheckBox chcksonido, chckvibracion;
	Usuario usu;
	Table tblLayout = new Table();

	// TODO Auto-generated constructor stub
	public PantallaConfig(GeoWallPrin game, Usuario user) {
			super(game, user);
			usu= user;
		
	}


	@Override
	public void pause() {
		// TODO Auto-generated method stub
		super.pause();
	}


	@Override
	public void render(float delta) {
		// TODO Auto-generated method stub
		super.render(delta);
		Gdx.gl.glClearColor(0.3f, 0.3f, 0.3f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		escenariopciones.act();
		escenariopciones.draw();
		
	}


	@Override
	public void show() {
		// TODO Auto-generated method stub
		super.show();
		
		Skin skin = new Skin(Gdx.files.internal("skin/uiskin.json"));
		
		btnVolv = new TextButton("Volver", skin);
		btnVolv.setPosition(0, 0);
		btnVolv.setWidth(Gdx.graphics.getWidth()/2);
		btnVolv.setHeight(50);
		btnVolv.addListener(QueHacemos(false));
		btnGuardar = new TextButton("Aceptar", skin);
		btnGuardar.setPosition(Gdx.graphics.getWidth()/2, 0);
		btnGuardar.setWidth(Gdx.graphics.getWidth()/2);
		btnGuardar.setHeight(50);
		btnGuardar.addListener(QueHacemos(true));
		
		//Definimos el label y el TextArea del nick
		Label tlnick= new Label("NICK: ",skin); 
		tanick= new TextArea(usu.getNick(), skin);
				
		Label tlpunt= new Label("PuntMax: ",skin);
		Label tapunt= new Label(""+usu.getPuntuacionmax(),skin);
		
		chcksonido= new CheckBox("Sonido", skin);
		chcksonido.setChecked(usu.isSonido());
		chckvibracion = new CheckBox("Vibracion", skin);
		chckvibracion.setChecked(usu.isVibracion());
		
		tanick.setColor(0.1f,0.1f,0.1f,0.1f);
		
		
		
		
		// Posicionamos los elementos en una tabla.
			final int w = 300, h = (int) tanick.getHeight(), sep = 20;
			Table tblLayout = new Table();
			
			tblLayout.add(tlnick);
			tblLayout.add(tanick).width(tanick.getWidth()).height(h).space(sep).row();
			tblLayout.add(tlpunt);
			tblLayout.add(tapunt).width(w).height(h).space(sep).row();
			tblLayout.add(chcksonido).width(w).height(h).space(sep);
			tblLayout.add(chckvibracion).width(w).height(h).space(sep).row();
			//tblLayout.setY(Gdx.graphics.getHeight()-tblLayout.getMinHeight());
		
			//escenariopciones.addActor(btnVolv);

			//Para Controlar el Boton de Volver
			//btnVolv.addAction(QueHacemos(0));
			//escenariopciones.addActor(btnVolv);
			escenariopciones = new Stage(new ScreenViewport());
			tblLayout.setFillParent(true);
			escenariopciones.addActor(tblLayout);
			escenariopciones.addActor(btnVolv);
			escenariopciones.addActor(btnGuardar);

			Gdx.input.setInputProcessor(escenariopciones);
			
			
			
			
	}		
	
	
	
	
	//Intento de Volver
	public ChangeListener QueHacemos(final boolean valor){
		
		ChangeListener cambio= new ChangeListener() {
			
	
			@Override
			public void changed(ChangeEvent event, Actor actor) {
				if(valor){
					
					btnGuardar.addAction(
						sequence(
							delay(2 * 0.5f),
						run (new Runnable(){
							public void run (){	
									
									System.out.println("sonido chcksonido "+chcksonido.isChecked());
									if(chcksonido.isChecked()){
										System.out.println("sta activada");
										game.getMusic().play();
									}else{
										System.out.println("sta desactivada");
										game.getMusic().stop();
									}
									//System.out.println("Vibracion chckvibracion "+chckvibracion.);
									
									user.setNick(tanick.getText().toString());
									user.setSonido(chcksonido.isChecked());
									user.setVibracion(chckvibracion.isChecked());
									//Controlo que pantalla se lanza
									
									user.guardar();
									game.setScreen(game.ui);																										
								}
							})
						)
					);
				}else{

					btnVolv.addAction(
						sequence(
							delay(2 * 0.5f),
						run (new Runnable(){
								public void run (){				
									//Controlo que pantalla se lanza
									game.setScreen(game.ui);																										
								}
							})
						)
					);
				}
				
		}
			
				
				
				
		};
		
		return cambio;
		
	}
	

		
}

